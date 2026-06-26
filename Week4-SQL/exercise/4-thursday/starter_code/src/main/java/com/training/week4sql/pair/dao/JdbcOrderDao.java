package com.training.week4sql.pair.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.week4sql.pair.domain.CustomerOrder;
import com.training.week4sql.pair.domain.OrderLine;

/** TODO: implement OrderDao with PreparedStatement only for dynamic values. */
public final class JdbcOrderDao implements OrderDao {
    private final Connection connection;
    private final ProductDao productDao;

    public JdbcOrderDao(Connection connection, ProductDao productDao) {
        this.connection = connection;
        this.productDao = productDao;
    }

    @Override
    public long createOpenOrder(String customerEmail) throws Exception {
        String sql = "INSERT INTO customer_order (customer_email, status) VALUES (?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
     
            ps.setString(1, customerEmail);
            ps.setString(2, "OPEN");

            ps.executeUpdate();
            
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getLong(1);
                }
            }
            throw new Exception("Failed to retrieve generated order ID");
        }
    }

    @Override
    public void addLine(long orderId, int lineNo, long productId, int qty, double unitPrice) throws Exception {

        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0, got: " + qty);
        }
        
        String sql = "INSERT INTO order_line (order_id, line_no, product_id, qty, unit_price) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, orderId);
            ps.setInt(2, lineNo);
            ps.setLong(3, productId);
            ps.setInt(4, qty);
            ps.setDouble(5, unitPrice);
            
            ps.executeUpdate();
        }
    }

    @Override
    public void markPaid(long orderId) throws Exception {
        String sql = "UPDATE customer_order SET status = ? WHERE id = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "PAID");
            ps.setLong(2, orderId);
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("Warning: No order found with ID: " + orderId);
            }
        }
    }

    @Override
    public double computeOrderTotal(long orderId) throws Exception {
        List<OrderLine> lines = linesFor(orderId);
        return lines.stream()
                .mapToDouble(line -> line.qty() * line.unitPrice())
                .sum();
    }

    @Override
    public List<OrderLine> linesFor(long orderId) throws Exception {
        List<OrderLine> lines = new ArrayList<>();
        String sql = "SELECT order_id, line_no, product_id, qty, unit_price FROM order_line WHERE order_id = ? ORDER BY line_no";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lines.add(mapLineRow(rs));
                }
            }
        }
        return lines;
    }

    @Override
    public CustomerOrder findOrder(long orderId) throws Exception {
        String sql = "SELECT id, customer_email, status FROM customer_order WHERE id = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapOrderRow(rs);
                }
            }
        }
        throw new Exception("Order not found: " + orderId);
    }

    private static CustomerOrder mapOrderRow(ResultSet rs) throws Exception {
        return new CustomerOrder(
                rs.getLong("id"),
                rs.getString("customer_email"),
                rs.getString("status"));
    }

    private static OrderLine mapLineRow(ResultSet rs) throws Exception {
        return new OrderLine(
                rs.getLong("order_id"),
                rs.getInt("line_no"),
                rs.getLong("product_id"),
                rs.getInt("qty"),
                rs.getDouble("unit_price"));
    }
}

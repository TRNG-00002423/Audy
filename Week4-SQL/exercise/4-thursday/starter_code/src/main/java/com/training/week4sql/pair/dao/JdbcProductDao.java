package com.training.week4sql.pair.dao;

import com.training.week4sql.pair.domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * TODO (Pair A): finish all methods using PreparedStatement + try-with-resources.
 */
public final class JdbcProductDao implements ProductDao {
    private final Connection connection;

    public JdbcProductDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public long insert(Product product) throws Exception {
        String sql = "INSERT INTO product (sku, name, price, stock_qty) VALUES (?, ?, ?, ?)";
    
        try (PreparedStatement ps = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
        
            ps.setString(1, product.sku());
            ps.setString(2, product.name());
            ps.setDouble(3, product.price());
            ps.setInt(4, product.stockQty());
            
            ps.executeUpdate();
            
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getLong(1);
                }
            }
            throw new Exception("Failed to retrieve generated product ID");
        }
    }

    @Override
    public Optional<Product> findBySku(String sku) throws Exception {
        String sql = "SELECT id, sku, name, price, stock_qty FROM product WHERE sku = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, sku);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() throws Exception {
        List<Product> out = new ArrayList<>();
        String sql = "SELECT id, sku, name, price, stock_qty FROM product ORDER BY id";
        try (PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                out.add(mapRow(rs));
            }
        }
        return out;
    }

    @Override
    public void updateStock(String sku, int newQty) throws Exception {
        String sql = "UPDATE product SET stock_qty = ? WHERE sku = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, newQty); 
            ps.setString(2, sku);     
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected == 0) {
                System.out.println("Warning: No product found with SKU: " + sku);
            }
        }
    }

    @Override
    public void deleteBySku(String sku) throws Exception {
        String sql = "DELETE FROM product WHERE sku = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, sku);
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected == 0) {
                System.out.println("Warning: No product found to delete with SKU: " + sku);
            }
        }
    }

    private static Product mapRow(ResultSet rs) throws Exception {
        return new Product(
                rs.getLong("id"),
                rs.getString("sku"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getInt("stock_qty"));
    }
}

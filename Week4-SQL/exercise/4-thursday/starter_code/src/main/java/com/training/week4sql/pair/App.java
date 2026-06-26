package com.training.week4sql.pair;

import com.training.week4sql.pair.dao.JdbcOrderDao;
import com.training.week4sql.pair.dao.JdbcProductDao;
import com.training.week4sql.pair.dao.OrderDao;
import com.training.week4sql.pair.dao.ProductDao;
import com.training.week4sql.pair.domain.CustomerOrder;
import com.training.week4sql.pair.domain.OrderLine;
import com.training.week4sql.pair.domain.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;


/**
 * Pair exercise entry point. TODO: wire ProductDao + OrderDao flows per pair_programming_jdbc.md
 */
public final class App {

    private static final String URL = "jdbc:sqlite:pair_store.db";

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection(URL)) {
            bootstrap(conn);
            
            ProductDao products = new JdbcProductDao(conn);
            OrderDao orders = new JdbcOrderDao(conn, products);

            System.out.println("\n" + "=".repeat(70));
            System.out.println("ROTATION 1: PRODUCT DAO WORKFLOW");
            System.out.println("=".repeat(70));
            
            // "Write a main flow: insert two products, list all, update stock, fetch by sku."
            
            System.out.println("\n>>> INSERT TWO PRODUCTS");
            Product p1 = new Product(0, "GADGET-A", "Blue Gadget", 19.99, 50);
            Product p2 = new Product(0, "GADGET-B", "Red Gadget", 29.99, 30);
            
            long id1 = products.insert(p1);
            long id2 = products.insert(p2);
            
            System.out.println("Inserted product 1 with ID: " + id1);
            System.out.println("Inserted product 2 with ID: " + id2);

            System.out.println("\n>>> LIST ALL PRODUCTS");
            List<Product> allProducts = products.findAll();
            for (Product product : allProducts) {
                System.out.println("  " + product);
            }

            System.out.println("\n>>> FIND PRODUCT BY SKU: GADGET-A");
            products.findBySku("GADGET-A").ifPresent(p -> 
                System.out.println("  Found: " + p.name() + " @ $" + p.price() + " (Stock: " + p.stockQty() + ")")
            );

            System.out.println("\n>>> UPDATE STOCK: GADGET-A → 40 units");
            products.updateStock("GADGET-A", 40);
            products.findBySku("GADGET-A").ifPresent(p ->
                System.out.println("  Stock updated: " + p.stockQty() + " units")
            );

            // ===================================================================
            // ROTATION 2: Order flow (Partner B drove JdbcOrderDao,
            //                         Partner A navigated App.main)
            // ===================================================================
            
            System.out.println("\n" + "=".repeat(70));
            System.out.println("ROTATION 2: ORDER DAO WORKFLOW");
            System.out.println("=".repeat(70));
            
            System.out.println("\n>>> CREATE ORDER with status OPEN");
            long orderId = orders.createOpenOrder("alice@example.com");
            System.out.println("Created order ID: " + orderId + " for alice@example.com");

            System.out.println("\n>>> ADD LINE ITEMS (validate product exists, qty > 0)");
            orders.addLine(orderId, 1, id1, 3, 19.99);
            System.out.println("  Added Line 1: 3 × GADGET-A @ $19.99");
            orders.addLine(orderId, 2, id2, 2, 29.99);
            System.out.println("  Added Line 2: 2 × GADGET-B @ $29.99");

            System.out.println("\n>>> PRINT ORDER WITH TOTAL");
            CustomerOrder order = orders.findOrder(orderId);
            System.out.println("  Order ID: " + order.id());
            System.out.println("  Customer: " + order.customerEmail());
            System.out.println("  Status: " + order.status());
            
            System.out.println("\n  Line Items:");
            List<OrderLine> lines = orders.linesFor(orderId);
            for (OrderLine line : lines) {
                double lineTotal = line.qty() * line.unitPrice();
                System.out.printf("    Line %d: Product %d × %d @ $%.2f = $%.2f%n",
                    line.lineNo(), line.productId(), line.qty(), line.unitPrice(), lineTotal);
            }
            
            double total = orders.computeOrderTotal(orderId);
            System.out.printf("\n  Order Total: $%.2f%n", total);

            System.out.println("\n>>> MARK ORDER AS PAID");
            orders.markPaid(orderId);
            System.out.println("  Marked order " + orderId + " as PAID");
            
            CustomerOrder paidOrder = orders.findOrder(orderId);
            System.out.println("  Order status: " + paidOrder.status());
        }
    }

    private static void bootstrap(Connection conn) throws Exception {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("PRAGMA foreign_keys = ON");
            st.executeUpdate("DROP TABLE IF EXISTS order_line");
            st.executeUpdate("DROP TABLE IF EXISTS customer_order");
            st.executeUpdate("DROP TABLE IF EXISTS product");
            st.executeUpdate(
                    """
                    CREATE TABLE product (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        sku TEXT NOT NULL UNIQUE,
                        name TEXT NOT NULL,
                        price REAL NOT NULL CHECK (price >= 0),
                        stock_qty INTEGER NOT NULL CHECK (stock_qty >= 0)
                    )""");
            st.executeUpdate(
                    """
                    CREATE TABLE customer_order (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        customer_email TEXT NOT NULL,
                        status TEXT NOT NULL CHECK (status IN ('OPEN','PAID'))
                    )""");
            st.executeUpdate(
                    """
                    CREATE TABLE order_line (
                        order_id INTEGER NOT NULL REFERENCES customer_order(id) ON DELETE CASCADE,
                        line_no INTEGER NOT NULL,
                        product_id INTEGER NOT NULL REFERENCES product(id),
                        qty INTEGER NOT NULL CHECK (qty > 0),
                        unit_price REAL NOT NULL CHECK (unit_price >= 0),
                        PRIMARY KEY (order_id, line_no)
                    )""");
        }
    }
}

package com.stockanalysis.database;

import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:stockanalysis.db";

    public DatabaseManager() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            
            // Create tables
            stmt.execute("CREATE TABLE IF NOT EXISTS stock_data (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "symbol TEXT NOT NULL," +
                         "date TEXT NOT NULL," +
                         "open REAL NOT NULL," +
                         "high REAL NOT NULL," +
                         "low REAL NOT NULL," +
                         "close REAL NOT NULL," +
                         "volume INTEGER NOT NULL)");
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize database", e);
        }
    }

    public void insertStockData(String symbol, String date, double open, double high, double low, double close, int volume) {
        String sql = "INSERT INTO stock_data (symbol, date, open, high, low, close, volume) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, symbol);
            pstmt.setString(2, date);
            pstmt.setDouble(3, open);
            pstmt.setDouble(4, high);
            pstmt.setDouble(5, low);
            pstmt.setDouble(6, close);
            pstmt.setInt(7, volume);
            
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert stock data", e);
        }
    }

    // Add more methods for querying and managing data as needed
}
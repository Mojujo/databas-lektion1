package se.oscar;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = JDBCUtil.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "INSERT INTO person (first_name, last_name, gender, dob, income) " +
                    "VALUES ('Goober', 'Thing', 'M', '1985-08-24', 75000.00)";

            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println("Rows affected: " + rowsAffected);
            conn.commit();
        } catch (SQLException e) {
            LoggerUtil.logError("Connection error", e);
        }
    }
}
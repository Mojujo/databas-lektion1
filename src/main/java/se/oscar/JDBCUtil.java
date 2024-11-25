package se.oscar;

import java.sql.*;

public class JDBCUtil {
    public static Connection getConnection() throws SQLException {
        Driver hsqlDriver = new org.hsqldb.jdbcDriver();
        DriverManager.registerDriver(hsqlDriver);
        String dbURL = "jdbc:hsqldb:hsql://localhost/jdbclab";
        String dbUser = "sa";
        String dbPassword = "";
        Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
        conn.setAutoCommit(false);
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            LoggerUtil.logError("Error closing connection", e);
        }
    }

    public static void closeStatement(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            LoggerUtil.logError("Error closing statement", e);
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            LoggerUtil.logError("Error closing resultSet", e);
        }
    }

    public static void commit(Connection conn) {
        try {
            if (conn != null) {
                conn.commit();
            }
        } catch (SQLException e) {
            LoggerUtil.logError("Error committing", e);
        }
    }

    public static void rollback(Connection conn) {
        try {
            if (conn != null) {
                conn.rollback();
            }
        } catch (SQLException e) {
            LoggerUtil.logError("Error rolling back", e);
        }
    }
}

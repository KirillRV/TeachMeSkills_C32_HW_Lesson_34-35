package by.tms.executor;
import by.tms.database.DatabaseConnection;

import java.sql.*;

public class SqlExecutor {

    public static void executeSql(String sql) {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("SQL запрос выполнен успешно: " + sql);
        } catch (SQLException e) {
            System.err.println("Ошибка выполнения SQL запроса: " + e.getMessage() + "  Запрос: " + sql);
        }
    }

    public static ResultSet executeQuery(String sql) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            return statement.executeQuery(sql);
        }
    }

    public static void main(String[] args) throws SQLException {
        executeSql("CREATE TABLE IF NOT EXISTS test (id SERIAL PRIMARY KEY, name VARCHAR(255))");
        try (ResultSet rs = executeQuery("SELECT * FROM test")) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        }
    }
}
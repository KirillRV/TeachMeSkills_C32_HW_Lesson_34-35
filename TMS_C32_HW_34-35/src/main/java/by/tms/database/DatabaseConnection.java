package by.tms.database;
import java.sql.*;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/databse-32";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("Соединение с базой данных установлено!");
        } catch (SQLException e) {
            System.err.println("Ошибка подключения к базе данных: " + e.getMessage());
        }
    }
}
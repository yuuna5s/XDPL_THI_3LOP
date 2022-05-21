package DAL;

import java.sql.*;

public class DatabaseManager {
    static Connection connection;
    static Statement statement;
    static PreparedStatement preparedStatement;

    public static void ConnectDB(){
        String host = "jdbc:mysql://localhost:3306/";
        String dbName = "xdpl";
        String userName = "root";
        String password = "";

        try {
            connection = java.sql.DriverManager.getConnection(host + dbName + "?useUnicode=yes&characterEncoding=UTF-8", userName, password);
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            System.err.println("Error connecting to database");
            throwables.printStackTrace();
        }
    }

    public static ResultSet readTable(String tableName, String WHERE, String orderBy){
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM " + tableName + " WHERE " + WHERE + " ORDER BY " + orderBy;
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            System.err.println("Error selecting from database");
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public static ResultSet selectReadTable(String tableName, String SELECT, String WHERE, String orderBy){
        ResultSet resultSet = null;
        try {
            String query = "SELECT " + SELECT + " FROM " + tableName + " WHERE " + WHERE + " ORDER BY " + orderBy;
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            System.err.println("Error selecting from database");
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public static boolean insertRow(String tableName, String[] columnNames, String[] values){
        try {
            String query = "INSERT INTO " + tableName + " (";
            for (int i = 0; i < columnNames.length; i++) {
                query += columnNames[i];
                if (i != columnNames.length - 1) {
                    query += ", ";
                }
            }
            query += ") VALUES (";
            for (int i = 0; i < values.length; i++) {
                query += "'" + values[i] + "'";
                if (i != values.length - 1) {
                    query += ", ";
                }
            }
            query += ")";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            System.err.println("Error inserting into database");
            throwables.printStackTrace();
            return false;
        }
    }

    public static boolean updateRow(String tableName, String[] columnNames, String[] values, String WHERE){
        try {
            String query = "UPDATE " + tableName + " SET ";
            for (int i = 0; i < columnNames.length; i++) {
                query += columnNames[i] + " = '" + values[i] + "'";
                if (i != columnNames.length - 1) {
                    query += ", ";
                }
            }
            query += " WHERE " + WHERE;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            System.err.println("Error updating database");
            throwables.printStackTrace();
            return false;
        }
    }

    public static boolean deleteRow(String tableName, String WHERE){
        try {
            String query = "DELETE FROM " + tableName + " WHERE " + WHERE;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            System.err.println("Error deleting from database");
            throwables.printStackTrace();
            return false;
        }
    }

    public static void CloseDB(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

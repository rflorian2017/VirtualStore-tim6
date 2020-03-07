package db;

import constant.Constants;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will handle the connection and interaction with the database
 */
public class DatabaseWrapper {
    private Connection connection;

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/virtual_store",
                Constants.DB_USERNAME,
                Constants.DB_PASSWORD);
        System.out.println("Successfully connected");
    }

    public void createCustomerTable() throws SQLException {
        Statement statement = connection.createStatement();
        String createCustomerTableQuery =
                "CREATE TABLE IF NOT EXISTS customer " +
                        "(" +
                        "id INT PRIMARY KEY AUTO_INCREMENT," +
                        "name TEXT NOT NULL" +
                        ");";
        statement.executeUpdate(createCustomerTableQuery);

    }

    public void insertIntoCustomer(Customer customer) throws SQLException {
        String insertQuery = "INSERT INTO customer (name) VALUES (?);";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, customer.getName());

        preparedStatement.executeUpdate();
    }

    public void updateCustomerName(int id, String newName) throws SQLException {
        String searchQuery = "UPDATE customer SET name = ? WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(searchQuery);
        preparedStatement.setString(1, newName);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();

    }

    public void deleteCustomerByName(String name) throws SQLException {
        String deleteQuery = "DELETE FROM customer WHERE name = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();

    }

    public void deleteAll(String table) throws SQLException {
        String deleteQuery = "DELETE FROM " + table + ";";
        Statement statement = connection.createStatement();
        statement.executeUpdate(deleteQuery);
    }

    public void dropTable(String table) throws SQLException {
        String deleteQuery = "DROP TABLE " + table + ";";
        Statement statement = connection.createStatement();
        statement.executeUpdate(deleteQuery);
    }

    public List<Customer> showAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<Customer>();

        Statement selectStatement = connection.createStatement();

        ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM customer;");

        while (resultSet.next()) {
            Customer customer = new Customer();

            customer.setName(resultSet.getString("name"));
            customer.setId(resultSet.getInt("id"));

            customers.add(customer);
        }


        return customers;
    }
}

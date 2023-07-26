package dev.osada;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class testDB {
    String dbUrl = "jdbc:postgresql://localhost:5432/TestDB1";
    String dbUsername = "marvin";
    String dbPassword = "marvinlives";
    public short createTableInDatabase() {
        // Replace these with your PostgreSQL database credentials


        try {
            // Register the PostgreSQL driver
            Class.forName("org.postgresql.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            // Create a Statement object
            Statement stmt = conn.createStatement();

            // SQL query to create the table
            String createTableQuery = "CREATE TABLE IF NOT EXISTS my_table (" +
                    "id INTEGER PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "age INTEGER" +
                    ");";

            // Execute the query to create the table
            stmt.executeUpdate(createTableQuery);

            // Close the Statement and Connection
            stmt.close();
            conn.close();

            System.out.println("Table created successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public short insertDataIntoTable(int id, String name, int age) {
        // Replace these with your PostgreSQL database credentials


        try {
            // Register the PostgreSQL driver
            Class.forName("org.postgresql.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            // SQL query to insert data into the table
            String insertQuery = "INSERT INTO my_table (id,name, age) VALUES (?,?,?);";

            // Create a PreparedStatement to safely insert data with parameters
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, 1);
            pstmt.setString(2, "thi");
            pstmt.setInt(3, 12);

            // Execute the query to insert data
            pstmt.executeUpdate();

            // Close the PreparedStatement and Connection
            pstmt.close();
            conn.close();

            System.out.println("Data inserted successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}

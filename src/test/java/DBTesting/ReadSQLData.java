package DBTesting;

import java.sql.*;

public class ReadSQLData {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sk_shopping";
        String username = "root";
        String password = "Saikiran@800";

        try {
            // 🔹 Create connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // 🔹 Create statement
            Statement stmt = conn.createStatement();

            // 🔹 Execute query
            ResultSet rs = stmt.executeQuery("SELECT * FROM registration_details");
     
            // 🔹 Process results
            while (rs.next()) {
                System.out.println("User: " + rs.getString("id"));
            }

            // 🔹 Close connection
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package group_03.java_05;

import database.DBConnector;

import java.sql.*;

// Krijimi i lidhjes me bazen e te dhenave
// Ekzekutimi i pyetesoreve nga kodi
public class Detyra01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBConnector.getConnection();
        String query = """
            INSERT INTO USERS (name, email, age)
            VALUES ('filan', 'filan@gmail.com', 25)
        """;
        Statement statement = connection.createStatement();
        // statement.executeQuery();
        statement.execute(query);
        statement.execute("DELETE FROM USERS WHERE id = 1");
        query = """
                SELECT * FROM USERS
                """;
        ResultSet results = statement.executeQuery(query);
        while(results.next()){
            int id = results.getInt("id");
            String name = results.getString("name");
            String email = results.getString("email");
            int age = results.getInt("age");
            System.out.println("Id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Age: " + age);
            System.out.println("--------");
        }

    }
}

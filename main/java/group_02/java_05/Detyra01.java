package group_02.java_05;

import database.DBConnector;

import java.sql.*;

// Lidhja me bazen e te dhenave
// Leximi dhe shkrimi ne tabelen Users
public class Detyra01 {
    public static void main(String[] args) {
        try{
            Connection connection = DBConnector.getConnection();
            if(connection.isValid(100)){
                System.out.println("DB Connected!");
            }
            String query = "SELECT * FROM USERS";
            Statement statement = connection.createStatement();
//            statement.execute()
            statement.execute("INSERT INTO USERS (name, email, age) VALUES ('user 5', 'user5@gmail.com', 23)");

            statement.execute("DELETE FROM USERS WHERE id = 1");

            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                int id = results.getInt("id");
                String name = results.getString("name");
                String email = results.getString("email");
                int age = results.getInt("age");

                System.out.printf("- Id: %d, name %s, email: %s, age: %d \n",
                        id, name, email, age
                );
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}

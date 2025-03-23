package group_01.java_05;

import database.DBConnector;

import java.sql.*;

// Lidhja me bazen e te dhenave
// Leximi i perdoruesve nga table 'users'
public class Detyra01 {

    public static void main(String[] args){
        try{
            Connection conn = DBConnector.getConnection();
            if(conn.isValid(1000)){
                System.out.println("DB connected!");
            }
            Statement stm = conn.createStatement();
            stm.execute("INSERT INTO USERS (name, email, age)  VALUE ('user 5', 'user_5@gmail.com', 25)");
            stm.execute("DELETE FROM USERS where id = 1");
            ResultSet result = stm.executeQuery("SELECT * FROM USERS");

            while(result.next()){
                int id = result.getInt("id");
                String emri = result.getString("name");
                String email = result.getString("email");
                int age = result.getInt("age");

                System.out.println("ID: "+ id + "Emri: " + emri + " Email: " + email + " Age: " + age);
            }

            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}

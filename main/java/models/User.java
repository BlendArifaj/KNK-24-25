package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int id;
    private String name;
    private String email;
    private int age;

    private User(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public static User getInstance(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String name = result.getString("name");
        String email = result.getString("email");
        int age = result.getInt("age");
        return new User(id, name, email, age);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}

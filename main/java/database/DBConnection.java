package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;
    private static final String DB_URL = "jdbc:mysql://localhost/knk_2025";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static Connection getConnection() {
        if(connection == null){
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }

}

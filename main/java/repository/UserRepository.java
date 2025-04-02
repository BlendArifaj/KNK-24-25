package repository;

import database.DBConnector;
import models.User;
import models.dto.CreateUserDto;
import models.dto.UpdateUserDto;

import java.sql.*;
import java.util.ArrayList;

public class UserRepository {
//    getAll, getById, create, update, delete
    private Connection connection;
    public UserRepository(){
        this.connection = DBConnector.getConnection();
    }
    public ArrayList<User> getAll(){
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM USERS";
        try{
            Statement stm = this.connection.createStatement();
            ResultSet res = stm.executeQuery(query);
            while(res.next()){
                users.add(User.getInstance(res));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }


    public User getById(int id){
        String query = "SELECT * FROM USERS WHERE ID = ?";
        try{
            PreparedStatement pstm = this.connection.prepareStatement(
                    query);
            pstm.setInt(1, id);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                return User.getInstance(res);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public User create(CreateUserDto userDto){
        String query = """
                INSERT INTO 
                USERS (NAME, EMAIL, AGE)
                VALUES (?, ?, ?)
                """;
        try{
            PreparedStatement pstm =
                    this.connection.prepareStatement(
                            query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, userDto.getName());
            pstm.setString(2, userDto.getEmail());
            pstm.setInt(3, userDto.getAge());
            pstm.execute();
            ResultSet res = pstm.getGeneratedKeys();
            if(res.next()){
                int id = res.getInt(1);
                return this.getById(id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public User update(UpdateUserDto userDto){
        String query = """
                UPDATE USERS 
                SET EMAIL = ?
                WHERE ID = ?
                """;
        try{
            PreparedStatement pstm = this.connection.prepareStatement(query);
            pstm.setString(1, userDto.getEmail());
            pstm.setInt(2, userDto.getId());
            int updatedRecords = pstm.executeUpdate();
            if(updatedRecords == 1){
                return this.getById(userDto.getId());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(int id){
        String query = "DELETE FROM USERS WHERE ID = ?";
        try{
            PreparedStatement pstm =
                    this.connection.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate() == 1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}

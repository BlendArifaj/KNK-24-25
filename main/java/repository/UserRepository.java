package repository;

import database.DBConnector;
import models.User;
import models.dto.CreateUserDto;
import models.dto.UpdateUserDto;

import java.sql.*;
import java.util.ArrayList;

public class UserRepository extends BaseRepository<User, CreateUserDto, UpdateUserDto>{

    public UserRepository(){
        super("users");
    }

    public User fromResultSet(ResultSet result) throws SQLException{
        return User.getInstance(result);
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
}

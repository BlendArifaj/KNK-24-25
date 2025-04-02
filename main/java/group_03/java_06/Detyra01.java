package group_03.java_06;

import database.DBConnector;
import models.User;
import models.dto.CreateUserDto;
import models.dto.UpdateUserDto;
import repository.UserRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Detyra01 {
    public static void main(String[] args){
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getById(14);
        if(user != null){
            System.out.println("Id: " + user.getId());
        }
        userRepository.delete(14);
        CreateUserDto userDto = new CreateUserDto(
                "Student 1", "student@gmail.com", 22);
        userRepository.create(userDto);
        UpdateUserDto updateDto = new UpdateUserDto(
                16, "update@gmail.com"
        );
        userRepository.update(updateDto);
    }
}

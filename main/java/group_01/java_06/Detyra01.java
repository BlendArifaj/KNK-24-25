package group_01.java_06;

import database.DBConnector;
import models.User;
import models.dto.CreateUserDto;
import models.dto.UpdateUserDto;
import repository.UserRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Detyra01 {

    public static void main(String[] args){
        try{
            UserRepository userRepository = new UserRepository();
            User user = userRepository.getById(2);
            System.out.println("User id: " + user.getId());

            CreateUserDto dto = new CreateUserDto("Filan Fisteku", "filan@gmail.com", 25);
            User newUser = userRepository.create(dto);
            System.out.println("New user id: " + newUser.getId());

            UpdateUserDto updateDto = new UpdateUserDto(newUser.getId(), "testupdate@gmail.com");
            newUser = userRepository.update(updateDto);

            System.out.println("New user id: " + newUser.getId());
            System.out.println("New user email: " + newUser.getEmail());

            if(userRepository.delete(newUser.getId())){
                System.out.println("User is deleted!");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

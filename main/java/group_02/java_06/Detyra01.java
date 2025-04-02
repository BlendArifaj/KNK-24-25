package group_02.java_06;

import models.User;
import models.dto.CreateUserDto;
import models.dto.UpdateUserDto;
import repository.UserRepository;

public class Detyra01 {
    public static void main(String[] args){
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getById(10);
        System.out.println("Id: " + user.getId());
        System.out.println("Email: " + user.getEmail());

        CreateUserDto userDto = new CreateUserDto(
                "student 1", "student@gmail.com", 22);
        User newUser = userRepository.create(userDto);
        if(newUser != null){
            System.out.println("New user id: " + newUser.getId());
            System.out.println("New user email: " + newUser.getEmail());
        }

        UpdateUserDto updateUserDto = new UpdateUserDto(
                newUser.getId(), "updated@gmail.com");
        newUser = userRepository.update(updateUserDto);

        System.out.println("Update email: " + newUser.getEmail());

        if(userRepository.delete(newUser.getId())){
            System.out.println("User " + newUser.getId() + " deleted!");
        }

    }
}

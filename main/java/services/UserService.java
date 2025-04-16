package services;

import models.Product;
import models.User;
import models.dto.CreateUserDto;
import models.dto.UserBuyProductDto;
import repository.UserRepository;

public class UserService {
    private UserRepository userRepository;
    public UserService(){
        this.userRepository = new UserRepository();
    }
    public User getById(int id) throws Exception{
        if(id <= 0){
            throw new Exception("Id does not exist!");
        }
        User user = this.userRepository.getById(id);
        if(user == null){
            throw new Exception("User with Id: " + id + " does not exist!");
        }
        return user;
    }

    public User create(CreateUserDto createUser) throws Exception{
        if(createUser.getAge() <= 12 || createUser.getName().isEmpty()){
            throw new Exception("Information is not valid! ...");
        }
        User user = this.userRepository.create(createUser);
        if(user == null){
            throw new Exception("User is not created!");
        }
        return user;
    }

}

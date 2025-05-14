package services;

import models.User;

public class LoginService {

    public User loginUser(String username, String password){
//        User user = this.userRepository.getByUsername(username);
//        if(user == null){
//              return null;
//        }
//        String loginHash = HashService.generateHash(password, user.getSalted());
//        boolean isPasswordCorrect = loginHash == user.getSaltedHash();
        User user = new User(1, username, password, 25);
        return user;
    }
}

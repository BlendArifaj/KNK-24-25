package services;

import models.User;

// User: id, username, email, name, salted, saltedHash
// UserRepository: get/ getByUsername / ...
// PasswordHasher/HashService: generateSalt() -> String
//              generateSaltedHash(String password, String salted) -> String

//              compareSaltedHash(String password, String salted, String saltedHash) -> boolean
public class LoginPageService {

    public void login(String username, String password){
//        User user = this.userRepository.getByUsername(username);
//        if(user == null){
//            throw new UnauthorizedException();
//        }
//        String salted = user.getSalted();
//        String saltedHash = user.getSaltedHash();
//
//        String passwordHash = this.hashService.generateSaltedHash(password, salted);
//        if(saltedHash.equals(passwordHash)){
//            return user;
//        }
//
//        boolean isPasswordCorrect = this.hashService.compareSaltedHash(password, salted, saltedHash);
//        if(isPasswordCorrect){
//            return user;
//        }
//
//        throw new UnauthorizedException();
//
//
//
////        null or user
    }
}

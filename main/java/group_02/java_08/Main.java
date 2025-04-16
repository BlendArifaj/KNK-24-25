package group_02.java_08;

import models.User;
import services.UserService;

// Product -> id, emer, price, stock
// UserProduct -> id, user_id, product_id

public class Main {
    public static void main(String[] args){
        UserService userService = new UserService();
        try {
            User user = userService.getById(5);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

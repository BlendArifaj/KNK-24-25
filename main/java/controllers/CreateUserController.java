package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.User;
import models.dto.CreateUserDto;
import services.UserService;

public class CreateUserController {
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAge;

    private UserService userService;

    public CreateUserController(){
        this.userService = new UserService();
    }
    @FXML
    private void handleClearClick(){
        System.out.println("Clear button clicked!");
        this.txtName.setText("");
        this.txtEmail.setText("");
        this.txtAge.setText("");
    }

    @FXML
    private void handleSaveClick(){
        System.out.println("Save button clicked!");
        String name = this.txtName.getText();
        String email = this.txtEmail.getText();
        int age = Integer.parseInt(this.txtAge.getText());
        CreateUserDto userDto = new CreateUserDto(name, email, age);
        try{
            User user = this.userService.create(userDto);
            System.out.println("User with id: " + user.getId() + " is created!");
        }catch (Exception e){
            System.out.println("Error creating a user: " + e.getMessage());
        }
    }
}

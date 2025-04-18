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
    private void handleCancelClick(){
        this.cleanFields();
    }

    @FXML
    private void handleSaveClick(){
        try{
            User user = this.userService.create(this.getUserData());
            System.out.println("User created successfully!");
            System.out.println("User ID: " + user.getId());
            this.cleanFields();
        }catch (Exception e){
            System.out.println("Error while creating user. " + e.getMessage());
        }

    }

    private CreateUserDto getUserData(){
        String name = this.txtName.getText();
        String email = this.txtEmail.getText();
        int age = Integer.parseInt(this.txtAge.getText());

        return new CreateUserDto(name, email, age);
    }

    private void cleanFields(){
        this.txtName.setText("");
        this.txtAge.setText("");
        this.txtEmail.setText("");
    }
}

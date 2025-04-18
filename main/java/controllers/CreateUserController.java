package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.User;
import models.dto.CreateUserDto;
import services.UserService;

public class CreateUserController {
//    txtName, txtEmail, txtAge
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
            User user = this.userService.create(this.getUserInputData());
            System.out.println("User inserted successfully!");
            System.out.println("User Id: " + user.getId());
            this.cleanFields();
        }catch (Exception e){
            System.out.println("Error inserting user. " + e.getMessage());
        }
    }

    private void cleanFields(){
        this.txtName.setText("");
        this.txtEmail.setText("");
        this.txtAge.setText("");
    }

    private CreateUserDto getUserInputData(){
        String name = this.txtName.getText();
        String email = this.txtEmail.getText();
        int age = Integer.parseInt(this.txtAge.getText());
        return new CreateUserDto(name, email, age);
    }

}

package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.User;
import services.LoginService;
import services.SceneManager;
import services.SessionManager;
import utils.SceneLocator;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField pwdPassword;
    @FXML
    private ComboBox<String> cmbRoles;

    private LoginService loginService;
    private SessionManager session;
    public LoginController(){
        this.loginService = new LoginService();
        this.session = SessionManager.getInstance();
    }

    @FXML
    private void handleLoginClick() throws Exception{
        User user = loginService.loginUser(txtUsername.getText(), pwdPassword.getText());
        if(user != null){
            this.session.setCurrentUser(user);
            SceneManager.load(SceneLocator.HOME_PAGE);
        }else{
            System.out.println("Username or password is incorrect!");
        }
    }

    @FXML
    private void handleCancelClick(){
        System.out.println("Test");
    }

    private void fillRoles(){
//        ArrayList<String> roles = roleService.getRoles();
        cmbRoles.getItems().addAll(
                "Admin", "User", "Owner"
                );
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillRoles();
    }
}

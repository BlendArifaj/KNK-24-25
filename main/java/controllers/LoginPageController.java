package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.User;
import services.LoginPageService;
import services.SceneManager;
import services.SessionManager;
import utils.SceneLocator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField pwdPassword;
    @FXML
    private ComboBox<String> cmbLanguage;
    private LoginPageService loginService;
    private SessionManager session;
    private SceneManager sceneManager;
    public LoginPageController(){
        this.loginService = new LoginPageService();
        this.session = SessionManager.getInstance();
    }
    @FXML
    private void handleLoginClick(){
//        String username = this.txtUsername.getText();
//        String password = this.pwdPassword.getText();
//        try {
//            User user = this.loginService.login(username, password);
//            session.setCurrentUser(user);
//            SceneManager.load(SceneLocator.HOME_PAGE);
//        }catch (UnauthorizedException e){
////            Alert / Message / Label
//        }catch (Exception e){
//
//        }

    }

    private void fillComboBox(){
//      ArrayList<String> languages = this.languageRepository.getAll();
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Shqip");
        languages.add("English");
        languages.add("Deutsch");

        this.cmbLanguage.getItems().addAll(languages);
        this.cmbLanguage.setValue(languages.get(0));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillComboBox();
    }
}

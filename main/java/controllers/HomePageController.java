package controllers;

import group_03.java_10.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import services.LanguageManager;
import services.SceneManager;
import utils.SceneLocator;

import java.util.Locale;

public class HomePageController {
    private final LanguageManager languageManager = LanguageManager.getInstance();

    @FXML
    private AnchorPane rightPage;

    @FXML
    private void handleCreateUsersClick() throws Exception{
//        Loads create_user.fxml
//        FXMLLoader loader = new FXMLLoader(
//                getClass().getResource("/group_03/views/create_user.fxml")
//        );
//        Parent parent = loader.load();
//        Main.scene.setRoot(parent);
        SceneManager.load(SceneLocator.CREATE_USER_PAGE);
    }

    @FXML
    private void handleSQLanguageClick() throws Exception{
        loadLanguage(new Locale("sq"));
    }

    @FXML
    private void handleENLanguageClick() throws Exception{
        loadLanguage(Locale.ENGLISH);
    }

    private void loadLanguage(Locale locale) throws Exception{
        languageManager.setLocale(locale);
        SceneManager.reload();
    }

}

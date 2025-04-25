package controllers;

import group_03.java_10.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import services.SceneManager;
import utils.SceneLocator;

public class HomePageController {

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
        SceneManager.load(
                SceneLocator.CREATE_USER_PAGE,
                this.rightPage);
    }
}

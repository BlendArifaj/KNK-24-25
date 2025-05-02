package group_02.java_10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.SceneManager;
import utils.SceneLocator;

import java.io.IOException;

public class Main extends Application {

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
               getClass().getResource(SceneLocator.HOME_PAGE)
        );
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent);

//        SceneManager.initialize(scene);

        stage.setScene(scene);
        stage.show();
    }
}

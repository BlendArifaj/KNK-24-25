package group_01.java_10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.SceneManager;

public class Main extends Application {
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/group_01/views/home.fxml")
        );
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);

//        SceneManager.initialize(scene);

        stage.setScene(scene);
        stage.show();
    }
}

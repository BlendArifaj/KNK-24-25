package group_01.java_12;

import javafx.application.Application;
import javafx.stage.Stage;
import services.SceneManager;

// Session
public class Main extends Application {
    public void start(Stage stage) throws Exception{
        SceneManager sceneManager = SceneManager.getInstance();
        stage.setScene(sceneManager.getScene());
        stage.show();
    }
}


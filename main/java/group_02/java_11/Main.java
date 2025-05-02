package group_02.java_11;

import javafx.application.Application;
import javafx.stage.Stage;
import services.SceneManager;

public class Main extends Application {
    public void start(Stage stage) throws Exception {
        SceneManager sceneManager = SceneManager.getInstance();
        stage.setScene(sceneManager.getScene());
        stage.show();
    }
}

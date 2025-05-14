package group_02.java_12;

import javafx.application.Application;
import javafx.stage.Stage;
import services.SceneManager;

//1. Perdorimi i sessionit

public class Main extends Application {
    public void start(Stage stage) throws Exception {
        SceneManager sceneManager = SceneManager.getInstance();
        stage.setScene(sceneManager.getScene());
        stage.show();
    }
}

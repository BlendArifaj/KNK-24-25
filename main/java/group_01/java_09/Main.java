package group_01.java_09;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(
                Main.class.getResource("create_user.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setScene(scene);
        stage.show();

    }
}

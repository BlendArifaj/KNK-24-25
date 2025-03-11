package group_02.java_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Detyra01 extends Application {

    public void start(Stage stage){
        Pane pane = new Pane();
        Text text = new Text("Ushtrimi i pare ne JavaFX!");
        text.setX(10);
        text.setY(10);
        pane.getChildren().add(text);
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}

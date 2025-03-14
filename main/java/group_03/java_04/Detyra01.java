package group_03.java_04;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Detyra01 extends Application {
    public void start(Stage stage){
//        1. Krijimi i figures
        Circle circle = new Circle(100, 100, 100);
//        2. Logjika e animacionit (eventi)
        EventHandler<ActionEvent> event = new CircleEventHandler(circle);
//        3. Krijimi i KeyFrame
        KeyFrame keyFrame = new KeyFrame(Duration.millis(5), event);
//        4. Krijimi i animacionit
        Timeline animation = new Timeline(keyFrame);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        animation.pause();
        animation.stop();

        Pane pane = new Pane(circle);
        Scene scene = new Scene(pane, 700, 700);
        stage.setScene(scene);
        stage.show();
    }
}


class CircleEventHandler implements EventHandler<ActionEvent>{
    private Circle circle;
    private int stepX = 0;
    private int stepY = 0;
    private boolean clockwise = false;
    public CircleEventHandler(Circle circle){
        this.circle = circle;
    }
    public void handle(ActionEvent ae){
//       this.animation1();
//        this.animation2();
        this.animation3();
    }
    private void animation1(){
        this.circle.setFill(
                new Color(
                        Math.random(), Math.random(), Math.random(), 1
                )
        );
    }
    private void animation2(){
        double x = this.circle.getCenterX();
        double target = 500;
        if(x == 100){
            stepX = 1;
        }else if(x == target){
            stepX = -1;
        }
        this.circle.setCenterX(x + this.stepX);
    }

    private void animation3(){
        double x = this.circle.getCenterX();
        double y = this.circle.getCenterY();
        double target = 500;
        if(x == 100 && y==100){
            this.clockwise = !this.clockwise;
            if(this.clockwise){
                stepX = 1;
                stepY = 0;
            }else{
                stepX = 0;
                stepY = 1;
            }
        }else if(x == target && y == 100){
            if(this.clockwise){
                stepX = 0;
                stepY = 1;
            }else{
                stepX = -1;
                stepY = 0;
            }
        }else if(x == target && y == target){
            if(this.clockwise){
                stepX = -1;
                stepY = 0;
            }else{
                stepX = 0;
                stepY = -1;
            }
        }else if(x == 100 && y == target){
            if(this.clockwise){
                stepX = 0;
                stepY = -1;
            }else{
                stepX = 1;
                stepY = 0;
            }
        }
        this.circle.setCenterX(x + this.stepX);
        this.circle.setCenterY(y + this.stepY);
    }
}







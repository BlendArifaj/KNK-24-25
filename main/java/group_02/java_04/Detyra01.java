package group_02.java_04;

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

//        2. Krijimi i logjikes se animacion-it (event-it)
        EventHandler<ActionEvent> event = new CircleEventHandler(circle);

//        3. Krijimi i keyFrame
        KeyFrame frame = new KeyFrame(Duration.millis(5), event);

//        4. Krijimi i animacionit
        Timeline animation = new Timeline(frame);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        Pane pane = new Pane(circle);
        Scene scene = new Scene(pane, 800, 800);
        stage.setScene(scene);
        stage.show();
    }
}


class CircleEventHandler implements EventHandler<ActionEvent>{
    private Circle circle;
    private int stepX = 1;
    private int stepY = 0;
    private boolean clockwise = false;
    public CircleEventHandler(Circle circle){
        this.circle = circle;
    }
    public void handle(ActionEvent ae){
//       this.animation1();
//        this.animation2();
//        this.animation3();
//        this.animation4();
        this.animation5();
    }

    private void animation1(){
        this.circle.setFill(
                new Color(Math.random(), Math.random(), Math.random(), 1)
        );
    }

    private void animation2(){
       double x = this.circle.getCenterX();
       if(x >= 500){
           this.stepX = -1;
       }else if(x <= 100){
           this.stepX = 1;
       }
       this.circle.setCenterX(x + this.stepX);
    }
    private void animation3(){
        double x = this.circle.getCenterX();
        double y = this.circle.getCenterY();
        if(x == 500 && y == 100){
            this.stepX = 0;
            this.stepY = 1;
        }else if(x == 500 && y == 500){
            this.stepX = -1;
            this.stepY = -1;
        }else if(x== 100 && y == 100){
            this.stepX = 1;
            this.stepY = 0;
        }
        this.circle.setCenterX(x + this.stepX);
        this.circle.setCenterY(y + this.stepY);
    }
    private void animation4(){
        double x = this.circle.getCenterX();
        double y = this.circle.getCenterY();
        if(x == 500 && y == 100){
            this.stepX = 0;
            this.stepY = 1;
        }else if(x == 500 && y == 500){
            this.stepX = -1;
            this.stepY = 0;
        }else if(x== 100 && y == 500){
            this.stepX = 0;
            this.stepY = -1;
        }else if(x== 100 && y == 100){
            this.stepX = 1;
            this.stepY = 0;
        }
        this.circle.setCenterX(x + this.stepX);
        this.circle.setCenterY(y + this.stepY);
    }

    private void animation5(){
        double x = this.circle.getCenterX();
        double y = this.circle.getCenterY();
        if(x == 500 && y == 100){
            if(clockwise){
                this.stepX = 0;
                this.stepY = 1;
            }else{
                this.stepX = -1;
                this.stepY = 0;
            }
        }else if(x == 500 && y == 500){
            if(clockwise){
                this.stepX = -1;
                this.stepY = 0;
            }else{
                this.stepX = 0;
                this.stepY = -1;
            }
        }else if(x== 100 && y == 500){
            if(clockwise){
                this.stepX = 0;
                this.stepY = -1;
            }else{
                this.stepX = 1;
                this.stepY = 0;
            }
        }else if(x== 100 && y == 100){ // ndryshon drejtimi
            this.clockwise = !this.clockwise;
            if(this.clockwise) {
                this.stepX = 1;
                this.stepY = 0;
            }else{
                this.stepX = 0;
                this.stepY = 1;
            }
        }

//        if(clockwise){
//            if(x == 500 && y == 100){
//                this.stepX = 0;
//                this.stepY = 1;
//            }else if(x == 500 && y == 500){
//                this.stepX = -1;
//                this.stepY = 0;
//            }else if(x== 100 && y == 500){
//                this.clockwise = false;
//                this.stepX = 0;
//                this.stepY = -1;
//            }else if(x== 100 && y == 100){
//                this.stepX = 1;
//                this.stepY = 0;
//            }
//        }else{
//            if(x == 500 && y == 100){
//                this.clockwise = true;
//                this.stepX = -1;
//                this.stepY = 0;
//            }else if(x == 500 && y == 500){
//                this.stepX = 0;
//                this.stepY = -1;
//            }else if(x== 100 && y == 500){
//                this.stepX = 1;
//                this.stepY = 0;
//            }else if(x== 100 && y == 100){
//                this.stepX = 0;
//                this.stepY = 1;
//            }
//        }

        this.circle.setCenterX(x + this.stepX);
        this.circle.setCenterY(y + this.stepY);
    }



}

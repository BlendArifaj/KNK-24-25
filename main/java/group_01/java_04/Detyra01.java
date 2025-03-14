package group_01.java_04;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Detyra01 extends Application {

    public void start(Stage stage){
//        1. Krijimi i figures
        Circle circle = new Circle(100, 100, 100);

//        2. Krijimi i logjikes se eventit
        EventHandler<ActionEvent> event = new CircleEventHandler(circle);

//        3. Shkaktimi i eventit ne menyre periodike
        KeyFrame frame = new KeyFrame(Duration.millis(5), event);

//        4. Krijimi i animacionit
//        Timeline animation = new Timeline(frame);
//        animation.setCycleCount(Animation.INDEFINITE);
//        animation.play();


        Fan myFan = new Fan(300, 300, 200, 6);
        EventHandler<ActionEvent> eventFan = new FanEventHandler(myFan);

        KeyFrame frameFan = new KeyFrame(Duration.millis(5), eventFan);

        Timeline animationFan = new Timeline(frameFan);
        animationFan.setCycleCount(Animation.INDEFINITE);
        animationFan.play();


        Pane pane = new Pane(myFan);
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

}

class CircleEventHandler implements EventHandler<ActionEvent>{
    private Circle circle;
    private double stepX = 1;
    private double stepY = 0;
    private boolean reverse = true;

    public CircleEventHandler(Circle circle){
        this.circle = circle;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
//        Color randColor = new Color(
//            Math.random(), Math.random(), Math.random(), Math.random()
//        );
//        this.circle.setFill(randColor);

//        double x = this.circle.getCenterX();
//
//        if(x >= 300){
//            step = -1.0;
//        }else if(x <= 100){
//            step = 1.0;
//        }
//
//        this.circle.setCenterX(x + step);

        double x = this.circle.getCenterX();
        double y = this.circle.getCenterY();

        if(x <= 100 && y <= 100){ // 1
            reverse = !reverse;

            if(reverse){
                this.stepX = 0;
                this.stepY = 1;
            }else{
                this.stepX = 1;
                this.stepY = 0;
            }

            System.out.println("Reverse: " + reverse);
        } else if(x >= 500 && y == 100){ // 2
            if (reverse){
                this.stepX = -1;
                this.stepY = 0;
            }else{
                this.stepX = 0;
                this.stepY = 1;
            }
        }else if(x >= 500 && y >= 500){ // 3
            if(reverse){
                this.stepY = -1;
                this.stepX = 0;
            }else{
                this.stepX = -1;
                this.stepY = 0;
            }
        }else if(x == 100 && y >= 500){ // 4
            if(reverse){
                this.stepX = 1;
                this.stepY = 0;
            }else{
                this.stepX = 0;
                this.stepY = -1;
            }
        }

        System.out.println("---------");
        System.out.println("StepX: " + stepX);
        System.out.println("StepY: " + stepY);
        this.circle.setCenterX(x + stepX);
        this.circle.setCenterY(y + stepY);

    }
}


class Fan extends Pane{
    private int x;
    private int y;
    private int r;
    private int numberOfArcs;

    public Fan(int x, int y, int r, int numberOfArcs){
        this.x = x;
        this.y = y;
        this.r = r;
        this.numberOfArcs = numberOfArcs;
        this.init();
    }

    private double arcSize(){
        return 180 / this.numberOfArcs;
    }

    private void init(){
        super.getChildren().clear();
        for(int i = 0; i < this.numberOfArcs; i++){
            Arc arc = this.createArc(i);
            super.getChildren().add(arc);
        }
    }

    private Arc createArc(int i){
        double startPoint = i * 2 * arcSize();
        Arc arc = new Arc(x, y, r, r, startPoint , arcSize());
        arc.setType(ArcType.ROUND);
        return arc;
    }

}

class FanEventHandler implements EventHandler<ActionEvent>{
    private Pane myFan;
    private int rotate;

    public FanEventHandler(Pane myFan){
        this.myFan = myFan;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        myFan.setRotate(rotate++);
    }
}






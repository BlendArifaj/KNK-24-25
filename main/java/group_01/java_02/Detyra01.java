package group_01.java_02;


import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.List;

/*
Shapes:
    -   Circle
    -   Rectangle
    -   Line
    -   Polygon
    -   Polyline
    -   Arc

Layouts:
    -   Pane
    -   FlowPane
    -   StackPane
    -   VBox
    -   HBox
    -   BorderPane
 */
public class Detyra01 extends Application {

    @Override
    public void start(Stage stage){
        BorderPane pane = new BorderPane();

//        pane.setOrientation(Orientation.VERTICAL);

        Circle circle = new Circle(100, 100, 50);
//        circle.setCenterX();
//        circle.setCenterY();
//        circle.setRadius();
        circle.setFill(null);
        circle.setStroke(Color.BLUE);
        circle.setStrokeWidth(2);

//        pane.getChildren().add(circle);
        List<Node> children = pane.getChildren();
        children.add(circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(200);
        rectangle.setY(100);
        rectangle.setWidth(120);
        rectangle.setHeight(90);

        children.add(rectangle);

        Line line = new Line(0,0, 500, 500);
        line.setStroke(Color.GREEN);
        line.setStrokeWidth(5);
        children.add(line);

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(200.0, 200.0, 180.0, 180.0, 150.0, 300.0,300.0, 450.0);
        children.add(polygon);

        Polyline polyline = new Polyline(
                400, 150, 450, 200, 560, 350
        );
        polyline.setFill(null);
        polygon.setStroke(Color.BISQUE);
        children.add(polyline);

        Arc arc = new Arc();
        arc.setCenterX(500);
        arc.setCenterY(500);
        arc.setRadiusX(100);
        arc.setRadiusY(50);
        arc.setStartAngle(0);
        arc.setLength(90);
        arc.setType(ArcType.ROUND);
        arc.setFill(null);
        arc.setStroke(Color.BROWN);

        children.add(arc);

        Triangle triangle = new Triangle();
        triangle.setPoints(600, 600, 500, 700, 700, 700);
        triangle.setRotate(180);
        triangle.setFill(null);
        triangle.setStroke(Color.GRAY);
        children.add(triangle);

//        CustomRect cr = new CustomRect();

        Scene scene = new Scene(pane, 500, 500);

        stage.setScene(scene);
        stage.show();
    }

}

class Triangle extends Polygon{
    public Triangle(){
        super();
    }

    public void setPoints(double x1, double y1, double x2, double y2, double x3, double y3){
        super.getPoints().addAll(x1, y1, x2, y2, x3, y3);
    }

}
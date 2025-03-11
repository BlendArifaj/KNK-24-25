package group_02.java_02;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/*
Shape:
    -   Circle
    -   Line
    -   Rectangle
    -   Polygon
    -   Polyline
    -   Arc
Layout:
    -   Pane
    -   StackPane
    -   FlowPane
    -   VBox
    -   HBox
    -   BorderPane*
 */

public class Detyra01 extends Application {

    public void start(Stage stage){
        Pane pane = new HBox();
//        pane.setOrientation(Orientation.VERTICAL);
        List<Node> children = pane.getChildren();

        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);
        circle.setFill(null);
        circle.setStroke(Color.GREEN);
        circle.setStrokeWidth(3);
        circle.setRotate(10);
        children.add(circle);

        Line line = new Line(100, 100, 100, 300);
        line.setStroke(Color.GRAY);
        children.add(line);

        Rectangle rectangle = new Rectangle(200, 200, 250, 500);
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        children.add(rectangle);

        Polygon polygon = new Polygon();
        List<Double> points = new ArrayList<>();
        points.add(250.0);
        points.add(250.0);
        points.add(330.0);
        points.add(370.0);
        points.add(400.0);
        points.add(220.0);
        polygon.getPoints().addAll(points);
        polygon.getPoints().addAll(150.0, 120.0, 50.0, 300.0);
        polygon.getPoints().addAll(50.0, 600.0);
        children.add(polygon);

        Polyline polyline = new Polyline(
                400, 400, 500, 625, 390, 620, 250
        );
        polyline.setFill(null);
        polyline.setStroke(Color.BROWN);
        polyline.setStrokeWidth(5);
        children.add(polyline);

        Arc arc = new Arc();
        arc.setCenterX(500);
        arc.setCenterY(200);
        arc.setRadiusX(100);
        arc.setRadiusY(50);
        arc.setStartAngle(0);
        arc.setLength(70);
        arc.setType(ArcType.ROUND);
        arc.setFill(null);
        arc.setStroke(Color.BLUE);
        children.add(arc);

        Triangle triangle = new Triangle(500, 500, 700, 500, 600, 600);
        triangle.setFill(null);
        triangle.setStroke(Color.BLACK);
        children.add(triangle);


//        CustomRect cr = new CustomRect(....);


        Scene scene = new Scene(pane, 700, 700);

        stage.setScene(scene);
        stage.show();
    }

}

class Triangle extends Polygon{
    Triangle(int x1, int y1, int x2, int y2, int x3, int y3){
        super(x1, y1, x2, y2, x3, y3);
    }
    Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
        super(x1, y1, x2, y2, x3, y3);
    }
}



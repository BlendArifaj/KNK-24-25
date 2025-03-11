package group_03.java_02;

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
Layouts:
    -   Pane
    -   StackPane
    -   FlowPane
    -   VBox
    -   HBox
    -   BorderPane*

Shape:
    -   Circle
    -   Rectangle
    -   Line
    -   Polygon
    -   Polyline
    -   Arc
 */

public class Detyra1 extends Application {

    public void start(Stage stage){
//        BorderPane bp = new BorderPane();
//        bp.setTop(pane);

        Pane pane = new VBox();
//        pane.setOrientation(Orientation.VERTICAL);
        List<Node> children = pane.getChildren();

        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(100);
        circle.setFill(null);
        circle.setStroke(Color.BROWN);
        circle.setStrokeWidth(5);
        circle.setRotate(50);
        children.add(circle);

        Rectangle rectangle = new Rectangle(150, 200, 300, 200);
        children.add(rectangle);

        Line line =  new Line(0,0, 700, 700);
        line.setStroke(Color.BLUE);
        line.setRotate(90);
        children.add(line);

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
           150.0, 150.0, 230.0, 180.0, 340.0, 220.0, 500.0, 630.0, 520.0, 350.0
        );
        polygon.setFill(null);
        polygon.setStroke(Color.GRAY);
        children.add(polygon);

        Triangle triangle = new Triangle(500, 500, 700,500, 600, 600);
        triangle.setFill(Color.DARKCYAN);
        triangle.setStroke(Color.GREEN);
        triangle.setRotate(-90);
        children.add(triangle);

        Polyline polyline = new Polyline(
           150, 150,  200, 50, 250, 150, 300, 50, 350, 150, 400, 50, 450, 150
        );
        polyline.setStroke(Color.RED);
        children.add(polyline);

        Arc arc = new Arc();
        arc.setCenterX(600);
        arc.setCenterY(600);
        arc.setRadiusX(200);
        arc.setRadiusY(200);
        arc.setStartAngle(-45);
        arc.setLength(90);
        arc.setFill(null);
        arc.setStroke(Color.BLACK);
        arc.setType(ArcType.ROUND);
        children.add(arc);


//        CustomRect rect = new CustomRect();
//        children.add(rect);

        Scene scene = new Scene(pane, 700, 700);

        stage.setScene(scene);
        stage.show();
    }

}


class Triangle extends Polygon{
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3){
        super(x1, y1, x2, y2, x3, y3);
    }
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
        super(x1, y1, x2, y2, x3, y3);
    }
}
















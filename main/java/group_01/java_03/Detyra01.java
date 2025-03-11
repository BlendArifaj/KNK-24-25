package group_01.java_03;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.List;

public class Detyra01 extends Application {

    public void start(Stage stage){
        Pane pane = new Pane();
        List<Node> children = pane.getChildren();
        Scene scene = new Scene(pane, 1000, 1000);
        int x = 10;
        int y = 10;
        int width = 300;
        int height = 400;
        CustomRect rect = new CustomRect(x, y, width, height);
        rect.setX(20);

        AdvanceCustomRect rect2 = new AdvanceCustomRect(500, 500, 400, 400);
        children.add(rect2);

        children.add(rect);
        stage.setScene(scene);
        stage.show();
    }
}

class CustomRect extends Pane{
    private int x;
    private int y;
    private int width;
    private int height;
    public CustomRect(int x, int y, int width, int height){
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.init();
    }

    private void init(){
//        Rectangle, Line1, Line2
        Rectangle rectangle = this.initRectangle();
        Line line1 = this.initFirstLine();
        Line line2 = this.initSecondLine();
        super.getChildren().clear();
        super.getChildren().addAll(rectangle, line1, line2);
    }

    private Rectangle initRectangle(){
        Rectangle rectangle = new Rectangle(this.x, this.y, this.width, this.height);
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        return rectangle;
    }

    private Line initFirstLine(){
        Line line = new Line(
            this.x + this.width, this.y,  this.x, this.y + this.height
        );
        return line;
    }

    private Line initSecondLine(){
        int x1 = this.x + this.width;
        int y1 = this.y + this.height;
        double x2 = this.x + this.width * 0.5;
        double y2 = this.y + this.height * 0.5;
        return new Line(x1, y1, x2, y2);
    }

    public void setX(int x){
        this.x = x;
        this.init();
    }

}

class AdvanceCustomRect extends Pane{
    private int x;
    private int y;
    private int width;
    private int height;
    private double middleX;
    private double middleY;

    public AdvanceCustomRect(int x, int y, int width, int height) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.middleX = this.x + this.width * 0.5;
        this.middleY = this.y + this.height * 0.5;
        this.init();
    }

    private void init(){
        Triangle triangle1 = this.getTriangle(this.x, this.y, this.width + this.x, this.y);
        Triangle triangle2 = this.getTriangle(this.x + this.width, this.y, this.x + this.width, this.height + this.y);
        Triangle triangle3 = this.getTriangle(this.x + this.width, this.y + this.height, this.x, this.y + this.height);
        Triangle triangle4 = this.getTriangle(this.x, this.y + this.height, this.x, this.y);
        super.getChildren().clear();
        super.getChildren().addAll(triangle1, triangle2, triangle3, triangle4);
    }

    private Color randomColor(){
        return new Color(Math.random(), Math.random(), Math.random(), Math.random());
    }

    private Triangle getTriangle(double x0, double y0, double x1, double y1){
        double x2 = this.middleX;
        double y2 = this.middleY;

        return new Triangle(
                x0, y0, x1, y1, x2, y2, this.randomColor()
        );
    }

    private Triangle getTriangle1(){
        double x0 = this.x;
        double y0 = this.y;
        double x1 = this.x + this.width;
        double y1 = this.y;
        double x2 = this.middleX;
        double y2 = this.middleY;

        return new Triangle(
                x0, y0, x1, y1, x2, y2, this.randomColor()
        );
    }

}
class Triangle extends Polygon{
    public Triangle(double x0, double y0, double x1, double y1, double x2, double y2, Color color){
       super(x0, y0, x1, y1, x2, y2);
       super.setFill(color);
    }
}


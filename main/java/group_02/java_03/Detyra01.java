package group_02.java_03;

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

        CustomRect rect = new CustomRect(
                10, 10, 250, 300);
        children.add(rect);

        CustomRect2 rect2 = new CustomRect2(
                400, 400, 350, 480
        );
        rect2.setX(100);

        children.add(rect2);

        Scene scene = new Scene(pane, 700, 700);
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
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.init();
    }

    private void init(){
        Rectangle rect = this.initRectangle();
        Line line1 = this.initFirstLine();
        Line line2 = this.initSecondLine();
        this.getChildren().addAll(rect, line1, line2);
    }
    private Rectangle initRectangle(){
        Rectangle rectangle = new Rectangle(
          this.x, this.y, this.width, this.height
        );
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        return rectangle;
    }
    private Line initFirstLine(){
        return new Line(
           this.x + this.width, this.y, this.x,
                this.y + this.height
        );
    }
    private Line initSecondLine(){
        double x0 = this.x + this.width * 0.5;
        double y0 = this.y + this.height * 0.5;
        int x1 = this.x + this.width;
        int y1 = this.y + this.height;
        return new Line(x0, y0, x1, y1);
    }
}

class CustomRect2 extends Pane{
    private int x;
    private int y;
    private int width;
    private int height;
    private int centerX;
    private int centerY;

    public CustomRect2(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.init();
    }
    private void initCenterCoordinates(){
        this.centerX = this.x + (int)(this.width * 0.5);
        this.centerY = this.y + (int)(this.height * 0.5);
    }
    private void init(){
        this.initCenterCoordinates();
        Node triangle1 = this.createTriangleWithRandomColor(
            x, y, x+width, y, centerX, centerY
        );
        Node triangle2 = this.createTriangleWithRandomColor(
            x+width, y, x+width, y+height, centerX, centerY
        );
        Node triangle3 = this.createTriangleWithRandomColor(
            x+width, y+height, x, y+height, centerX, centerY
        );
        Node triangle4 = this.createTriangleWithRandomColor(
            x, y+height, x, y, centerX, centerY
        );

        this.getChildren().clear();
        this.getChildren().addAll(
                triangle1,
                triangle2,
                triangle3,
                triangle4
        );
    }

    private Color getRandomColor(){
        return new Color(
                Math.random(), Math.random(), Math.random(), Math.random()
        );
    }

    private Polygon createTriangleWithRandomColor(
            int x0, int y0, int x1, int y1, int x2, int y2
    ){
        Polygon polygon = new Polygon(
                x0, y0, x1, y1, x2, y2
        );
        polygon.setFill(this.getRandomColor());
        return polygon;
    }

    public void setX(int x){
        this.x = x;
        this.init();
    }
}









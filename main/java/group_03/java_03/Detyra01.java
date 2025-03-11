package group_03.java_03;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Detyra01 extends Application {
    public void start(Stage stage){
        Pane pane = new Pane();
//        List<Node> children = pane.getChildren();
        CustomRectangle customRect = new CustomRectangle(
                10, 10, 300, 450
        );
        customRect.setX(50);
        customRect.setY(50);
        customRect.setStroke(Color.GREEN);
        pane.getChildren().addAll(customRect);

        CustomRect2 rect2 = new CustomRect2(
           300, 20, 350, 420
        );
        pane.getChildren().addAll(rect2);

        Scene scene = new Scene(pane, 700, 700);
        stage.setScene(scene);
        stage.show();
    }
}

class CustomRectangle extends Pane {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    public CustomRectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.BLACK;
        this.init();
    }
    private void init(){
        Rectangle rectangle = this.createRectangle();
        Line line1 = this.createFirstLine();
        Line line2 = this.createSecondLine();
        this.getChildren().clear();
        this.getChildren().addAll(
          rectangle, line1, line2
        );
    }
    private Rectangle createRectangle(){
        Rectangle rectangle = new Rectangle(
          this.x, this.y, this.width, this.height
        );
        rectangle.setFill(null);
        rectangle.setStroke(this.color);
        return rectangle;
    }
    private Line createFirstLine(){
        int x0 = this.x + this.width;
        int y0 = this.y;
        int x1 = this.x;
        int y1 = this.y + this.height;
        Line line = new Line(x0, y0, x1, y1);
        line.setStroke(this.color);
        return line;
    }
    private Line createSecondLine(){
        int x0 = this.x + this.width;
        int y0 = this.y + this.height;
        double x1 = this.x + this.width * 0.5;
        double y1 = this.y + this.height * 0.5;
        Line line = new Line(x0, y0, x1, y1);
        line.setStroke(this.color);
        return line;
    }

    public void setX(int x){
        this.x = x;
        this.init();
    }

    public void setY(int y){
        this.y = y;
        this.init();
    }

    public void setStroke(Color color){
        this.color = color;
        this.init();
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getShapeWidth(){
        return this.width;
    }
    public int getShapeHeight(){
        return this.height;
    }
}

class CustomRect2 extends CustomRectangle{
    private int centerX;
    private int centerY;

    public CustomRect2(int x, int y, int width, int height){
        super(x, y, width, height);
        this.init();
    }
    private void setCenterPoint(){
        this.centerX = this.getX() + (int)(this.getShapeWidth() * 0.5);
        this.centerY = this.getY() + (int)(this.getShapeHeight() * 0.5);
    }
    private void init(){
        this.setCenterPoint();
        Node triangle1 = this.createTriangleWithCenterPoint(
              getX(), getY(), getX() + getShapeWidth(), getY()
        );
        Node triangle2 = this.createTriangleWithCenterPoint(
                getX() + getShapeWidth(), getY(), getX()+getShapeWidth(), getY()+getShapeHeight()
        );
        Node triangle3 = this.createTriangleWithCenterPoint(
                getX()+getShapeWidth(), getY()+getShapeHeight(), getX(), getY() + getShapeHeight()
        );
        Node triangle4 = this.createTriangleWithCenterPoint(
                getX(), getY() + getShapeHeight(), getX(), getY()
        );

        this.getChildren().clear();
        this.getChildren().addAll(
                triangle1, triangle2, triangle3, triangle4
        );
    }

    private Color getRandomColor(){
        return new Color(
          Math.random(), Math.random(), Math.random(), Math.random()
        );
    }

    private Polygon createTriangleWithCenterPoint(
            int x0, int y0, int x1, int y1
    ){
        Polygon polygon = new Polygon(
                x0, y0, x1, y1, centerX, centerY
        );
        polygon.setFill(this.getRandomColor());
        return polygon;
    }


}
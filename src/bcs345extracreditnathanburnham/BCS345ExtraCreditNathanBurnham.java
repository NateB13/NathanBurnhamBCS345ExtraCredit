//Nathan Burnham BCS345 Extra Credit Assignment 12/6/21

package bcs345extracreditnathanburnham;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Point2D;

public class BCS345ExtraCreditNathanBurnham extends Application 
{

    @Override
    public void start(Stage stage)
    {
        //Setting up dimensions of the stage
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 400, 400);
        double centerX = pane.getWidth() / 2;
        double centerY = pane.getHeight() / 2;

        //Creating Circle that serves as a border
        double radius = 100.0;
        Circle border = new Circle(centerX, centerY, radius);
        border.setFill(Color.WHITE);
        border.setStroke(Color.BLACK);

        //Circle that will travel around the Border circle.
        double pointRadius = 12.5;
        Circle coloredCircle = new Circle(centerX + radius, centerY, pointRadius);
        coloredCircle.setFill(Color.PURPLE);

        //Detects location when mouse is pressed
        coloredCircle.setOnMousePressed((MouseEvent mouse) -> {            
            coloredCircle.getCenterX();
            mouse.getSceneX();
            coloredCircle.getCenterY();
            mouse.getSceneY();
        });
        
        //Event causes Colored circle to follow mouse cursor
        coloredCircle.setOnMouseDragged((MouseEvent mouse) -> {
            Point2D center = new Point2D(border.getCenterX(), border.getCenterY());
            Point2D mousePos = new Point2D(mouse.getX(), mouse.getY());
            Point2D centerFromMouse = mousePos.subtract(center);
            Point2D centerFromNewPoint = centerFromMouse.normalize().multiply(border.getRadius());
            Point2D newPoint = centerFromNewPoint.add(center);
            coloredCircle.setCenterX(newPoint.getX());
            coloredCircle.setCenterY(newPoint.getY());
            int colorX = (int) newPoint.getX() ;
            if(colorX - 255 > 0)
                colorX = colorX - 255;            
            int colorY = (int) newPoint.getY() ;
            if(colorY - 255 > 0) 
                colorY = colorY - 255;            
            int colorZ = (int) newPoint.getY();
            if(colorZ - 255 > 0) 
                colorZ = colorZ - 255;         
            coloredCircle.setFill(Color.rgb(colorX, colorY, colorZ));
        });
        
        //Showing stage
        pane.getChildren().addAll(border, coloredCircle);
        stage.setTitle("BCS345 Extra Credit Assignment");
        stage.setScene(scene);
        stage.show();
    }

    //Launch code
    public static void main(String[] args) 
    {
        launch(args);
    }

}
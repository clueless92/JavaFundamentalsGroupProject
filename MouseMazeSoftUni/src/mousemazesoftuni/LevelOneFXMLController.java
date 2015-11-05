/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mousemazesoftuni;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.VLineTo;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import static mousemazesoftuni.StartWindowFXMLController.stage;

/**
 * FXML Controller class
 *
 */

public class LevelOneFXMLController implements Initializable, EventHandler<WindowEvent>{
    @FXML
    private Rectangle gameField;
    @FXML
    private Button endButton;
    @FXML
    private Circle circle_1;
    private Path circle_2; 
    @FXML
    private Rectangle rectangle_1;
    @FXML
    private Rectangle rectangle_2;
    @FXML
    private Rectangle rectangle_3;
    @FXML
    private Rectangle rectangle_4;
    @FXML
    private Rectangle rectangle_5;
    @FXML
    private Rectangle rectangle_6_4;
    @FXML
    private Rectangle rectangle_6_3;
    @FXML
    private Rectangle rectangle_6_1;
    @FXML
    private Rectangle rectangle_6_2;
    @FXML
    private Rectangle rectangle_7;
    @FXML
    private Rectangle rectangle_8;
    @FXML
    private Rectangle rectangle_9;
    @FXML
    private ToggleButton startButton;
    @FXML
    private Path outterCircle;
    @FXML
    private Path innerCircle;
    @FXML
    private Arc halfCircle;
    /**
     * Initializes the controller class.
     */
    
    //Scale objects
    ScaleTransition st1 = new ScaleTransition();
    ScaleTransition st2 = new ScaleTransition();
    ScaleTransition st3 = new ScaleTransition();
    
    RotateTransition rt1=new RotateTransition();
    RotateTransition rt2=new RotateTransition();
    RotateTransition rt3=new RotateTransition();
    RotateTransition rt4=new RotateTransition();
    
    //Move objects
    PathTransition pt1=new PathTransition();
    PathTransition pt2=new PathTransition();
    PathTransition pt3=new PathTransition();
    PathTransition pt4=new PathTransition();
    PathTransition pt5=new PathTransition();
    PathTransition pt6=new PathTransition();
    PathTransition pt7=new PathTransition();
   
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
    
    @FXML
    private void toggleStartAction(ActionEvent event) throws IOException {
        if (!startButton.isSelected()) {
            stopGame();
            startButton.setText("START!");
        } else {
            startGame();
            startButton.setText("STOP!");
        }
    }
    private void startGame() {
        st1.setNode(circle_1);
        st1.setDuration(Duration.seconds(2.0));
        st1.setCycleCount(Timeline.INDEFINITE);
        st1.setByX(-2);
        st1.setByY(-2);
        st1.setAutoReverse(true);
        st1.play();
        
        st2.setNode(rectangle_6_1);
        st2.setDuration(Duration.seconds(2.0));
        st2.setCycleCount(Timeline.INDEFINITE);
         st2.setFromX(0.0);
        st2.setToX(200.0);
        st2.setByY(-2);
        st2.setAutoReverse(true);
        st2.play();
        
        st3.setNode(rectangle_6_4);
        st3.setDuration(Duration.seconds(2.0));
        st3.setCycleCount(Timeline.INDEFINITE);
        st3.setByY(-2);
        st3.setAutoReverse(true);
        st3.play();
        
        
        
        Path pt1Path=new Path();
        pt1Path.getElements().add(new MoveTo(30,12));
        pt1Path.getElements().add(new VLineTo(178));
        pt1.setNode(rectangle_1);
        pt1.setDuration(Duration.seconds(2.0));
        pt1.setCycleCount(Timeline.INDEFINITE);
        pt1.setPath(pt1Path);
        pt1.setAutoReverse(true);
        pt1.play();
        
        
        Path pt2Path=new Path();
        pt2Path.getElements().add(new MoveTo(30,12));
        pt2Path.getElements().add(new VLineTo(53));
        pt2.setNode(rectangle_2);
        pt2.setDuration(Duration.seconds(0.7));
        pt2.setCycleCount(Timeline.INDEFINITE);
        pt2.setPath(pt2Path);
        pt2.setAutoReverse(true);
        pt2.play();
               
        Path pt3Path=new Path();
        pt3Path.getElements().add(new MoveTo(30,12));
        pt3Path.getElements().add(new VLineTo(53));
        pt3.setNode(rectangle_3);
        pt3.setDuration(Duration.seconds(0.6));
        pt3.setCycleCount(Timeline.INDEFINITE);
        pt3.setPath(pt3Path);
        pt3.setAutoReverse(true);
        pt3.play();
        
        Path pt4Path=new Path();
        pt4Path.getElements().add(new MoveTo(30,12));
        pt4Path.getElements().add(new VLineTo(53));
        pt4.setNode(rectangle_4);
        pt4.setDuration(Duration.seconds(0.5));
        pt4.setCycleCount(Timeline.INDEFINITE);
        pt4.setPath(pt4Path);
        pt4.setAutoReverse(true);
        pt4.play();
        
        Path pt5Path=new Path();
        pt5Path.getElements().add(new MoveTo(30,24));
        pt5Path.getElements().add(new HLineTo(453));
        pt5.setNode(rectangle_7);
        pt5.setDuration(Duration.seconds(2));
        pt5.setCycleCount(Timeline.INDEFINITE);
        pt5.setPath(pt5Path);     
        pt5.play();
        
        Path pt6Path=new Path();
        pt6Path.getElements().add(new MoveTo(30,24));
        pt6Path.getElements().add(new HLineTo(453));
        pt6.setNode(rectangle_8);
        pt6.setDuration(Duration.seconds(2));
        pt6.setCycleCount(Timeline.INDEFINITE);
        pt6.setPath(pt6Path);     
        pt6.setDelay(Duration.seconds(1));
        pt6.play();
        
        Path pt7Path=new Path();
        pt7Path.getElements().add(new MoveTo(30,24));
        pt7Path.getElements().add(new HLineTo(453));
        pt7.setNode(rectangle_9);
        pt7.setDuration(Duration.seconds(2));
        pt7.setCycleCount(Timeline.INDEFINITE);
        pt7.setPath(pt7Path); 
        pt7.setDelay(Duration.seconds(2));
        pt7.play();

        rt1.setNode(rectangle_5);
        rt1.setDuration(Duration.seconds(2.0));
        rt1.setFromAngle(-20);
        rt1.setByAngle(43);
        rt1.setCycleCount(Timeline.INDEFINITE);
        rt1.setAutoReverse(true);
        rt1.playFrom(Duration.seconds(1.0));
        
        rt2.setNode(circle_2);
        rt2.setDuration(Duration.seconds(3.0));
        rt2.setFromAngle(0);
        rt2.setByAngle(360);
        rt2.setCycleCount(Timeline.INDEFINITE);
        rt2.playFrom(Duration.seconds(1.0));
        
       
        
        rt3.setNode(innerCircle);
        rt3.setDuration(Duration.seconds(4.0));
        rt3.setByAngle(360);
        rt3.setCycleCount(Timeline.INDEFINITE);      
        rt3.playFrom(Duration.seconds(1.0));
        
        rt4.setNode(outterCircle);
        rt4.setDuration(Duration.seconds(7.0));
        rt4.setByAngle(360);
        rt4.setCycleCount(Timeline.INDEFINITE);      
        rt4.playFrom(Duration.seconds(1.0));
        
       
    }
    
     private static boolean contains(Labeled labeled, double x, double y) {
        double tolerance = 2.0;
        double left = labeled.getLayoutX() - tolerance;
        double right = left + labeled.getWidth() + 2 * tolerance;
        double top = labeled.getLayoutY() - tolerance;
        double bottom = top + labeled.getHeight() + 2 * tolerance;
        return left <= x && x <= right && top <= y && y <= bottom;
    }
    private void stopGame(){
        startButton.setSelected(false);
        st1.jumpTo(Duration.ZERO);
        st1.stop();
        
        pt1.jumpTo(Duration.ZERO);
        pt1.stop();
        
        pt2.jumpTo(Duration.ZERO);
        pt2.stop();
        
        pt3.jumpTo(Duration.ZERO);
        pt3.stop();
        
        pt4.jumpTo(Duration.ZERO);
        pt4.stop();
        
        rt1.jumpTo(Duration.seconds(1));
        rt1.stop();
       
    }

    @FXML
    private void onEnd(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LevelTwoFXML.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        //stage.setOnHidden(this);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void close(ActionEvent event) {
        stage.close();
    }

    @Override
    public void handle(WindowEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void onMouseExited(MouseEvent event) throws IOException {
         if (!startButton.isSelected()) {
            return;
        }
        double fieldX = gameField.getLayoutX();
        double fieldY = gameField.getLayoutY();
        double x = event.getX() + fieldX;
        double y = event.getY() + fieldY;
        if (contains(startButton, x, y)) {
            return;
        }
        if (contains(endButton, x, y)) {
            return;
        } 
        stopGame();
        startButton.setText("Start!");
        Parent root = FXMLLoader.load(getClass().getResource("Dialog.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

}

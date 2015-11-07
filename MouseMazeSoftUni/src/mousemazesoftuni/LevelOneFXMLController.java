package mousemazesoftuni;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.VLineTo;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import static mousemazesoftuni.StartWindowFXMLController.stage;

public class LevelOneFXMLController implements Initializable {
    
    @FXML
    private Label chronoLabel;
    @FXML
    private Rectangle gameField;
    @FXML
    private Button endButton;
    @FXML
    private Circle circle_1;
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
    
    //Scale objects
    ScaleTransition st1 = new ScaleTransition();
    ScaleTransition st2 = new ScaleTransition();
    ScaleTransition st3 = new ScaleTransition();
    
    // ROtate objects
    RotateTransition rt1=new RotateTransition();
    RotateTransition rt2=new RotateTransition();
    RotateTransition rt3=new RotateTransition();
    
    //Move objects
    PathTransition pt1=new PathTransition();
    PathTransition pt2=new PathTransition();
    PathTransition pt3=new PathTransition();
    PathTransition pt4=new PathTransition();
    PathTransition pt5=new PathTransition();
    PathTransition pt6=new PathTransition();
    PathTransition pt7=new PathTransition();
    PathTransition pt8=new PathTransition();
    PathTransition pt9=new PathTransition();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void toggleStartAction(ActionEvent event) throws IOException {
        if (!startButton.isSelected()) {
            stopGame();
            startButton.setText("Start");
        } else {
            startGame();
            startButton.setText("Stop");
        }
    }
    private void startGame() {
        hours = 0;
        mins = 0;
        secs = 0;
        String print = String.format(" %02d : %02d : %02d ", hours, mins, secs);
        chronoLabel.setText(print);
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
        
        st1.setNode(circle_1);
        st1.setDuration(Duration.seconds(2.0));
        st1.setCycleCount(Timeline.INDEFINITE);
        st1.setByX(-2);
        st1.setByY(-2);
        st1.setAutoReverse(true);
        st1.play();
        
        st2.setNode(rectangle_6_1);
        st2.setDuration(Duration.seconds(1.7));
        st2.setCycleCount(Timeline.INDEFINITE);       
        st2.setByY(0.2);
        st2.setAutoReverse(true);
        st2.play();
        
        st3.setNode(rectangle_6_4);
        st3.setDuration(Duration.seconds(1.7));
        st3.setCycleCount(Timeline.INDEFINITE);
        st3.setByY(0.9);
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
        pt5Path.getElements().add(new MoveTo(
                rectangle_7.getWidth() / 2d, rectangle_7.getHeight() / 2d));
        pt5Path.getElements().add(new HLineTo(453));
        pt5.setNode(rectangle_7);
        pt5.setDuration(Duration.seconds(2));
        pt5.setCycleCount(Timeline.INDEFINITE);
        pt5.setPath(pt5Path);     
        pt5.play();
        
        Path pt6Path=new Path();
        pt6Path.getElements().add(new MoveTo(
                rectangle_8.getWidth() / 2d, rectangle_8.getHeight() / 2d));
        pt6Path.getElements().add(new HLineTo(453));
        pt6.setNode(rectangle_8);
        pt6.setDuration(Duration.seconds(2));
        pt6.setCycleCount(Timeline.INDEFINITE);
        pt6.setPath(pt6Path);     
        pt6.setDelay(Duration.seconds(1));
        pt6.play();
        
        Path pt7Path=new Path();
        pt7Path.getElements().add(new MoveTo(
                rectangle_9.getWidth() / 2d, rectangle_9.getHeight() / 2d));
        pt7Path.getElements().add(new HLineTo(453));
        pt7.setNode(rectangle_9);
        pt7.setDuration(Duration.seconds(2));
        pt7.setCycleCount(Timeline.INDEFINITE);
        pt7.setPath(pt7Path); 
        pt7.setDelay(Duration.seconds(2));
        pt7.play();
        
       
        Path pt8Path=new Path();
        pt8Path.getElements().add(new MoveTo(
                rectangle_6_2.getWidth() / 2d, rectangle_6_2.getHeight() / 2d));
        pt8Path.getElements().add(new HLineTo(24));
        pt8.setNode(rectangle_6_2);
        pt8.setDuration(Duration.seconds(1.7));
        pt8.setCycleCount(Timeline.INDEFINITE);
        pt8.setPath(pt8Path); 
        pt8.setAutoReverse(true);
        pt8.play();
        
        Path pt9Path=new Path();
        pt9Path.getElements().add(new MoveTo(
                rectangle_6_3.getWidth() / 2d, rectangle_6_3.getHeight() / 2d));
        pt9Path.getElements().add(new HLineTo(-24));
        pt9.setNode(rectangle_6_3);
        pt9.setDuration(Duration.seconds(1.7));
        pt9.setCycleCount(Timeline.INDEFINITE);
        pt9.setPath(pt9Path); 
        pt9.setAutoReverse(true);
        pt9.play();
        
        rt1.setNode(rectangle_5);
        rt1.setDuration(Duration.seconds(2.0));
        rt1.setFromAngle(-20);
        rt1.setByAngle(43);
        rt1.setCycleCount(Timeline.INDEFINITE);
        rt1.setAutoReverse(true);
        rt1.playFrom(Duration.seconds(1.0));
        
        rt2.setNode(innerCircle);
        rt2.setDuration(Duration.seconds(4.0));
        rt2.setByAngle(360);
        rt2.setCycleCount(Timeline.INDEFINITE);      
        rt2.playFrom(Duration.seconds(1.0));
        
        rt3.setNode(outterCircle);
        rt3.setDuration(Duration.seconds(7.0));
        rt3.setByAngle(360);
        rt3.setCycleCount(Timeline.INDEFINITE);      
        rt3.playFrom(Duration.seconds(1.0));
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
        timer.stop();
        startButton.setSelected(false);
        
        st1.jumpTo(Duration.ZERO);
        st1.stop();
        
        st2.jumpTo(Duration.ZERO);
        st2.stop();
        
        st3.jumpTo(Duration.ZERO);
        st3.stop();
        
        pt1.jumpTo(Duration.ZERO);
        pt1.stop();
        
        pt2.jumpTo(Duration.ZERO);
        pt2.stop();
        
        pt3.jumpTo(Duration.ZERO);
        pt3.stop();
        
        pt4.jumpTo(Duration.ZERO);
        pt4.stop();
        
        pt5.jumpTo(Duration.ZERO);
        pt5.stop();
        
        pt6.jumpTo(Duration.ZERO);
        pt6.stop();
        
        pt7.jumpTo(Duration.ZERO);
        pt7.stop();
        
        pt8.jumpTo(Duration.ZERO);
        pt8.stop();
        
        pt9.jumpTo(Duration.ZERO);
        pt9.stop();
        
        rt1.jumpTo(Duration.ZERO);
        rt1.stop();
        
        rt2.jumpTo(Duration.ZERO);
        rt2.stop();
        
        rt3.jumpTo(Duration.ZERO);
        rt3.stop();
       
    }

    @FXML
    private void onEnd(ActionEvent event) throws IOException {
        if (!startButton.isSelected()) {
            return;
        }
        stage.close();
        stopGame();
        Parent root = FXMLLoader.load(getClass()
                .getResource("LevelTwoFXML.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
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
        startButton.setText("Start");
        Parent root = FXMLLoader.load(getClass().getResource("Dialog.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void onMouseExitedPane(MouseEvent event) throws IOException {
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
        startButton.setText("Start");
        Parent root = FXMLLoader.load(getClass().getResource("Dialog.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void onDragDetected(MouseEvent event) throws IOException {
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
        startButton.setText("Start");
        Parent root = FXMLLoader.load(getClass().getResource("Dialog.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }
    
    Timeline timer = new Timeline(
            new KeyFrame(Duration.seconds(1), new UpdateTimer()));
    public static int hours = 0;
    public static int mins = 0;
    public static int secs = 0;
    
    class UpdateTimer implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            secs++;
            if (secs == 60) {
                mins++;
                secs = 0;
                if (mins == 60) {
                    hours++;
                    mins = 0;
                }
            }
            String print = String
                    .format(" %02d : %02d : %02d ", hours, mins, secs);
            chronoLabel.setText(print);
        }
    }
}

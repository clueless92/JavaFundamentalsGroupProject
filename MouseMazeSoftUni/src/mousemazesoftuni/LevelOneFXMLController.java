/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mousemazesoftuni;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 */

public class LevelOneFXMLController implements Initializable {
    @FXML
    private Rectangle gameField;
    @FXML
    private Button endButton;
    @FXML
    private Circle circle_1;
    @FXML
    private Rectangle rectangle_1;
    @FXML
    private ToggleButton startButton;
    /**
     * Initializes the controller class.
     */
    ScaleTransition st1 = new ScaleTransition();
    
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
        st1.setByX(3.5);
        st1.setByY(3.5);
        st1.play();
        
       
    }
    private void stopGame(){
        startButton.setSelected(false);
        st1.jumpTo(Duration.ZERO);
        st1.stop();
       
    }

    @FXML
    private void onStart(ActionEvent event) {
    }

}

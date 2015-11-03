package timetest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.util.Duration;
import static timetest.OneFXMLController.hours;
import static timetest.OneFXMLController.min;
import static timetest.OneFXMLController.sec;

public class TwoFXMLController implements Initializable {
    @FXML
    private ToggleButton toggleStart;
    @FXML
    private Button finishButton;
    @FXML
    private Label chronoLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resetTimer();
    }
    
    Timeline timer = new Timeline(new KeyFrame(Duration.seconds(1), new UpdateTimer()));
    public int hours = OneFXMLController.hours;
    public int min = OneFXMLController.min;
    public int sec = OneFXMLController.sec;
    
    private class UpdateTimer implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            sec++;
            if (sec == 60) {
                min++;
                sec = 0;
                if (min == 60) {
                    hours++;
                    min = 0;
                }
            }
            String print = String.format(" %02d : %02d : %02d ", hours, min, sec);
            chronoLabel.setText(print);
        }
    }

    @FXML
    private void onToggleStart(ActionEvent event) {if (toggleStart.isSelected()) {
            resetTimer();
            timer.setCycleCount(Timeline.INDEFINITE);
            timer.play();
            return;
        }
        timer.stop();
    }
    
    private void resetTimer() {
        hours = OneFXMLController.hours;
        min = OneFXMLController.min;
        sec = OneFXMLController.sec;
        String print = String.format(" %02d : %02d : %02d ", hours, min, sec);
        chronoLabel.setText(print);
    }

    @FXML
    private void onFinish(ActionEvent event) {
        timer.stop();
    }
    
}

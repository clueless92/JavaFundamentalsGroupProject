package timetest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
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
import javafx.scene.control.ToggleButton;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import static timetest.TimeTestFXMLController.stage;

public class OneFXMLController implements Initializable {
    @FXML
    private ToggleButton toggleStart;
    @FXML
    private Label chronoLabel;
    @FXML
    private Button nextButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    Timeline timer = new Timeline(new KeyFrame(Duration.seconds(1), new UpdateTimer()));
    public static int hours = 0;
    public static int min = 0;
    public static int sec = 0;
    
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
    private void onToggleStart(ActionEvent event) {
        if (toggleStart.isSelected()) {
            resetTimer();
            return;
        }
        timer.stop();
    }
    
    private void resetTimer() {
        hours = 0;
        min = 0;
        sec = 0;
        String print = String.format(" %02d : %02d : %02d ", hours, min, sec);
        chronoLabel.setText(print);
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }
    
    @FXML
    private void onNext(ActionEvent event) throws IOException {
        timer.stop();
        Parent root = FXMLLoader.load(getClass().getResource("TwoFXML.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }
    
}

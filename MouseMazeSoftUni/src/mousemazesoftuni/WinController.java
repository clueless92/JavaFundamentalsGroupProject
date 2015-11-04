package mousemazesoftuni;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static mousemazesoftuni.StartWindowFXMLController.stage;

public class WinController implements Initializable {

    @FXML
    private Label timeLabel;
    @FXML
    private TextField nameField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        long time = StartWindowFXMLController.scoreboard.getEntryTime();
        String timeString = StartWindowFXMLController.scoreboard.toTimeString(time);
        if (timeString != null) {
            timeLabel.setText(timeString);
        }
        String name = StartWindowFXMLController.scoreboard.getEntryName();
        if (name != null) {
            nameField.setText(name);
        }
    }

    @FXML
    private void yes(ActionEvent event) {
        String name = nameField.getText();
        //LevelTwoFXMLController.scoreboard.submitEntry(name);
        StartWindowFXMLController.scoreboard.submitEntry(name);
        stage.close();
    }

    @FXML
    private void no(ActionEvent event) {
        stage.close();
    }
}

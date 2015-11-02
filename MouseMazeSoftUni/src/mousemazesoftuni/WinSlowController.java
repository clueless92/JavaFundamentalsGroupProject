package mousemazesoftuni;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import static mousemazesoftuni.StartWindowFXMLController.stage;

public class WinSlowController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void ok(ActionEvent event) {
        stage.close();
    }

    @FXML
    private void onExit(ActionEvent event) {
        Platform.exit();
    }
}

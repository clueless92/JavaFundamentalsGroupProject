package mousemazesoftuni;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import static mousemazesoftuni.StartWindowFXMLController.stage;

public class DialogController implements Initializable {
    @FXML
    private Label messageLabel;
    @FXML
    private Label detailsLabel;
    @FXML
    private HBox actionParent;
    @FXML
    private Button actionButton;
    @FXML
    private HBox okParent;
    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void yesButtonAction(ActionEvent event) {
        stage.close();
    }

    @FXML
    private void noButtonAction(ActionEvent event) {
        Platform.exit();
    }
    
}

package mousemazesoftuni;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StartWindowFXMLController implements Initializable, EventHandler<WindowEvent>, Scoreboard.Listener {
    
    public static final String DATA_FILE_NAME = "data.ser";
    
    public static Scoreboard scoreboard = null;
    public static Stage stage;
    
    @FXML
    private Button startLevelOneButton;
    @FXML
    private TextArea scoreboardArea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deserialize();
        String scoreboardString = scoreboard.toString();
        scoreboardArea.setText(scoreboardString);
    }

    @FXML
    private void onStartLevelOne(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LevelOneFXML.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void onClear(ActionEvent event) {
        scoreboard.clear();
        String string = scoreboard.toString();
        scoreboardArea.setText(string);
        serialize();
    }

    @FXML
    private void onExit(ActionEvent event) {
        Platform.exit();
    }

    public void serialize() {
        try {
            ObjectOutputStream oos = null;
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(DATA_FILE_NAME);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(scoreboard);
            } finally {
                if (oos != null) {
                    oos.close();
                } else if (fos != null) {
                    fos.close();
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void deserialize() {
        try {
            ObjectInputStream ois = null;
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(DATA_FILE_NAME);
                ois = new ObjectInputStream(fis);
                scoreboard = (Scoreboard) ois.readObject();
            } finally {
                if (ois != null) {
                    ois.close();
                } else if (fis != null) {
                    fis.close();
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        if (scoreboard == null) {
            scoreboard = new Scoreboard();
        }
        scoreboard.setListener(this);
    }

    @Override
    public void handle(WindowEvent event) {
        scoreboard.clearEntry();
    }

    @Override
    public void onSubmitEntry() {
        String scoreboardString = scoreboard.toString();
        scoreboardArea.setText(scoreboardString);
        serialize();
    }
}

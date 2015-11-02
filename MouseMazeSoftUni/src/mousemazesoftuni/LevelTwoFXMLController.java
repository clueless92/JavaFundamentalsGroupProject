package mousemazesoftuni;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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

public class LevelTwoFXMLController implements Initializable, EventHandler<WindowEvent>, Scoreboard.Listener {

    public static final String DATA_FILE_NAME = "data.ser";
    //public static Stage stage;
    public static Scoreboard scoreboard = null;
    @FXML
    public Label chronoLabel;

    @FXML
    private ToggleButton toggleStart;
    @FXML
    private Arc obst3;
    @FXML
    private Rectangle obst1;
    @FXML
    private Rectangle obst2;
    @FXML
    private Rectangle obst4;
    @FXML
    private Rectangle obst5;
    @FXML
    private Rectangle obst7;
    @FXML
    private Rectangle obst6;
    @FXML
    private Rectangle obst8;
    @FXML
    private Rectangle obst9;
    @FXML
    private Rectangle obst12;
    @FXML
    private Rectangle obst11;
    @FXML
    private Rectangle obst10;
    @FXML
    private Label labelBridge;
    @FXML
    private Button buttonRealEnd;
    @FXML
    private Button buttonFakeEnd;
    @FXML
    private Circle obst13;
    @FXML
    private Label fakeWinLabel;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Rectangle gameField;
    @FXML
    private TextArea scoreboardArea;
    @FXML
    private Button clearSB;

    PathTransition pt1 = new PathTransition();
    PathTransition pt2 = new PathTransition();
    RotateTransition rt3 = new RotateTransition();
    RotateTransition rt4 = new RotateTransition();
    RotateTransition rt5 = new RotateTransition();
    PathTransition pt6 = new PathTransition();
    PathTransition pt7 = new PathTransition();
    RotateTransition rt8 = new RotateTransition();
    PathTransition pt8 = new PathTransition();
    PathTransition pt9 = new PathTransition();
    RotateTransition rt10 = new RotateTransition();
    RotateTransition rt11 = new RotateTransition();
    RotateTransition rt12 = new RotateTransition();
    ScaleTransition st13 = new ScaleTransition();

    Timeline timer = new Timeline(new KeyFrame(Duration.seconds(1), new UpdateTimer()));
    public int hours = 0;
    public int min = 0;
    public int sec = 0;
    class UpdateTimer implements EventHandler<ActionEvent> {

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
    private void onDragDetected(MouseEvent event) throws IOException {
        if (!toggleStart.isSelected()) {
            return;
        }
        stopGame();
        toggleStart.setText("Start!");

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
        if (!toggleStart.isSelected()) {
            return;
        }
        double fieldX = gameField.getLayoutX();
        double fieldY = gameField.getLayoutY();
        double x = event.getX() + fieldX;
        double y = event.getY() + fieldY;
        if (contains(toggleStart, x, y)) {
            return;
        }
        if (contains(buttonFakeEnd, x, y)) {
            return;
        }
        if (contains(buttonRealEnd, x, y)) {
            return;
        }
        if (contains(labelBridge, x, y)) {
            return;
        }
        stopGame();
        toggleStart.setText("Start!");
        Parent root = FXMLLoader.load(getClass().getResource("Dialog.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void onExit(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deserialize();
        String scoreboardString = scoreboard.toString();
        scoreboardArea.setText(scoreboardString);
    }

    @FXML
    private void onMouseEnteredLabel(MouseEvent event) {
        if (toggleStart.isSelected()) {
            labelBridge.setOpacity(1.0);
        }
    }

    // 1
    private static boolean contains(Labeled labeled, double x, double y) {
        double tolerance = 2.0;
        double left = labeled.getLayoutX() - tolerance;
        double right = left + labeled.getWidth() + 2 * tolerance;
        double top = labeled.getLayoutY() - tolerance;
        double bottom = top + labeled.getHeight() + 2 * tolerance;
        return left <= x && x <= right && top <= y && y <= bottom;
    }

    private void stopGame() {
        timer.stop();
        toggleStart.setSelected(false);
        buttonRealEnd.setOpacity(0.0);
        labelBridge.setOpacity(0.0);
        pt1.jumpTo(Duration.ZERO);
        pt1.stop();
        pt2.jumpTo(Duration.ZERO);
        pt2.stop();
        rt3.jumpTo(Duration.ZERO);
        rt3.stop();
        rt4.jumpTo(Duration.ZERO);
        rt4.stop();
        rt5.jumpTo(Duration.ZERO);
        rt5.stop();
        pt6.jumpTo(Duration.ZERO);
        pt6.stop();
        pt7.jumpTo(Duration.ZERO);
        pt7.stop();
        rt8.jumpTo(Duration.ZERO);
        rt8.stop();
        pt8.jumpTo(Duration.ZERO);
        pt8.stop();
        pt9.jumpTo(Duration.ZERO);
        pt9.stop();
        rt10.jumpTo(Duration.seconds(1.0));
        rt10.stop();
        rt11.jumpTo(Duration.seconds(1.0));
        rt11.stop();
        rt12.jumpTo(Duration.seconds(1.0));
        rt12.stop();
        st13.jumpTo(Duration.ZERO);
        st13.stop();
        
        fakeWinLabel.setOpacity(0.0);
    }

    //2
    @FXML
    private void onMouseExited(MouseEvent event) throws IOException {
        if (!toggleStart.isSelected()) {
            return;
        }
        double fieldX = gameField.getLayoutX();
        double fieldY = gameField.getLayoutY();
        double x = event.getX() + fieldX;
        double y = event.getY() + fieldY;
        if (contains(toggleStart, x, y)) {
            return;
        }
        if (contains(buttonFakeEnd, x, y)) {
            return;
        }
        if (contains(buttonRealEnd, x, y)) {
            return;
        }
        if (contains(labelBridge, x, y)) {
            return;
        }
        stopGame();
        toggleStart.setText("Start!");
        Parent root = FXMLLoader.load(getClass().getResource("Dialog.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    private void startGame() {
        hours = 0;
        min = 0;
        sec = 0;
        String print = String.format(" %02d : %02d : %02d ", hours, min, sec);
        chronoLabel.setText(print);
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();

        Path path1 = new Path();
        path1.getElements().add(new MoveTo(53.0, 15.0));
        path1.getElements().add(new HLineTo(150.0));
        pt1.setNode(obst1);
        pt1.setDuration(Duration.seconds(1.5));
        pt1.setPath(path1);
        pt1.setAutoReverse(true);
        pt1.setCycleCount(Timeline.INDEFINITE);
        pt1.play();

        Path path2 = new Path();
        path2.getElements().add(new MoveTo(53.0, 15.0));
        path2.getElements().add(new HLineTo(-40.0));
        pt2.setNode(obst2);
        pt2.setDuration(Duration.seconds(1.5));
        pt2.setPath(path2);
        pt2.setAutoReverse(true);
        pt2.setCycleCount(Timeline.INDEFINITE);
        pt2.play();

        rt3.setNode(obst3);
        rt3.setDuration(Duration.seconds(3.5));
        rt3.setByAngle(360);
        rt3.setCycleCount(Timeline.INDEFINITE);
        rt3.play();

        rt4.setNode(obst4);
        rt4.setDuration(Duration.seconds(7.0));
        rt4.setByAngle(360);
        rt4.setCycleCount(Timeline.INDEFINITE);
        rt4.play();

        rt5.setNode(obst5);
        rt5.setDuration(Duration.seconds(7.0));
        rt5.setByAngle(360);
        rt5.setCycleCount(Timeline.INDEFINITE);
        rt5.play();

        Path path6 = new Path();
        path6.getElements().add(new MoveTo(45.0, 15.0));
        path6.getElements().add(new VLineTo(-280.0));
        pt6.setNode(obst6);
        pt6.setDuration(Duration.seconds(6.0));
        pt6.setPath(path6);
        pt6.setCycleCount(Timeline.INDEFINITE);
        pt6.play();

        Path path7 = new Path();
        path7.getElements().add(new MoveTo(45.0, 15.0));
        path7.getElements().add(new VLineTo(-280.0));
        pt7.setNode(obst7);
        pt7.setDuration(Duration.seconds(6.0));
        pt7.setPath(path7);
        pt7.setDelay(Duration.seconds(3.0));
        pt7.setCycleCount(Timeline.INDEFINITE);
        pt7.play();

        Path path8 = new Path();
        path8.getElements().add(new MoveTo(15.0, 29.0));
        path8.getElements().add(new HLineTo(380.0));
        pt8.setNode(obst8);
        pt8.setDuration(Duration.seconds(3.0));
        pt8.setPath(path8);
        pt8.setAutoReverse(true);
        pt8.setCycleCount(Timeline.INDEFINITE);
        pt8.play();
        rt8.setNode(obst8);
        rt8.setDuration(Duration.seconds(5.0));
        rt8.setByAngle(360);
        rt8.setCycleCount(Timeline.INDEFINITE);
        rt8.play();

        Path path9 = new Path();
        path9.getElements().add(new MoveTo(222.0, 5.0));
        path9.getElements().add(new VLineTo(-50.0));
        pt9.setNode(obst9);
        pt9.setDuration(Duration.seconds(2.5));
        pt9.setPath(path9);
        pt9.setCycleCount(Timeline.INDEFINITE);
        pt9.play();

        rt10.setNode(obst10);
        rt10.setDuration(Duration.seconds(2.0));
        rt10.setFromAngle(-15);
        rt10.setByAngle(30);
        rt10.setCycleCount(Timeline.INDEFINITE);
        rt10.setAutoReverse(true);
        rt10.playFrom(Duration.seconds(1.0));

        rt11.setNode(obst11);
        rt11.setDuration(Duration.seconds(2.0));
        rt11.setFromAngle(15);
        rt11.setByAngle(-30);
        rt11.setCycleCount(Timeline.INDEFINITE);
        rt11.setAutoReverse(true);
        rt11.playFrom(Duration.seconds(1.0));

        rt12.setNode(obst12);
        rt12.setDuration(Duration.seconds(2.0));
        rt12.setFromAngle(-15);
        rt12.setByAngle(30);
        rt12.setCycleCount(Timeline.INDEFINITE);
        rt12.setAutoReverse(true);
        rt12.playFrom(Duration.seconds(1.0));

        st13.setNode(obst13);
        st13.setDuration(Duration.seconds(2.0));
        st13.setCycleCount(Timeline.INDEFINITE);
        st13.setByX(3.5);
        st13.setByY(3.5);
        st13.play();
    }

    @FXML
    private void toggleStartAction(ActionEvent event) throws IOException {
        if (!toggleStart.isSelected()) {
            stopGame();
            toggleStart.setText("Start!");
        } else {
            startGame();
            toggleStart.setText("Stop!");
        }
    }

    @FXML
    private void onRealEnd(ActionEvent event) throws IOException {
        if (!toggleStart.isSelected()) {
            return;
        }
        long time = sec + min * 60L + hours * 3600L;
        if (scoreboard.requestEntry(time)) {
            fakeWinLabel.setOpacity(0.0);
            stopGame();
            toggleStart.setText("Start!");
            
            Parent root = FXMLLoader.load(getClass().getResource("Win.fxml"));
            Scene scene = new Scene(root);
            stage = new Stage();
            stage.setScene(scene);
            stage.setOnHidden(this);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
            
        } else {
            fakeWinLabel.setOpacity(0.0);
            stopGame();
            toggleStart.setText("Start!");
            Parent root = FXMLLoader.load(getClass().getResource("WinSlow.fxml"));
            Scene scene = new Scene(root);
            stage = new Stage();
            stage.setScene(scene);
            stage.setOnHidden(this);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
        }
    }

    @FXML
    private void onFakeEnd(ActionEvent event) throws IOException {
        if (!toggleStart.isSelected()) {
            return;
        }
        buttonRealEnd.setOpacity(1.0);
        fakeWinLabel.setOpacity(1.0);
    }

    @Override
    public void handle(WindowEvent event) {
        scoreboard.clearEntry();
    }

    @FXML
    private void onBoardClear(ActionEvent event) {
        scoreboard.clear();
        String string = scoreboard.toString();
        scoreboardArea.setText(string);
        serialize();
    }

    @Override
    public void onSubmitEntry() {
        String scoreboardString = scoreboard.toString();
        scoreboardArea.setText(scoreboardString);
        serialize();
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
}

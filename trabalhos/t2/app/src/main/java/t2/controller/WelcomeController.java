package t2.controller;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import t2.util.WindowManagerUtil;

public class WelcomeController implements Initializable {
    @FXML
    private Label welcomeLabel;
    
    @FXML @Override
    public void initialize(URL location, ResourceBundle resources) {
        new WelcomeScreen().start();
    }

    private final int sleepTime = new Random().nextInt(3000, 4001);

    class WelcomeScreen extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(sleepTime);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Stage stage = (Stage)welcomeLabel.getScene().getWindow();
                        WindowManagerUtil.newWindow("view/login.fxml", "Login", false);
                        stage.close();
                    }
                });
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}

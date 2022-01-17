package t2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import t2.task.LoginTask;
import t2.util.AlertUtil;
import t2.util.ExceptionHandlerUtil;
import t2.util.WebServiceResponseUtil;
import t2.util.WindowManagerUtil;

public class LoginController {
    @FXML
    private Button clearButton;

    @FXML
    private Button enterButton;

    @FXML
    private TextField userIdTextField;

    @FXML
    private Label validatingUserIdAsteriskLabel;

    @FXML
    private Label validatingUserIdLabel;

    @FXML
    public void clear(ActionEvent event) {
        this.userIdTextField.clear();
    }

    @FXML
    public void login(ActionEvent event) {
        setValidatingUserIdMessage(true);

        String userId = this.userIdTextField.getText();
        LoginTask loginTask = new LoginTask(userId);

        loginTask.setOnSucceeded(e -> {
            setValidatingUserIdMessage(false);

            WebServiceResponseUtil webServiceResponse = loginTask.getValue();

            if (webServiceResponse != null && webServiceResponse.getSuccess()) {
                Stage stage = (Stage)enterButton.getScene().getWindow();
                WindowManagerUtil.newWindow("view/menu.fxml", "Menu", false);
                MenuController.setUserId(userId);
                stage.close();
            } else {
                AlertUtil.show(AlertType.ERROR, "Login error", "Invalid userId", webServiceResponse.getMessage());
            }
        });

        loginTask.setOnFailed(e -> {
            setValidatingUserIdMessage(false);
            ExceptionHandlerUtil.handle(loginTask.getException());
        });

        Thread thread = new Thread(loginTask);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    void onEnter(ActionEvent event) {
        login(event);
    }

    private void setValidatingUserIdMessage(boolean setVisible) {
        this.validatingUserIdAsteriskLabel.setVisible(setVisible);
        this.validatingUserIdLabel.setVisible(setVisible);
    }
}

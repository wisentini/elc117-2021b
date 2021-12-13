package t2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import t2.Util;
import t2.WebServiceResponse;
import t2.WindowManager;

public class LoginController {
    @FXML
    private Button clearButton;

    @FXML
    private Button enterButton;

    @FXML
    private TextField userIdTextField;

    @FXML
    public void clear(ActionEvent event) {
        this.userIdTextField.clear();
    }

    @FXML
    public void login(ActionEvent event) {
        String userId = this.userIdTextField.getText();
        WebServiceResponse webServiceResponse = null;

        try {
            webServiceResponse = Util.isUserIdValid(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (webServiceResponse != null && webServiceResponse.getSuccess()) {
            Stage stage = (Stage)enterButton.getScene().getWindow();

            WindowManager.newWindow("view/menu.fxml", "Menu", false);
            MenuController.setUserId(userId);
            stage.close();
        } else {
            Util.showAlert(AlertType.ERROR, "Erro de login", "userId inválido", webServiceResponse.getMessage());
        }
    }
}

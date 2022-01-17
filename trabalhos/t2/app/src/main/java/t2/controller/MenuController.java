package t2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import t2.util.WindowManagerUtil;

public class MenuController {
    @FXML
    private Button addLanguageButton;

    @FXML
    private Button addResourceButton;

    @FXML
    private Button searchResourceButton;

    @FXML
    private Button goBackToLoginButton;

    private static String userId;

    @FXML
    void callAddLanguageView(ActionEvent event) {
        Stage stage = (Stage)addLanguageButton.getScene().getWindow();
        WindowManagerUtil.newWindow("view/add-language.fxml", "Add Language", true);
        AddLanguageController.setUserId(userId);
        stage.close();
    }

    @FXML
    void callAddResourceView(ActionEvent event) {
        Stage stage = (Stage)addResourceButton.getScene().getWindow();
        WindowManagerUtil.newWindow("view/add-resource.fxml", "Add Resource", true);
        AddResourceController.setUserId(userId);
        stage.close();
    }

    @FXML
    void callSearchResourceView(ActionEvent event) {
        Stage stage = (Stage)searchResourceButton.getScene().getWindow();
        WindowManagerUtil.newWindow("view/search-resource.fxml", "Search Resource", true);
        SearchResourceController.setUserId(userId);
        stage.close();
    }

    @FXML
    void goBackToLogin(ActionEvent event) {
        Stage stage = (Stage)goBackToLoginButton.getScene().getWindow();
        WindowManagerUtil.newWindow("view/login.fxml", "Login", false);
        stage.close();
    }

    public static void setUserId(String uid) {
        userId = uid;
    }
}

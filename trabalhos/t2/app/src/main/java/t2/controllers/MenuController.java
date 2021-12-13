package t2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import t2.WindowManager;

public class MenuController {
    @FXML
    private Button addResourceButton;

    @FXML
    private Button searchResourceButton;

    private static String userId;

    public static void setUserId(String uid) {
        userId = uid;
    }

    @FXML
    void callAddResourceView(ActionEvent event) {
        Stage stage = (Stage)addResourceButton.getScene().getWindow();
        WindowManager.newWindow("view/add-resource.fxml", "Add Resource", true);
        AddResourceController.setUserId(userId);
        stage.close();
    }

    @FXML
    void callSearchResourceView(ActionEvent event) {
        Stage stage = (Stage)addResourceButton.getScene().getWindow();
        WindowManager.newWindow("view/search-resource.fxml", "Search Resource", true);
        SearchResourceController.setUserId(userId);
        stage.close();
    }
}

package t2.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import t2.Category;
import t2.Resource;
import t2.Util;
import t2.WebService;
import t2.WebServiceResponse;
import t2.WindowManager;

public class AddResourceController implements Initializable {
    @FXML
    private Button addResourceButton;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private TextArea commentTextArea;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TextField languageIdTextField;

    @FXML
    private TextField tagsTextField;

    @FXML
    private TextField urlTextField;

    @FXML
    private Button menuButton;

    private static String userId;

    public static void setUserId(String uid) {
        userId = uid;
    }

    @FXML
    public void handleSelectedCategory(ActionEvent event) {
        String selectedCategory = this.categoryComboBox.getValue();
        List<Category> categories = null;

        try {
            categories = WebService.getCategories();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Category category : categories) {
            if (selectedCategory.equals(category.getCategory())) {
                this.descriptionTextArea.setText(category.getDescription());
                break;
            }
        }
    }

    @FXML @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Category> categories = null;

        try {
            categories = WebService.getCategories();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> strings = WebService.getCategoryFromCategories(categories);

        ObservableList<String> items = FXCollections.observableArrayList(strings);
                
        categoryComboBox.getItems().clear();
        categoryComboBox.getItems().setAll(items);

        commentTextArea.setWrapText(true);
        descriptionTextArea.setWrapText(true);
    }

    @FXML
    public void addResource(ActionEvent event) {
        String url = this.urlTextField.getText();
        String languageId = this.languageIdTextField.getText();
        String tags = this.tagsTextField.getText();
        String category = this.categoryComboBox.getValue();
        String comment = this.commentTextArea.getText();

        Resource resource = new Resource(url, languageId, tags, category, comment, userId);
        WebServiceResponse webServiceResponse = null;

        try {
            webServiceResponse = WebService.postResource(resource);
        } catch (Exception e) {
            e.printStackTrace();
            Util.showAlert(AlertType.INFORMATION, "Resource", "Não foi possível incluir o Resource", "Causa: desconhecida");
            return;
        }

        if (webServiceResponse.getSuccess()) {
            Util.showAlert(AlertType.INFORMATION, "Resource", "O Resource foi incluído com sucesso", "Status: " + webServiceResponse.getMessage());
        } else {
            Util.showAlert(AlertType.INFORMATION, "Resource", "Não foi possível incluir o Resource", "Causa: " + webServiceResponse.getMessage());
        }
    }

    @FXML
    public void callMenuView(ActionEvent event) {
        Stage stage = (Stage)menuButton.getScene().getWindow();
        WindowManager.newWindow("view/menu.fxml", "Menu", false);
        MenuController.setUserId(userId);
        stage.close();
    }
}

package t2.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import t2.model.Category;
import t2.model.Resource;
import t2.model.WebService;
import t2.util.AlertUtil;
import t2.util.ExceptionHandlerUtil;
import t2.util.WebServiceResponseUtil;
import t2.util.WindowManagerUtil;

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

    @FXML
    private Label loadingCategoriesAsteriskLabel;

    @FXML
    private Label loadingCategoriesLabel;

    @FXML
    private Label loadingDescriptionAsteriskLabel;

    @FXML
    private Label loadingDescriptionLabel;

    private List<Category> categories;

    private static String userId;

    public static void setUserId(String uid) {
        userId = uid;
    }

    @FXML @Override
    public void initialize(URL location, ResourceBundle resources) {
        enableLoadingCategoriesMessage(true);

        Task<List<Category>> getCategoriesTask = WebService.getCategoriesTask();

        getCategoriesTask.setOnSucceeded(e -> {
            this.categories = getCategoriesTask.getValue();

            List<String> strings = WebService.getCategoryFromCategories(this.categories);
            ObservableList<String> items = FXCollections.observableArrayList(strings);
                    
            categoryComboBox.getItems().clear();
            categoryComboBox.getItems().setAll(items);

            enableLoadingCategoriesMessage(false);
        });

        getCategoriesTask.setOnFailed(e -> {
            enableLoadingCategoriesMessage(false);
            ExceptionHandlerUtil.handle(getCategoriesTask.getException());
        });

        Thread thread = new Thread(getCategoriesTask);
        thread.setDaemon(true);
        thread.start();

        commentTextArea.setWrapText(true);
        descriptionTextArea.setWrapText(true);
        descriptionTextArea.setEditable(false);
    }

    @FXML
    public void handleSelectedCategory(ActionEvent event) {
        enableLoadingDescriptionMessage(true);

        String selectedCategory = this.categoryComboBox.getValue();
    
        Task<List<Category>> getCategoriesTask = WebService.getCategoriesTask();

        getCategoriesTask.setOnSucceeded(e -> {
            this.categories = getCategoriesTask.getValue();

            for (Category category : this.categories) {
                if (selectedCategory.equals(category.getCategory())) {
                    this.descriptionTextArea.setText(category.getDescription());
                    enableLoadingDescriptionMessage(false);
                    break;
                }
            }
        });

        getCategoriesTask.setOnFailed(e -> {
            enableLoadingDescriptionMessage(false);
            ExceptionHandlerUtil.handle(getCategoriesTask.getException());
        });

        Thread thread = new Thread(getCategoriesTask);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    public void addResource(ActionEvent event) {
        String url = this.urlTextField.getText();
        String languageId = this.languageIdTextField.getText();
        String tags = this.tagsTextField.getText();
        String category = this.categoryComboBox.getValue();
        String comment = this.commentTextArea.getText();

        Resource resource = new Resource(url, languageId, tags, category, comment, userId);

        Task<WebServiceResponseUtil> postResourceTask = WebService.postResourceTask(resource);

        postResourceTask.setOnSucceeded(e -> {
            WebServiceResponseUtil webServiceResponse = postResourceTask.getValue();

            if (webServiceResponse.getSuccess()) {
                AlertUtil.show(AlertType.INFORMATION, "Add resource", "Resource added", "Status: " + webServiceResponse.getMessage());
            } else {
                AlertUtil.show(AlertType.INFORMATION, "Add resource", "Couldn't add resource", "Reason: " + webServiceResponse.getMessage());
            }
        });

        postResourceTask.setOnFailed(e -> {
            ExceptionHandlerUtil.handle(postResourceTask.getException());
        });

        Thread thread = new Thread(postResourceTask);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    public void callMenuView(ActionEvent event) {
        Stage stage = (Stage)menuButton.getScene().getWindow();
        WindowManagerUtil.newWindow("view/menu.fxml", "Menu", false);
        MenuController.setUserId(userId);
        stage.close();
    }

    private void enableLoadingDescriptionMessage(boolean setVisible) {
        this.loadingDescriptionAsteriskLabel.setVisible(setVisible);
        this.loadingDescriptionLabel.setVisible(setVisible);
    }

    private void enableLoadingCategoriesMessage(boolean setVisible) {
        this.loadingCategoriesAsteriskLabel.setVisible(setVisible);
        this.loadingCategoriesLabel.setVisible(setVisible);
    }
}

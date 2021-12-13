package t2.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import t2.Resource;
import t2.WindowManager;
import t2.tasks.GetResourcesByCategoryTask;
import t2.tasks.GetResourcesByLanguageIdTask;
import t2.tasks.GetResourcesByTagsTask;
import t2.tasks.GetResourcesByUserIdTask;
import t2.tasks.GetResourcesTask;

public class SearchResourceController implements Initializable {
    @FXML
    private RadioButton languageIdRadioButton;

    @FXML
    private RadioButton tagsIdRadioButton;

    @FXML
    private RadioButton categoryIdRadioButton;

    @FXML
    private RadioButton userIdRadioButton;
    
    @FXML
    private TextField categoryTextField;

    @FXML
    private TextField languageIdTextField;

    @FXML
    private TextField tagsTextField;

    @FXML
    private TextField userIdTextField;

    @FXML
    private Button applyFilterButton;

    @FXML
    private Button resetFiltersButton;

    @FXML
    private Button menuButton;

    @FXML
    private TableView<Resource> resourceTableView;

    @FXML
    private TableColumn<Resource, String> urlColumn;

    @FXML
    private TableColumn<Resource, String> languageIdColumn;

    @FXML
    private TableColumn<Resource, String> tagsColumn;

    @FXML
    private TableColumn<Resource, String> categoryColumn;

    @FXML
    private TableColumn<Resource, String> commentColumn;

    @FXML
    private TableColumn<Resource, String> userIdColumn;

    @FXML
    private ToggleGroup radioButtons;

    private static String userId;

    private List<Resource> resources;

    private List<TextField> textFields;

    private ObservableList<Resource> tableViewItems;

    @FXML @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.textFields = createTextFieldList();
        disableTextFields();

        urlColumn.setCellValueFactory(new PropertyValueFactory<>("url"));
        languageIdColumn.setCellValueFactory(new PropertyValueFactory<>("languageId"));
        tagsColumn.setCellValueFactory(new PropertyValueFactory<>("tags"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("comment"));
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));

        GetResourcesTask getResourcesTask = new GetResourcesTask();
        
        getResourcesTask.setOnSucceeded(e -> {
            this.resources = getResourcesTask.getValue();
            updateTableView(this.resources);
        });

        Thread thread = new Thread(getResourcesTask);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    public void applyFilter(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton)this.radioButtons.getSelectedToggle();
        
        if (selectedRadioButton == null) return;
        
        String selectedRadioButtonId = selectedRadioButton.getText();

        for (TextField textField : this.textFields) {
            if (textField.getId().equals(selectedRadioButtonId)) {
                String param = textField.getText();

                if (!(param.isBlank() || param.isEmpty())) {
                    handleRequest(selectedRadioButtonId, param);
                }

                break;
            }
        }
    }

    @FXML
    public void resetFilters(ActionEvent event) {
        this.radioButtons.selectToggle(null);

        for (TextField textField : this.textFields) {
            textField.clear();
            textField.setDisable(true);
        }

        GetResourcesTask getResourcesTask = new GetResourcesTask();

        getResourcesTask.setOnSucceeded(e -> {
            this.resources = getResourcesTask.getValue();
            updateTableView(this.resources);
        });

        Thread thread = new Thread(getResourcesTask);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    public void callMenuView(ActionEvent event) {
        Stage stage = (Stage)menuButton.getScene().getWindow();
        WindowManager.newWindow("view/menu.fxml", "Menu", false);
        MenuController.setUserId(userId);
        stage.close();
    }

    @FXML
    public void handleUnselectedTextFields(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton)this.radioButtons.getSelectedToggle();

        if (selectedRadioButton != null) {
            for (TextField textField : this.textFields) {
                if (!textField.getId().equals(selectedRadioButton.getText())) {
                    textField.setDisable(true);
                } else {
                    textField.setDisable(false);
                }
            }
        }
    }

    private void handleRequest(String filter, String param) {
        Task<?> task = null;

        if (filter.equals("languageId")) {
            GetResourcesByLanguageIdTask getResourcesByLanguageIdTask = new GetResourcesByLanguageIdTask(param);
            getResourcesByLanguageIdTask.setOnSucceeded(value -> {
                this.resources = getResourcesByLanguageIdTask.getValue();
                updateTableView(this.resources);
            });
            task = getResourcesByLanguageIdTask;
        } else if (filter.equals("tags")) {
            GetResourcesByTagsTask getResourcesByTagsTask = new GetResourcesByTagsTask(param);
            getResourcesByTagsTask.setOnSucceeded(value -> {
                this.resources = getResourcesByTagsTask.getValue();
                updateTableView(this.resources);
            });
            task = getResourcesByTagsTask;
        } else if (filter.equals("category")) {
            GetResourcesByCategoryTask getResourcesByCategoryTask = new GetResourcesByCategoryTask(param);
            getResourcesByCategoryTask.setOnSucceeded(value -> {
                this.resources = getResourcesByCategoryTask.getValue();
                updateTableView(this.resources);
            });
            task = getResourcesByCategoryTask;
        } else if (filter.equals("userId")) {
            GetResourcesByUserIdTask getResourcesByUserIdTask = new GetResourcesByUserIdTask(param);
            getResourcesByUserIdTask.setOnSucceeded(value -> {
                this.resources = getResourcesByUserIdTask.getValue();
                updateTableView(this.resources);
            });
            task = getResourcesByUserIdTask;
        }

        task.setOnFailed(value -> updateTableView(null));
        
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    private List<TextField> createTextFieldList() {
        List<TextField> textFields = new ArrayList<TextField>(
            Arrays.asList(
                this.categoryTextField,
                this.languageIdTextField,
                this.tagsTextField,
                this.userIdTextField
            )
        );

        return textFields;
    }

    private void disableTextFields() {
        for (TextField textField : this.textFields) {
            textField.setDisable(true);
        }
    }

    private void updateTableView(List<Resource> resources) {
        this.resourceTableView.getItems().clear();

        if (resources != null) {
            this.tableViewItems = FXCollections.observableArrayList(resources);
            this.resourceTableView.setItems(this.tableViewItems);
        }
    }

    public static void setUserId(String uid) {
        userId = uid;
    }
}

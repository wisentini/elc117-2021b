package t2.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import t2.model.Resource;
import t2.model.WebService;
import t2.task.OpenBrowserTask;
import t2.util.AlertUtil;
import t2.util.ExceptionHandlerUtil;
import t2.util.UrlValidatorUtil;
import t2.util.WindowManagerUtil;

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
    private Button reloadTableButton;

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

    @FXML
    private Label loadingTableAsteriskLabel;

    @FXML
    private Label loadingTableLabel;
    
    private static String userId;

    private List<Resource> resources;

    private List<TextField> textFields;

    private ObservableList<Resource> tableViewItems;

    @FXML @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.textFields = createTextFieldList();
        disableTextFields();
        setTableView();
        enableLoadingTableMessage(true);

        Task<List<Resource>> getResourcesTask = WebService.getResourcesTask();
        
        getResourcesTask.setOnSucceeded(e -> {
            this.resources = getResourcesTask.getValue();
            updateTableView(this.resources);
        });

        getResourcesTask.setOnFailed(e -> {
            enableLoadingTableMessage(false);
            ExceptionHandlerUtil.handle(getResourcesTask.getException());
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

        reloadTable(event);
    }

    @FXML
    public void callMenuView(ActionEvent event) {
        Stage stage = (Stage)menuButton.getScene().getWindow();
        WindowManagerUtil.newWindow("view/menu.fxml", "Menu", false);
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
        final Task<List<Resource>> task = WebService.getResourcesByCategoryTask(param);

        enableLoadingTableMessage(true);

        if (filter.equals("languageId")) {
            task.setOnSucceeded(value -> {
                this.resources = WebService.filterResourcesByLanguageId(task.getValue(), param);
            });
        } else if (filter.equals("tags")) {
            task.setOnSucceeded(value -> {
                this.resources = WebService.filterResourcesByTags(task.getValue(), param);
            });
        } else if (filter.equals("category")) {
            task.setOnSucceeded(value -> {
                this.resources = WebService.filterResourcesByCategory(task.getValue(), param);
            });
        } else if (filter.equals("userId")) {
            task.setOnSucceeded(value -> {
                this.resources = WebService.filterResourcesByUserId(task.getValue(), param);
            });
        }

        task.setOnSucceeded(value -> {
            updateTableView(this.resources);
        });
        
        task.setOnFailed(value -> {
            ExceptionHandlerUtil.handle(task.getException());
            updateTableView(null);
        });
        
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

    private void setTableView() {
        resourceTableView.getSelectionModel().setCellSelectionEnabled(true);

        urlColumn.setCellValueFactory(new PropertyValueFactory<>("url"));
        languageIdColumn.setCellValueFactory(new PropertyValueFactory<>("languageId"));
        tagsColumn.setCellValueFactory(new PropertyValueFactory<>("tags"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("comment"));
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));

        languageIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tagsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        categoryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        commentColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        userIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        resourceTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Resource resource = resourceTableView.getSelectionModel().getSelectedItem();

                if (resource == null || getSelectedCellColumnIndex() != 0 || mouseEvent.getClickCount() != 2) return;

                String url = resource.getUrl();
                Optional<ButtonType> selectedOption = AlertUtil.show(AlertType.CONFIRMATION, "Open URL", "Open resource URL", String.format("Do you wanna open the URL \"%s\" on your default browser?", url));

                if (selectedOption.get() == ButtonType.OK) {
                    if (UrlValidatorUtil.validate(url)) {
                        OpenBrowserTask openBrowserTask = new OpenBrowserTask(url);
                        openBrowserTask.setOnFailed(value -> {
                            ExceptionHandlerUtil.handle(openBrowserTask.getException());
                        });
                        Thread thread = new Thread(openBrowserTask);
                        thread.setDaemon(true);
                        thread.start();
                    } else {
                        AlertUtil.show(AlertType.ERROR, "Invalid URL", "Invalid URL", String.format("\"%s\" is not a valid URL.", url));
                    }
                }
            }
        });
    }

    private void updateTableView(List<Resource> resources) {
        this.resourceTableView.getItems().clear();

        if (resources != null) {
            this.tableViewItems = FXCollections.observableArrayList(resources);
            this.resourceTableView.setItems(this.tableViewItems);
            enableLoadingTableMessage(false);
        }
    }

    private int getSelectedCellColumnIndex() {
        TableViewSelectionModel<Resource> tableViewSelectionModel = resourceTableView.getSelectionModel();
        
        // https://stackoverflow.com/questions/59634577/why-is-a-javafxml-tableposition-instance-considered-as-a-raw-type-when-type-argu
        TablePosition tablePosition = tableViewSelectionModel.getSelectedCells().get(0);

        return tablePosition.getColumn();
    }

    private void enableLoadingTableMessage(boolean setVisible) {
        this.loadingTableAsteriskLabel.setVisible(setVisible);
        this.loadingTableLabel.setVisible(setVisible);
    }

    public static void setUserId(String uid) {
        userId = uid;
    }

    @FXML
    void reloadTable(ActionEvent event) {
        enableLoadingTableMessage(true);
        updateTableView(null);

        Task<List<Resource>> getResourcesTask = WebService.getResourcesTask();

        getResourcesTask.setOnSucceeded(e -> {
            this.resources = getResourcesTask.getValue();
            updateTableView(this.resources);
        });

        getResourcesTask.setOnFailed(e -> {
            ExceptionHandlerUtil.handle(getResourcesTask.getException());
            enableLoadingTableMessage(false);
        });

        Thread thread = new Thread(getResourcesTask);
        thread.setDaemon(true);
        thread.start();
    }
}

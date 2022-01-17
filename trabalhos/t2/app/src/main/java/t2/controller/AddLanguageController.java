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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import t2.model.Language;
import t2.model.WebService;
import t2.util.AlertUtil;
import t2.util.ExceptionHandlerUtil;
import t2.util.WebServiceResponseUtil;
import t2.util.WindowManagerUtil;

public class AddLanguageController implements Initializable {
    @FXML
    private TableView<Language> languageTableView;

    private ObservableList<Language> tableViewItems;

    @FXML
    private TableColumn<Language, String> languageIdColumn;

    @FXML
    private TableColumn<Language, String> firstAppearedColumn;

    @FXML
    private TableColumn<Language, String> paradigmColumn;

    @FXML
    private TableColumn<Language, String> userIdColumn;

    @FXML
    private TextField languageIdTextField;

    @FXML
    private TextField firstAppearedTextField;

    @FXML
    private TextArea paradigmTextArea;

    @FXML
    private Button menuButton;

    @FXML
    private Button addLanguageButton;

    @FXML
    private Button reloadTableButton;

    @FXML
    private Label loadingTableAsteriskLabel;

    @FXML
    private Label loadingTableLabel;

    private List<Language> languages;

    private static String userId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paradigmTextArea.setWrapText(true);
        setTableView();
        enableLoadingTableMessage(true);
        reloadTable(null);
    }

    @FXML
    public void addLanguage(ActionEvent event) {
        String languageId = this.languageIdTextField.getText();
        String firstAppeared = this.firstAppearedTextField.getText();
        String paradigm = this.paradigmTextArea.getText();

        Language language = new Language(languageId, firstAppeared, paradigm, userId);

        Task<WebServiceResponseUtil> postLanguageTask = WebService.postLanguageTask(language);

        postLanguageTask.setOnSucceeded(e -> {
            WebServiceResponseUtil webServiceResponse = postLanguageTask.getValue();

            if (webServiceResponse.getSuccess()) {
                reloadTable(null);
                AlertUtil.show(AlertType.INFORMATION, "Add language", "Language added", "Status: " + webServiceResponse.getMessage());
                clearInputs();
            } else {
                AlertUtil.show(AlertType.INFORMATION, "Add language", "Couldn't add language", "Reason: " + webServiceResponse.getMessage());
            }
        });

        postLanguageTask.setOnFailed(e -> {
            ExceptionHandlerUtil.handle(postLanguageTask.getException());
        });

        Thread thread = new Thread(postLanguageTask);
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

    @FXML
    public void reloadTable(ActionEvent event) {
        this.languageTableView.getItems().clear();
        enableLoadingTableMessage(true);

        Task<List<Language>> getLanguagesTask = WebService.getLanguagesTask();
        
        getLanguagesTask.setOnSucceeded(e -> {
            languages = getLanguagesTask.getValue();
            updateTableView(languages);
        });

        getLanguagesTask.setOnFailed(e -> {
            enableLoadingTableMessage(false);
            ExceptionHandlerUtil.handle(getLanguagesTask.getException());
        });

        Thread thread = new Thread(getLanguagesTask);
        thread.setDaemon(true);
        thread.start();
    }

    private void setTableView() {
        languageTableView.getSelectionModel().setCellSelectionEnabled(true);

        languageIdColumn.setCellValueFactory(new PropertyValueFactory<Language, String>("languageId"));
        firstAppearedColumn.setCellValueFactory(new PropertyValueFactory<Language, String>("firstAppeared"));
        paradigmColumn.setCellValueFactory(new PropertyValueFactory<Language, String>("paradigm"));
        userIdColumn.setCellValueFactory(new PropertyValueFactory<Language, String>("userId"));

        languageIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        firstAppearedColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        paradigmColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        userIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    private void updateTableView(List<Language> languages) {
        this.languageTableView.getItems().clear();

        if (languages != null) {
            this.tableViewItems = FXCollections.observableArrayList(languages);
            this.languageTableView.setItems(this.tableViewItems);
            enableLoadingTableMessage(false);
        }
    }

    private void clearInputs() {
        this.languageIdTextField.clear();
        this.firstAppearedTextField.clear();
        this.paradigmTextArea.clear();
    }

    private void enableLoadingTableMessage(boolean setVisible) {
        this.loadingTableAsteriskLabel.setVisible(setVisible);
        this.loadingTableLabel.setVisible(setVisible);
    }

    public static void setUserId(String uid) {
        userId = uid;
    }
}

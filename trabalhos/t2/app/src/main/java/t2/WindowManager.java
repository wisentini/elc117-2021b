package t2;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowManager {
    public static void newWindow(String fxmlFilename, String stageTitle, boolean maximizedMode) {
        URL fxml = ClassLoader.getSystemClassLoader().getResource(fxmlFilename);
        FXMLLoader fxmlLoader = new FXMLLoader(fxml);

        Parent root = null;

        try {
            root = fxmlLoader.load();
        } catch (IOException ioe) {
            System.out.println(String.format("Erro: não foi possível carregar o arquivo \"%s\"", fxmlFilename));
            ioe.printStackTrace();
            return;
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle(stageTitle);
        stage.setMaximized(maximizedMode);
        stage.show();
    }

    public static void newWindow(Stage stage, String fxmlFilename, String stageTitle, boolean maximizedMode) {
        URL fxml = ClassLoader.getSystemClassLoader().getResource(fxmlFilename);
        FXMLLoader fxmlLoader = new FXMLLoader(fxml);

        Parent root = null;

        try {
            root = fxmlLoader.load();
        } catch (IOException ioe) {
            System.out.println(String.format("Erro: não foi possível carregar o arquivo \"%s\"", fxmlFilename));
            ioe.printStackTrace();
            return;
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle(stageTitle);
        stage.setMaximized(maximizedMode);
        stage.show();
    }
}

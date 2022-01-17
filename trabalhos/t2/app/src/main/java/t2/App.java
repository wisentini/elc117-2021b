package t2;

import javafx.application.Application;
import javafx.stage.Stage;
import t2.util.WindowManagerUtil;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WindowManagerUtil.newWindow(primaryStage, "view/welcome.fxml", "Welcome", false);
    }
}

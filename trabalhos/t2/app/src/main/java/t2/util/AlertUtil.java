package t2.util;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class AlertUtil {
    public static Optional<ButtonType> show(AlertType alertType, String alertTitle, String alertHeaderText, String alertContentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(alertTitle);
        alert.setHeaderText(alertHeaderText);
        alert.setContentText(alertContentText);
        return alert.showAndWait();
    }
}

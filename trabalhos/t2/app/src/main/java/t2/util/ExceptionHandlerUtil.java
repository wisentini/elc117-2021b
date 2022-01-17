package t2.util;

import java.io.IOException;
import java.net.MalformedURLException;

import javafx.scene.control.Alert.AlertType;

public class ExceptionHandlerUtil {
    public static void handle(Throwable throwable) {
        AlertType alertType = AlertType.ERROR;
        String alertTitle = "Caught exception";
        String alertHeaderText = throwable.getClass().getSimpleName();
        String alertContentText = "";

        if (throwable instanceof MalformedURLException) {
            alertContentText = "No legal protocol could be found in a specification string or the string could not be parsed.";
        } else if (throwable instanceof IOException) {
            alertContentText = "Failed or interrupted I/O operation. Check your internet connection.";
        } else if (throwable instanceof Exception) {
            alertContentText = "Something went wrong. Check your internet connection.";
        }

        AlertUtil.show(alertType, alertTitle, alertHeaderText, alertContentText);
    }
}

package t2;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Util {
    private static final List<String> userIds = new ArrayList<>(List.of("andreainfufsm", "AfroFuturist", "crazynds", "Davidlopes22", "DeivisFelipe", "edusmrs", "MarcosNoble", "phcosta0", "Pivetta21", "VirginiaColares", "wisentini"));

    public static String toJSON(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String string = gson.toJson(object);
        return string;
    }

    public static String encode(String string) {
        return URLEncoder.encode(string, StandardCharsets.UTF_8);
    }

    public static WebServiceResponse isUserIdValid(String userId) throws Exception {
        WebServiceResponse response = basicUserIdValidation(userId);

        if (!response.getSuccess()) {
            return new WebServiceResponse(false, response.getMessage());
        }

        if (!userIds.contains(userId)) {
            return new WebServiceResponse(false, String.format("O userId \"%s\" não pertence à disciplina \"elc117\"", userId));
        }

        String urlString = "https://api.github.com/users/" + userId;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        int responseCode = connection.getResponseCode();
        connection.disconnect();

        boolean success = false;
        String message = "";

        if (responseCode != 200) {
            message = String.format("O userId \"%s\" não foi encontrado no GitHub", userId);
        } else {
            success = true;
        }

        return new WebServiceResponse(success, message);
    }

    public static void showAlert(AlertType alertType, String alertTitle, String alertHeaderText, String alertContentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(alertTitle);
        alert.setHeaderText(alertHeaderText);
        alert.setContentText(alertContentText);
        alert.showAndWait();
    }

    private static WebServiceResponse basicUserIdValidation(String userId) {
        boolean success = false;
        String message = "";

        if (userId.length() < 1) {
            message = "O userId deve conter pelo menos 1 caracter";
        } else if (userId.length() > 39) {
            message = "O userId não pode exceder 39 caracteres";
        } else if (userId.startsWith("-")) {
            message = "O userId não pode iniciar com hífen";
        } else if (userId.endsWith("-")) {
            message = "O userId não pode terminar com hífen";
        } else if (userId.contains("--")) {
            message = "O userId não pode conter vários hífens consecutivos";
        } else if (!isAlphanumeric(userId)) {
            message = "O userId não pode conter caracteres especiais";
        } else {
            success = true;
        }

        return new WebServiceResponse(success, message);
    }

    private static boolean isAlphanumeric(String string) {
        for (int i = 0; i < string.length(); i++) {
            if ((!Character.isLetterOrDigit(string.charAt(i)) || Character.isSpaceChar(string.charAt(i))) && string.charAt(i) != '-') {
                return false;
            }
        }

        return true;
    }
}

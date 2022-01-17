package t2.task;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.concurrent.Task;
import t2.util.WebServiceResponseUtil;

public class LoginTask extends Task<WebServiceResponseUtil> {
    private static final List<String> userIds = new ArrayList<>(List.of(
        "andreainfufsm", "afrofuturist", "crazynds", "davidlopes22",
        "deivisfelipe", "edusmrs", "josi-aggens", "leobenatti11",
        "marcosnoble", "miguelwisneski", "phcosta0", "piekala",
        "pivetta21", "virginiacolares", "wisentini"
    ));

    private String userId;

    public LoginTask(String userId) {
        this.userId = userId.toLowerCase();
    }

    @Override
    protected WebServiceResponseUtil call() throws Exception {
        WebServiceResponseUtil response = basicUserIdValidation(userId);

        if (!response.getSuccess()) {
            return new WebServiceResponseUtil(false, response.getMessage());
        }

        if (!userIds.contains(userId)) {
            return new WebServiceResponseUtil(false, String.format("userId \"%s\" doesn't belong to \"elc117\"", userId));
        }

        String urlString = "https://api.github.com/users/" + userId;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        int responseCode = connection.getResponseCode();
        connection.disconnect();

        boolean success = false;
        String message = "";

        if (responseCode != 200) {
            message = String.format("userId \"%s\" not found on GitHub", userId);
        } else {
            success = true;
        }

        return new WebServiceResponseUtil(success, message);
    }

    private static WebServiceResponseUtil basicUserIdValidation(String userId) {
        boolean success = false;
        String message = "";

        if (userId.length() < 1) {
            message = "userId must have at least 1 character";
        } else if (userId.length() > 39) {
            message = "userId cannot exceed 39 characters";
        } else if (userId.startsWith("-")) {
            message = "userId cannot start with a hyphen";
        } else if (userId.endsWith("-")) {
            message = "userId cannot end with a hyphen";
        } else if (userId.contains("--")) {
            message = "userId cannot contain multiple consecutive hyphens";
        } else if (!isAlphanumeric(userId)) {
            message = "userId cannot contain special characters";
        } else {
            success = true;
        }

        return new WebServiceResponseUtil(success, message);
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

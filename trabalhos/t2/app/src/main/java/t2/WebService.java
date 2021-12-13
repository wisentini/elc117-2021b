package t2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WebService {
    private static final String baseUrl = "https://script.google.com/macros/s/AKfycbxFHJM5G11Wc4SRwl4Gh3VKun9_QzlfmFAthGI0rihrbd9maY3c3nb8XFaE020HMYQc/exec?";

    public static JsonObject sendRequest(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = reader.lines().collect(Collectors.joining());
        connection.disconnect();

        JsonElement jsonElement = JsonParser.parseString(response);
        return jsonElement.getAsJsonObject();
    }

    public static List<Category> getCategories() throws Exception {
        String action = Util.encode("getCategories");
        String urlString = baseUrl + String.format("action=%s", action);

        JsonObject response = sendRequest(urlString);
        JsonArray jsonArray = response.getAsJsonArray("objects");

        Category[] categories = new GsonBuilder().create().fromJson(jsonArray, Category[].class);

        return Arrays.asList(categories);
    }

    public static List<String> getCategoryFromCategories(List<Category> categories) {
        List<String> categoryList = new ArrayList<String>();

        for (Category category : categories) {
            categoryList.add(category.getCategory());
        }

        return categoryList;
    }

    public static List<String> getDescriptionFromCategories(List<Category> categories) {
        List<String> descriptions = new ArrayList<String>();

        for (Category category : categories) {
            descriptions.add(category.getDescription());
        }

        return descriptions;
    }

    public static List<Resource> getResources() throws Exception {
        String action = Util.encode("getResources");
        String urlString = baseUrl + String.format("action=%s", action);

        JsonObject response = sendRequest(urlString);
        JsonArray jsonArray = response.getAsJsonArray("objects");

        Resource[] resources = new GsonBuilder().create().fromJson(jsonArray, Resource[].class);
        return Arrays.asList(resources);
    }

    public static WebServiceResponse postResource(Resource resource) throws Exception {
        String action = Util.encode("postResource");
        String url = Util.encode(resource.getUrl());
        String languageId = Util.encode(resource.getLanguageId());
        String tags = Util.encode(resource.getTags());
        String category = Util.encode(resource.getCategory());
        String comment = Util.encode(resource.getComment());
        String userId = Util.encode(resource.getUserId());

        String urlString = baseUrl + String.format("action=%s&url=%s&languageId=%s&tags=%s&category=%s&comment=%s&userId=%s", action, url, languageId, tags, category, comment, userId);

        JsonObject response = sendRequest(urlString);

        boolean success = response.get("success").getAsBoolean();
        String message = response.get("message").toString();

        return new WebServiceResponse(success, message);
    }

    public static List<Resource> getResourcesByLanguageId(String languageId) throws Exception {
        String action = Util.encode("getResourcesByLanguage");
        languageId = Util.encode(languageId);
        String urlString = baseUrl + String.format("action=%s&languageId=%s", action, languageId);

        JsonObject response = sendRequest(urlString);
        JsonArray jsonArray = response.getAsJsonArray("objects");

        Resource[] resources = new GsonBuilder().create().fromJson(jsonArray, Resource[].class);
        return Arrays.asList(resources);
    }

    public static List<Resource> getResourcesByCategory(String category) throws Exception {
        String action = Util.encode("getResourcesByCategory");
        category = Util.encode(category);
        String urlString = baseUrl + String.format("action=%s&category=%s", action, category);

        JsonObject response = sendRequest(urlString);
        JsonArray jsonArray = response.getAsJsonArray("objects");

        Resource[] resources = new GsonBuilder().create().fromJson(jsonArray, Resource[].class);
        return Arrays.asList(resources);
    }

    public static List<Resource> getResourcesByUserId(String userId) throws Exception {
        List<Resource> resources = getResources();
        List<Resource> filteredResources = resources.stream().filter(resource -> resource.getUserId().equals(userId)).collect(Collectors.toList());
        return filteredResources;
    }

    public static List<Resource> getResourcesByTags(String tags) throws Exception {
        List<Resource> resources = getResources();
        String[] splittedTags = tags.split(";");

        List<Resource> filteredResources = resources.stream().filter(resource -> Arrays.stream(splittedTags).anyMatch(resource.getTags()::contains)).collect(Collectors.toList());
        return filteredResources;
    }
}

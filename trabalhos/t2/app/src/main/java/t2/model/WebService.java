package t2.model;

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

import javafx.concurrent.Task;
import t2.util.StringUtil;
import t2.util.WebServiceResponseUtil;

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

    public static Task<List<Category>> getCategoriesTask() {
        return new Task<List<Category>>() {
            @Override protected List<Category> call() throws Exception {
                String action = StringUtil.encode("getCategories");
                String urlString = baseUrl + String.format("action=%s", action);
        
                JsonObject response = sendRequest(urlString);
                JsonArray jsonArray = response.getAsJsonArray("objects");
        
                Category[] categories = new GsonBuilder().create().fromJson(jsonArray, Category[].class);
        
                return Arrays.asList(categories);
            }
        };
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

    public static Task<List<Resource>> getResourcesTask() {
        return new Task<List<Resource>>() {
            @Override protected List<Resource> call() throws Exception {
                String action = StringUtil.encode("getResources");
                String urlString = baseUrl + String.format("action=%s", action);

                JsonObject response = sendRequest(urlString);
                JsonArray jsonArray = response.getAsJsonArray("objects");

                Resource[] resources = new GsonBuilder().create().fromJson(jsonArray, Resource[].class);
                return Arrays.asList(resources);
            }
        };
    }

    public static Task<WebServiceResponseUtil> postResourceTask(Resource resource) {
        return new Task<WebServiceResponseUtil>() {
            @Override protected WebServiceResponseUtil call() throws Exception {
                String action = StringUtil.encode("postResource");
                String url = StringUtil.encode(resource.getUrl());
                String languageId = StringUtil.encode(resource.getLanguageId());
                String tags = StringUtil.encode(resource.getTags());
                String category = StringUtil.encode(resource.getCategory());
                String comment = StringUtil.encode(resource.getComment());
                String userId = StringUtil.encode(resource.getUserId());

                String urlString = baseUrl + String.format("action=%s&url=%s&languageId=%s&tags=%s&category=%s&comment=%s&userId=%s", action, url, languageId, tags, category, comment, userId);

                JsonObject response = sendRequest(urlString);

                boolean success = response.get("success").getAsBoolean();
                String message = response.get("message").toString();

                return new WebServiceResponseUtil(success, message);
            }
        };
    }

    public static Task<List<Resource>> getResourcesByLanguageIdTask(String languageId) {
        return new Task<List<Resource>>() {
            @Override protected List<Resource> call() throws Exception {
                String action = StringUtil.encode("getResourcesByLanguage");
                String urlString = baseUrl + String.format("action=%s&languageId=%s", action, StringUtil.encode(languageId));

                JsonObject response = sendRequest(urlString);
                JsonArray jsonArray = response.getAsJsonArray("objects");

                Resource[] resources = new GsonBuilder().create().fromJson(jsonArray, Resource[].class);
                return Arrays.asList(resources);
            }
        };
    }

    public static Task<List<Resource>> getResourcesByCategoryTask(String category) {
        return new Task<List<Resource>>() {
            @Override protected List<Resource> call() throws Exception {
                String action = StringUtil.encode("getResourcesByCategory");
                String urlString = baseUrl + String.format("action=%s&category=%s", action, StringUtil.encode(category));

                JsonObject response = sendRequest(urlString);
                JsonArray jsonArray = response.getAsJsonArray("objects");

                Resource[] resources = new GsonBuilder().create().fromJson(jsonArray, Resource[].class);
                return Arrays.asList(resources);
            }
        };
    }

    public static List<Resource> filterResourcesByLanguageId(List<Resource> resources, String languageId) {
        return (resources
            .stream()
            .filter(
                resource -> resource
                .getUserId()
                .equals(languageId)
            )
            .collect(
                Collectors.toList()
            )
        );
    }

    public static List<Resource> filterResourcesByCategory(List<Resource> resources, String category) {
        return (resources
            .stream()
            .filter(
                resource -> resource
                .getUserId()
                .equals(category)
            )
            .collect(
                Collectors.toList()
            )
        );
    }

    public static List<Resource> filterResourcesByUserId(List<Resource> resources, String userId) {
        return (resources
            .stream()
            .filter(
                resource -> resource
                .getUserId()
                .equals(userId)
            )
            .collect(
                Collectors.toList()
            )
        );
    }

    public static List<Resource> filterResourcesByTags(List<Resource> resources, String tags) {
        return (resources
            .stream()
            .filter(
                resource -> Arrays
                .stream(
                    tags
                    .split(";")
                )
                .anyMatch(
                    resource
                    .getTags()::contains
                )
            )
            .collect(
                Collectors.toList()
            )
        );
    }

    public static Task<WebServiceResponseUtil> postLanguageTask(Language language) {
        return new Task<WebServiceResponseUtil>() {
            @Override protected WebServiceResponseUtil call() throws Exception {
                String action = StringUtil.encode("postLanguage");
                String languageId = StringUtil.encode(language.getLanguageId());
                String firstAppeared = StringUtil.encode(language.getFirstAppeared());
                String paradigm = StringUtil.encode(language.getParadigm());
                String userId = StringUtil.encode(language.getUserId());

                String urlString = baseUrl + String.format("action=%s&languageId=%s&firstAppeared=%s&paradigm=%s&userId=%s", action, languageId, firstAppeared, paradigm, userId);

                JsonObject response = sendRequest(urlString);

                boolean success = response.get("success").getAsBoolean();
                String message = response.get("message").toString();

                return new WebServiceResponseUtil(success, message);
            }
        };
    }

    public static Task<List<Language>> getLanguagesTask() {
        return new Task<List<Language>>() {
            @Override protected List<Language> call() throws Exception {
                String action = StringUtil.encode("getLanguages");
                String urlString = baseUrl + String.format("action=%s", action);

                JsonObject response = sendRequest(urlString);
                JsonArray jsonArray = response.getAsJsonArray("objects");

                Language[] languages = new GsonBuilder().create().fromJson(jsonArray, Language[].class);
                return Arrays.asList(languages);
            }
        };
    }
}

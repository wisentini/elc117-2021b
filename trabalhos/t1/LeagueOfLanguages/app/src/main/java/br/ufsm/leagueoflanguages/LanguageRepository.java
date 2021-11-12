package br.ufsm.leagueoflanguages;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LanguageRepository {
    private String baseUrl = "https://script.google.com/macros/s/AKfycbxFHJM5G11Wc4SRwl4Gh3VKun9_QzlfmFAthGI0rihrbd9maY3c3nb8XFaE020HMYQc/exec?";
    private String githubUserApiEndpoint = "https://api.github.com/users/";
    private List<String> userIds = new ArrayList<>(List.of("AfroFuturist", "crazynds", "Davidlopes22", "DeivisFelipe", "edusmrs", "MarcosNoble", "phcosta0", "Pivetta21", "VirginiaColares", "wisentini"));

    private JsonObject sendRequest(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = reader.lines().collect(Collectors.joining());
        connection.disconnect();

        JsonElement jsonElement = JsonParser.parseString(response);
        return jsonElement.getAsJsonObject();
    }

    public String save(Language language) throws Exception {
        String action = "postLanguage";
        String languageId = URLEncoder.encode(language.getLanguageId(), StandardCharsets.UTF_8);
        String firstAppeared = URLEncoder.encode(language.getFirstAppeared(), StandardCharsets.UTF_8);
        String paradigm = URLEncoder.encode(language.getParadigm(), StandardCharsets.UTF_8);
        String userId = URLEncoder.encode(language.getUserId(), StandardCharsets.UTF_8);

        String urlString = baseUrl + String.format("action=%s&languageId=%s&firstAppeared=%s&paradigm=%s&userId=%s", action, languageId, firstAppeared, paradigm, userId);

        JsonObject response = sendRequest(urlString);
        return response.get("message").toString();
    }

    public List<Language> findAll() throws Exception {
        String action = "getLanguages";
        String urlString = baseUrl + String.format("action=%s", action);

        JsonObject response = this.sendRequest(urlString);
        JsonArray jsonArray = response.getAsJsonArray("objects");

        Language[] languages = new GsonBuilder().create().fromJson(jsonArray, Language[].class);
        return Arrays.asList(languages);
    }

    public List<Language> getLanguagesByOrderOfAppearance() throws Exception {
        List<Language> languages = this.findAll();
        Collections.sort(languages, Comparator.comparing(Language::getFirstAppeared));
        return languages;
    }

    public boolean validateUserId(String userId) throws Exception {
        String urlString = this.githubUserApiEndpoint + userId;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        int responseCode = connection.getResponseCode();
        connection.disconnect();

        return responseCode == 200 && this.userIds.contains(userId);
    }
}

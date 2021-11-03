package br.ufsm.leagueoflanguages;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LanguageRepository {
  private String baseurl = "https://script.google.com/macros/s/AKfycbxFHJM5G11Wc4SRwl4Gh3VKun9_QzlfmFAthGI0rihrbd9maY3c3nb8XFaE020HMYQc/exec?";

  private JsonObject sendRequest(String urlstr) throws Exception {

    URL url = new URL(urlstr);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String response = rd.lines().collect(Collectors.joining());
    con.disconnect();

    JsonElement jelement = JsonParser.parseString(response);
    return jelement.getAsJsonObject();
  }

  public String save(Language lang) throws Exception {

    String action = "postLanguage";
    String urlstr = baseurl + 
      String.format("action=%s&languageId=%s&firstAppeared=%s&paradigm=%s&userId=%s", action,
      lang.getLanguageId(), lang.getFirstAppeared(), lang.getParadigm(), lang.getUserId());

    JsonObject response = sendRequest(urlstr);
    return response.get("message").toString();

  }


  public List<Language> findAll() throws Exception {

    String action = "getLanguages";
    String urlstr = baseurl + String.format("action=%s", action);

    JsonObject response = this.sendRequest(urlstr);
    JsonArray jarray = response.getAsJsonArray("objects");

    Language[] langArray = new GsonBuilder().create().fromJson(jarray, Language[].class);
    return Arrays.asList(langArray);

  }
}



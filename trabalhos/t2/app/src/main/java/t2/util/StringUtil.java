package t2.util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StringUtil {
    public static String toJSON(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String string = gson.toJson(object);
        return string;
    }

    public static String encode(String string) {
        return URLEncoder.encode(string, StandardCharsets.UTF_8);
    }
}

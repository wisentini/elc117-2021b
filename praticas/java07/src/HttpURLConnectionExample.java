import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

// Exemplo simples de requisição HTTP usando somente as APIs do JDK 
// Este código pode ser reduzido usando APIs especializadas, por exemplo Apache HttpClient
public class HttpURLConnectionExample {

  public static void main(String[] args) throws Exception {
    // String urlstr = "https://api.github.com/users/andreainfufsm";
    String urlstr = "https://script.google.com/macros/s/AKfycbzgXyPnrGgphGTx2TSzaJFJIrDd356wP5tibDRqHKVBH3hHwFj8MQjUOFz7NsBbbvphSQ/exec?action=get";
    URL url = new URL(urlstr);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    System.out.println("\nSending GET request to URL: " + urlstr);
    int responseCode = con.getResponseCode();
    System.out.println("Response Code: " + responseCode);

    // Cria buffers para leitura de dados a partir da conexão HTTP estabelecida
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String response = in.lines().collect(Collectors.joining());
    con.disconnect();

    System.out.println(response.toString());

  }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.stream.Collectors;

// Exemplo simples de requisição HTTP usando somente as APIs do JDK 
// Este código pode ser reduzido usando APIs especializadas, por exemplo Apache HttpClient
public class HttpURLConnectionExample {
    public static void main(String[] args) {
        String urlString = "https://api.github.com/users/wisentini";
        HttpURLConnection con = null;
        int responseCode = 0;
        String response = "";

        try {
            URL url = new URL(urlString);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            System.out.println("\nSending GET request to URL: " + urlString);
            responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            response = in.lines().collect(Collectors.joining());
        } catch (MalformedInputException mie) {
            System.out.println("\nNão foi possível criar uma URL a partir da string informada.");
        } catch (ProtocolException pe) {
            System.out.println("\nNão foi possível enviar o método de requisição à conexão.");
        } catch (IOException ioe) {
            System.out.println("\nNão foi possível estabelecer uma conexão com a URL criada.");
        } finally {
            con.disconnect();
            System.out.println("\nResponse code: " + responseCode);
            System.out.println("\nResponse: " + response.toString());
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Exemplo simples de requisição HTTP usando somente as APIs do JDK 
// Este código pode ser reduzido usando APIs especializadas, por exemplo Apache HttpClient
public class HttpURLConnectionExample {
    public static void main(String[] args) throws Exception {
        HttpURLConnectionExample http = new HttpURLConnectionExample();
        http.sendGet();
    }

    private void sendGet() throws Exception {
        String urlString = "https://api.github.com/users/wisentini";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        System.out.println("\nSending GET request to URL: " + urlString);
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Cria buffers para leitura de dados a partir da conexão HTTP estabelecida
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();
        String inputLine;

        // Lê a resposta linha por linha
        while ((inputLine = input.readLine()) != null) {
            response.append(inputLine);
        }

        input.close();

        System.out.println(response.toString());
    }
}

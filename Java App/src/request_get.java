import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class request_get {
    public static void main(String[] args) {
        try {
            String apiurl = "http://localhost:8080/api/user";

            URL url = new URL(apiurl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuffer response = new StringBuffer();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                System.out.println("Réponse de l'API : " + response.toString());
            } else {
                System.out.println("La requête a échoué avec le code : " + responseCode);
            }

            connection.disconnect();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
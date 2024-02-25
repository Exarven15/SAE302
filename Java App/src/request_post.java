import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class request_post {

    public JSONObject main(String login, String password) throws Exception {
        try {
            String apiUrl = "http://10.3.122.100:8080/api/auth";

            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurer la connexion pour une requête POST
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            // Activer l'envoi de données
            connection.setDoOutput(true);

            // Exemple de données JSON à envoyer avec la requête POST
            String jsonData = "{\"login\":\"" + login + "\",\"password\":\"" + password + "\"}";

            // Écrire les données dans le flux de sortie de la connexion
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.writeBytes(jsonData);
                wr.flush();
            }

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lire la réponse de l'API
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuffer response = new StringBuffer();

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    // Convertir la réponse en JSONObject
                    JSONObject jsonResponse = new JSONObject(response.toString());

                    // Fermer la connexion
                    connection.disconnect();

                    // Retourner le JSONObject
                    return jsonResponse;
                }
            } else {
                // Fermer la connexion
                connection.disconnect();

                // Lever une exception en cas d'échec de la requête
                throw new Exception("La requête a échoué avec le code : " + responseCode);
            }

        } catch (Exception e) {
            throw e;
        }
    }
}
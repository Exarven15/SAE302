import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class request_post_icmp {
    public static void main(String[] args) {
        try {
            String apiUrl = "http://localhost:8080/api/icmp";

            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurer la connexion pour une requête POST
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            // Activer l'envoi de données
            connection.setDoOutput(true);

            // Exemple de données JSON à envoyer avec la requête POST
            String jsonData = "{\"numseq\":\"test1\",\"reponse\":\"test2\",\"psrc\":\"test3\",\"pdest\":\"test4\",\"protocole\":\"test5\",\"paquet\":\"test6\",\"date\":\"test7\",\"intdescript\":\"test8\",\"numtrame\":\"test9\",\"macsrc\":\"test10\",\"macdest\":\"test11\",\"marque\":\"test12\",\"protocole\":\"test13\",\"ipsrc\":\"test14\",\"ipdest\":\"test15\",\"transid\":\"test16\"}";

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

                    System.out.println("Réponse de l'API : " + response.toString());
                }
            } else {
                System.out.println("La requête a échoué avec le code : " + responseCode);
            }

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

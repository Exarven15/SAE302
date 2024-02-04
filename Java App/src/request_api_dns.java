import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class request_api_dns {

    public void main(String date, String intdescript, String numtrame, String macsrc, String macdest, String marque, String protocole, String ipsrc, String ipdest, String protocoletrans, String psrc, String pdest, String recherche, String reponse) {
        try {
            String apiUrl = "http://10.3.122.100:8080/api/dns";

            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurer la connexion pour une requête POST
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            // Activer l'envoi de données
            connection.setDoOutput(true);

            // Exemple de données JSON à envoyer avec la requête POST
            String jsonData = "{\"date\":\"" + date + "\",\"intdescript\":\"" + intdescript + "\",\"numtrame\":\"" + numtrame + "\",\"macsrc\":\"" + macsrc + "\",\"macdest\":\"" + macdest + "\",\"marque\":\"" + marque + "\",\"ipsrc\":\"" + ipsrc + "\",\"ipdest\":\"" + ipdest + "\",\"protocole\":\"" + protocole + "\",\"psrc\":\"" + psrc +"\",\"pdest\":\"" + pdest +"\",\"recherche\":\"" + recherche +"\",\"reponse\":\"" + reponse + "\"}";

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
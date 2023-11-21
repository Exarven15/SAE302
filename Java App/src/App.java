import java.io.FileReader;
import org.json.JSONObject;

public class App {

    static String fileString = "C:/Users/alexa/OneDrive/Bureau/SAE java/SAE302/Java App/ressources/test.json";
    public static void main(String[] args) throws Exception {

        FileHandlerJSON file = new FileHandlerJSON();

        FileReader reader = file.readerFromFile(fileString);
        JSONObject layers = file.layersFromFile(reader);

        JSONObject frame = file.frameFromFile(layers);
        JSONObject eth = file.ethFromFile(layers);
        JSONObject ipv6 = file.ipv6FromFile(layers);
        JSONObject udp = file.udpFromFile(layers);
        JSONObject dns = file.dnsFromFile(layers);

        System.out.println(frame + "\n\n------------------------------------------------------------------------------\n");
        System.out.println(eth + "\n\n------------------------------------------------------------------------------\n");
        System.out.println(ipv6 + "\n\n------------------------------------------------------------------------------\n");
        System.out.println(udp + "\n\n------------------------------------------------------------------------------\n");
        System.out.println(dns + "\n\n------------------------------------------------------------------------------\n");
    }
}
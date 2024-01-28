import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;  

public class App {

    static String FILESTRING = "C:/Users/alexa/OneDrive/Bureau/SAE java/SAE302/Java App/ressources/ui.json";
    public static void main(String[] args) throws Exception {

        FileHandlerJSON file = new FileHandlerJSON();

        FileReader reader = file.readerFromFile(FILESTRING);
        JSONArray array = file.arrayFromFile(reader);

        Integer arraysize = file.arraySize(array);

        for (Integer i = 0; i < arraysize; i++) {
            JSONObject layers = file.layersFromFile(i, array);
            JSONObject ipv6 = file.ipv6FromFile(layers);
            JSONObject eth = file.ethFromFile(layers);
            JSONObject udp = file.udpFromFile(layers);
            JSONObject dns = file.dnsFromFile(layers);
            file.printObject(ipv6);
            file.printObject(eth);
            file.printObject(udp);
            file.printObject(dns);
        }
    }
}
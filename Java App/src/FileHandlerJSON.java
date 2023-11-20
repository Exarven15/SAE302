import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;

public class FileHandlerJSON {
    
    public FileReader readerFromFile (String file) {
        try {
            FileReader reader = new FileReader(file);
            return reader;
        }
        catch (Exception e) {
            System.out.println("An error as occured : " + e);
        }
        return null;
    }

    public JSONObject layersFromFile (FileReader reader) {
        JSONArray array = new JSONArray(new JSONTokener(reader));
        JSONObject data = array.getJSONObject(0);
        JSONObject source = data.getJSONObject("_source");
        JSONObject layers = source.getJSONObject("layers");
        return layers;
    }

    public JSONObject frameFromFile (JSONObject layers) {
        JSONObject frame = layers.getJSONObject("frame");
        return frame;
    }

    public JSONObject ethFromFile (JSONObject layers) {
        JSONObject eth = layers.getJSONObject("eth");
        return eth;
    }

    public JSONObject ipv6FromFile (JSONObject layers) {
        JSONObject ipv6 = layers.getJSONObject("ipv6");
        return ipv6;
    }

    public JSONObject udpFromFile (JSONObject layers) {
        JSONObject udp = layers.getJSONObject("udp");
        return udp;
    }

    public JSONObject dnsFromFile (JSONObject layers) {
        JSONObject dns = layers.getJSONObject("dns");
        return dns;
    }
}

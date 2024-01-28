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

    public JSONArray arrayFromFile (FileReader reader) {
        JSONArray array = new JSONArray(new JSONTokener(reader));
        return array;
    }

    public JSONObject layersFromFile (Integer objectint, JSONArray array) {
        JSONObject data = array.getJSONObject(objectint);
        JSONObject source = data.getJSONObject("_source");
        JSONObject layers = source.getJSONObject("layers");
    return layers;
    }

    public JSONObject frameFromFile (JSONObject layers) {
        try {
        JSONObject frame = layers.getJSONObject("frame");
        return frame;
        }
        catch (Exception e) {
            //do nothing
        }
        return null;
    }

    public JSONObject ethFromFile (JSONObject layers) {
        try {
        JSONObject eth = layers.getJSONObject("eth");
        return eth;
        }
        catch (Exception e) {
            //do nothing
        }
        return null;
    }

    public JSONObject ipv6FromFile (JSONObject layers) {
        try {
            JSONObject ipv6 = layers.getJSONObject("ipv6");
            return ipv6;
        }
        catch (Exception e){
            // do nothing
        }
        return null;
    }

    public JSONObject udpFromFile (JSONObject layers) {
        try {
        JSONObject udp = layers.getJSONObject("udp");
        return udp;
        }
        catch (Exception e) {
            //do nothing
        }
        return null;
    }

    public JSONObject dnsFromFile (JSONObject layers) {
        try {
        JSONObject dns = layers.getJSONObject("dns");
        return dns;
        }
        catch (Exception e) {
            //do nothing
        }
        return null;
    }

    public Integer arraySize (JSONArray array) {
        Integer size = array.length();
        return size; 
    }

    public void printObject (JSONObject o) {
        if (o != null) {
            System.out.println(o + "\n\n------------------------------------------------------------------------------\n");
        }
    }
}

import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;  

public class App {

    static String FILESTRING = "/home/users/etudiant/l/la112398/Bureau/SAE_java/SAE302/Java App/ressources/ui.json";
    public static void main(String[] args) throws Exception {

        // request_post request = new request_post();
        // request.main("mathieu", "test2");

        FileHandlerJSON file = new FileHandlerJSON();

        FileReader reader = file.readerFromFile(FILESTRING);

        JSONArray array = file.arrayFromFile(reader);

        // Integer arraysize = file.arraySize(array);

        JSONObject layers = file.layersFromFile(0, array);

        Frame frame = file.getFrameData(layers);
        Ethernet ethernet = file.getEthernetData(layers);
        Arp arp = file.getArpData(layers);
        Ip ip = file.getIpData(layers);
        Tcp tcp = file.getTcpData(layers);
        Udp udp = file.getUdpData(layers);

        System.out.println(udp.Portdst);

        // for (Integer i = 0; i < arraysize; i++) {
        //     JSONObject layers = file.layersFromFile(i, array);
        //     JSONObject ipv6 = file.ipv6FromFile(layers);
        //     JSONObject eth = file.ethFromFile(layers);
        //     JSONObject udp = file.udpFromFile(layers);
        //     JSONObject dns = file.dnsFromFile(layers);
        //     file.printObject(ipv6);
        //     file.printObject(eth);
        //     file.printObject(udp);
        //     file.printObject(dns);
        // }
    }
}
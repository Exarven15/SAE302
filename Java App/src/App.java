import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;  

public class App {

    static String FILESTRING = "C:/Users/alexa/OneDrive/Bureau/SAE java/SAE302/Java App/ressources/ui.json";
    public static void main(String[] args) throws Exception {

        // request_post request = new request_post();
        // request.main("mathieu", "test2");

        FileHandlerJSON file = new FileHandlerJSON();

        request_api_dns bite = new request_api_dns();

        FileReader reader = file.readerFromFile(FILESTRING);

        JSONArray array = file.arrayFromFile(reader);

        // Integer arraysize = file.arraySize(array);

        JSONObject layers = file.layersFromFile(1, array);

        // Frame frame = file.getFrameData(layers);
        // Ethernet ethernet = file.getEthernetData(layers);
        // Arp arp = file.getArpData(layers);
        // Ip ip = file.getIpData(layers);
        // Tcp tcp = file.getTcpData(layers);
        // Udp udp = file.getUdpData(layers);
        // Icmp icmp = file.getIcmpData(layers);
        // Dns dns = file.getDnsData(layers);

        Frame frame = file.getFrameData(layers);
        Ethernet ethernet = file.getEthernetData(layers);
        Ip ip = file.getIpData(layers);
        Udp udp = file.getUdpData(layers);
        Dns dns = file.getDnsData(layers);

        bite.main(frame.Date, frame.Interface, frame.Id, ethernet.MACsrc, ethernet.MACdst, ethernet.Brandsrc, "ip", ip.IPsrc, ip.IPdst, udp.Portsrc, udp.Portdst, "udp", dns.DNSQueryName, dns.DNSAnswerInfo);

        // for (Integer i = 0; i < arraysize; i++) {
        //     JSONObject layers = file.layersFromFile(i, array);
        //     Frame frame = file.getFrameData(layers);
        //     Ethernet ethernet = file.getEthernetData(layers);
        //     Ip ip = file.getIpData(layers);
        //     Udp udp = file.getUdpData(layers);
        //     Dns dns = file.getDnsData(layers);
        //     if (frame != null || ethernet != null || ip != null || udp != null || dns != null) {
        //         System.out.println(frame);
        //         System.out.println(ethernet);
        //         System.out.println(ip);
        //         System.out.println(udp);
        //         System.out.println(dns);
        //     }
        // }
    }
}
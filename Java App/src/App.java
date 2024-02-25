import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;  

public class App {

    static String FILESTRING = "C:/Users/alexa/OneDrive/Bureau/SAE java/SAE302/Java App/ressources/ui.json";
    public static void main(String[] args) throws Exception {

        request_post request = new request_post();

        JSONObject token = request.main("alexandre", "lancar");

        String tokensString = token.getString("token");

        FileHandlerJSON file = new FileHandlerJSON();
        FileReader reader = file.readerFromFile(FILESTRING);
        JSONArray array = file.arrayFromFile(reader);

        Integer arraysize = file.arraySize(array);
        
        for (Integer i = 0; i < arraysize; i++) {

            JSONObject layers = file.layersFromFile(i, array);
            String packetType = file.packetType(layers);

            switch (packetType) {

                case "eth:ethertype:arp":

                    request_api_arp api_arp = new request_api_arp();

                    Frame frame_arp = file.getFrameData(layers);
                    Ethernet ethernet_arp = file.getEthernetData(layers);
                    Arp arp = file.getArpData(layers);

                    api_arp.main(frame_arp.Date, frame_arp.Interface, frame_arp.Id, ethernet_arp.MACsrc, ethernet_arp.MACdst, ethernet_arp.Branddst, 
                    "ARP", arp.IPsrc, arp.IPdst, tokensString);
                    break;
        
                case "eth:ethertype:ip:tcp":

                    request_api_tcp api_tcp = new request_api_tcp();

                    Frame frame_tcp = file.getFrameData(layers);
                    Ethernet ethernet_tcp = file.getEthernetData(layers);
                    Ip ip_tcp = file.getIpData(layers);
                    Tcp tcp = file.getTcpData(layers);

                    api_tcp.main(frame_tcp.Date, frame_tcp.Interface, frame_tcp.Id, ethernet_tcp.MACsrc, ethernet_tcp.MACdst, ethernet_tcp.Branddst, 
                    "IP", ip_tcp.IPsrc, ip_tcp.IPdst, tcp.Portsrc, tcp.Portdst, tokensString);
                    break;

                case "eth:ethertype:ip:udp:dns":
                    
                    request_api_dns api_dns = new request_api_dns();

                    Frame frame_dns = file.getFrameData(layers);
                    Ethernet ethernet_dns = file.getEthernetData(layers);
                    Ip ip_dns = file.getIpData(layers);
                    Udp udp_dns = file.getUdpData(layers);
                    Dns dns = file.getDnsData(layers);

                    api_dns.main(frame_dns.Date, frame_dns.Interface, frame_dns.Id, ethernet_dns.MACsrc, ethernet_dns.MACdst, ethernet_dns.Branddst, "IP", 
                    ip_dns.IPsrc, ip_dns.IPdst, "UDP", udp_dns.Portsrc, udp_dns.Portdst, dns.DNSQueryName, dns.DNSAnswerName, dns.DNSAnswerInfo, 
                    dns.DNSAnswerTime, tokensString);
                    break;
                    

                case "eth:ethertype:ip:icmp:data":
                    
                    request_api_icmp api_icmp = new request_api_icmp();

                    Frame frame_icmp = file.getFrameData(layers);
                    Ethernet ethernet_icmp = file.getEthernetData(layers);
                    Ip ip_icmp = file.getIpData(layers);
                    Icmp icmp = file.getIcmpData(layers);
                    
                    api_icmp.main(frame_icmp.Date, frame_icmp.Interface, frame_icmp.Id, ethernet_icmp.MACsrc, ethernet_icmp.MACdst, ethernet_icmp.Branddst, 
                    "IP", ip_icmp.IPsrc, ip_icmp.IPdst, icmp.ICMPid, icmp.ICMPtime, tokensString);
                    break;
            }
        }
    }
}
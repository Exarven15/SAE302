import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;

public class App {

    public static void main(String[] args) throws Exception {

        // Check if the program has command-line arguments or needs help
        if (args.length == 0 || args[0].equals("help")) {
            printHelp();
            return;
        } else {
            // Process different commands based on the provided arguments
            switch (args[0]) {

                // Command to create a user
                case "createuser":
                    try {
                        // Create a new user using provided login and password
                        request_api_create_user request = new request_api_create_user();
                        request.main(args[1], args[2]);
                    } catch (Exception e) {
                        // Handle exceptions related to user creation
                        System.out.println("An error has occurred. Make sure to provide a login and a password.");
                    }
                    break;

                // Command to send packets
                case "sendpackets":
                    try {
                        // Send packets using provided filepath, login, and password
                        sendPackets(args[1], args[2], args[3]);
                    } catch (Exception e) {
                        // Handle exceptions related to sending packets
                        System.out.println("An error has occurred. Make sure you have an account with 'createuser', and that you gave a valid filepath with login and password.");
                    }
                    break;

                // Default case for unknown commands
                default:
                    System.out.println("An error has occurred. Please check the 'help' argument for instructions on how to use the program.");
                    break;
            }
            return;
        }
    }

    // Method to send packets
    public static void sendPackets(String FILESTRING, String login, String password) throws Exception {

        // Initialize API request object
        request_post request = new request_post();

        // Obtain authentication token using provided login and password
        JSONObject token = request.main(login, password);
        String tokensString = token.getString("token");

        // Initialize JSON file handler
        FileHandlerJSON file = new FileHandlerJSON();
        FileReader reader = file.readerFromFile(FILESTRING);
        JSONArray array = file.arrayFromFile(reader);

        // Process each packet in the JSON array
        Integer arraysize = file.arraySize(array);
        for (Integer i = 0; i < arraysize; i++) {

            // Extract data from the layers of the packet
            JSONObject layers = file.layersFromFile(i, array);
            String packetType = file.packetType(layers);

            // Perform actions based on the type of packet
            switch (packetType) {

                // ARP packet
                case "eth:ethertype:arp":
                    request_api_arp api_arp = new request_api_arp();
                    Frame frame_arp = file.getFrameData(layers);
                    Ethernet ethernet_arp = file.getEthernetData(layers);
                    Arp arp = file.getArpData(layers);

                    api_arp.main(frame_arp.Date, frame_arp.Interface, frame_arp.Id, ethernet_arp.MACsrc, ethernet_arp.MACdst, ethernet_arp.Branddst,
                            "ARP", arp.IPsrc, arp.IPdst, tokensString);
                    break;

                // TCP packet
                case "eth:ethertype:ip:tcp":
                    request_api_tcp api_tcp = new request_api_tcp();
                    Frame frame_tcp = file.getFrameData(layers);
                    Ethernet ethernet_tcp = file.getEthernetData(layers);
                    Ip ip_tcp = file.getIpData(layers);
                    Tcp tcp = file.getTcpData(layers);

                    api_tcp.main(frame_tcp.Date, frame_tcp.Interface, frame_tcp.Id, ethernet_tcp.MACsrc, ethernet_tcp.MACdst, ethernet_tcp.Branddst,
                            "IP", ip_tcp.IPsrc, ip_tcp.IPdst, tcp.Portsrc, tcp.Portdst, tokensString);
                    break;

                // DNS packet
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

                // ICMP packet
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

    // Method to print help message
    private static void printHelp() {
        System.out.println("Usage:");
        System.out.println("java -jar PacketA.jar help                                : Display this help message");
        System.out.println("java -jar PacketA.jar createuser login password           : Create a user with specified login and password");
        System.out.println("java -jar PacketA.jar sendpackets filepath login password : Run with specified filepath, login, and password");
    }
}

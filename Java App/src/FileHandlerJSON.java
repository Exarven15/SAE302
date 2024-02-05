import java.io.FileReader;
import java.util.Iterator;

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

    public Frame getFrameData (JSONObject layers) {
        try {
        JSONObject frame = layers.getJSONObject("frame");
        String number = frame.getString("frame.number");
        String date = frame.getString("frame.time");
        JSONObject frame_interface = frame.getJSONObject("frame.interface_id_tree");
        String interface_description = frame_interface.getString("frame.interface_description");
        Frame frame_object = new Frame(date, interface_description, number);
        return frame_object;
        }
        catch (Exception e) {
            //do nothing
        }
        return null;
    }

    public Ethernet getEthernetData (JSONObject layers) {
        try {
        JSONObject eth = layers.getJSONObject("eth");
        JSONObject brand_src = eth.getJSONObject("eth.src_tree");
        JSONObject brand_dst = eth.getJSONObject("eth.dst_tree");
        String MACsrc = eth.getString("eth.src");
        String MACdst = eth.getString("eth.dst");
        String brand_name_src = "";
        String brand_name_dst = "";
        if (brand_src.has("eth.src.oui_resolved")) {
            brand_name_src = brand_src.getString("eth.src.oui_resolved");
        }
        else {
            brand_name_src = brand_src.getString("eth.src_resolved");
        }
        if (brand_dst.has("eth.dst.oui_resolved")) {
            brand_name_dst = brand_dst.getString("eth.dst.oui_resolved");
        }
        else {
            brand_name_dst = brand_dst.getString("eth.dst_resolved");
        }
        Ethernet ethernet_object = new Ethernet(MACsrc, MACdst, brand_name_src, brand_name_dst);
        return ethernet_object;
        }
        catch (Exception e) {
            //do nothing
        }
        return null;
    }

    public Arp getArpData (JSONObject layers) {
        try {
        JSONObject arp = layers.getJSONObject("arp");
        String IPsrc = arp.getString("arp.src.proto_ipv4");
        String IPdst = arp.getString("arp.dst.proto_ipv4");
        Arp arp_object = new Arp(IPsrc, IPdst);
        return arp_object;
        }
        catch (Exception e) {
            //do nothing
        }
        return null;
    }

    public Ip getIpData (JSONObject layers) {
        try {
        JSONObject ip = layers.getJSONObject("ip");
        String IPsrc = ip.getString("ip.src");
        String IPdst = ip.getString("ip.dst");
        Ip ip_object = new Ip(IPsrc, IPdst);
        return ip_object;
        }
        catch (Exception e) {
            //do nothing
        }
        return null;
    }

    public Tcp getTcpData (JSONObject layers) {
        try {
        JSONObject tcp = layers.getJSONObject("tcp");
        String Portsrc = tcp.getString("tcp.srcport");
        String Portdst = tcp.getString("tcp.dstport");
        Tcp tcp_object = new Tcp(Portsrc, Portdst);
        return tcp_object;
        }
        catch (Exception e) {
            //do nothing
        }
        return null;
    }

    public Udp getUdpData (JSONObject layers) {
        try {
        JSONObject udp = layers.getJSONObject("udp");
        String Portsrc = udp.getString("udp.srcport");
        String Portdst = udp.getString("udp.dstport");
        Udp udp_object = new Udp(Portsrc, Portdst);
        return udp_object;
        }
        catch (Exception e) {
            //do nothing
        }
        return null;
    }

    public Dns getDnsData (JSONObject layers) {
        try {
        JSONObject dns = layers.getJSONObject("dns");
        JSONObject query = dns.getJSONObject("Queries");
        JSONObject answer = null;
        Iterator<String> answerKeys = null;
        String answerName = "";
        String answerInfo = "";
        String answerTime = "";
        Iterator<String> queryKeys = query.keys();
        String firstQueryKey = queryKeys.next();
        JSONObject firstQueryObject = query.getJSONObject(firstQueryKey);
        String queryName = firstQueryObject.getString("dns.qry.name");
        if (dns.has("Answers")) {
            answer = dns.getJSONObject("Answers");
            answerKeys = answer.keys();
            if (answerKeys.hasNext()) {
                String firstAnswerKey = answerKeys.next();
                JSONObject firstAnswerObject = answer.getJSONObject(firstAnswerKey);
                answerName = firstAnswerObject.getString("dns.resp.name");
                answerTime = dns.getString("dns.time");
                if (firstAnswerObject.has("dns.a")) {
                    answerInfo = firstAnswerObject.getString("dns.a");
                }
                else {
                    answerInfo = firstAnswerObject.getString("dns.cname");
                }
            }
        }
        Dns dns_object = new Dns(queryName, answerName, answerInfo, answerTime);
        return dns_object;
        }
        catch (Exception e) {
            //do nothing
        }
        return null;
    }

    public Icmp getIcmpData (JSONObject layers) {
        try {
        JSONObject icmp = layers.getJSONObject("icmp");
        String seq = icmp.getString("icmp.seq");
        String resptime = "";
        if (icmp.has("icmp.resptime")) {
            resptime = icmp.getString("icmp.resptime");
        }
        Icmp icmp_object = new Icmp(seq, resptime);
        return icmp_object;
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
}
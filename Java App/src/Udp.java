public class Udp {

    String IPsrc;
    String IPdst;
    String MACsrc;
    String MACdst;
    
    public Udp (String IPsrc, String IPdst, String MACsrc, String MACdst) {
        this.IPsrc = IPsrc;
        this.IPdst = IPdst;
        this.MACsrc = MACsrc;
        this.MACdst = MACdst;
    }

    public Udp () {
        this.IPsrc = "";
        this.IPdst = "";
        this.MACsrc = "";
        this.MACdst = "";
    }
}

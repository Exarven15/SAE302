public class Arp {

    String IPsrc;
    String IPdst;
    
    public Arp (String IPsrc, String IPdst) {
        this.IPsrc = IPsrc;
        this.IPdst = IPdst;
    }

    public Arp () {
        this.IPsrc = "";
        this.IPdst = "";
    }
}

public class Arp extends Ethernet {

    String IPsrc;
    String IPdst;
    
    public Arp (String IPsrc, String IPdst) {
        this.IPsrc = IPsrc;
        this.IPdst = IPdst;
    }
}

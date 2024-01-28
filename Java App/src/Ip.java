public class Ip extends Ethernet {
    
    String IPsrc;
    String IPdst;
    
    public Ip (String IPsrc, String IPdst) {
        this.IPsrc = IPsrc;
        this.IPdst = IPdst;
    }

    public Ip () {
        this.IPsrc = "";
        this.IPdst = "";
    } 
}

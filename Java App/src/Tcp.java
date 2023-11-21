public class Tcp {

    String IPsrc;
    String IPdst;
    String MACsrc;
    String MACdst;
    
    public Tcp (String IPsrc, String IPdst, String MACsrc, String MACdst) {
        this.IPsrc = IPsrc;
        this.IPdst = IPdst;
        this.MACsrc = MACsrc;
        this.MACdst = MACdst;
    }

    public Tcp () {
        this.IPsrc = "";
        this.IPdst = "";
        this.MACsrc = "";
        this.MACdst = "";
    } 
}

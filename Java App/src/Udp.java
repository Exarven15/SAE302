public class Udp extends Ip {
    
    String Portsrc;
    String Portdst;

    public Udp (String Portsrc, String Portdst) {
        this.Portsrc = Portsrc;
        this.Portdst = Portdst;
    }

    public Udp () {
        this.Portsrc = "";
        this.Portdst = "";
    } 
}

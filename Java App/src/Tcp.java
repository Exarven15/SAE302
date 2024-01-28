public class Tcp extends Ip {
    
    String Portsrc;
    String Portdst;

    public Tcp (String Portsrc, String Portdst) {
        this.Portsrc = Portsrc;
        this.Portdst = Portdst;
    }

    public Tcp () {
        this.Portsrc = "";
        this.Portdst = "";
    } 
}

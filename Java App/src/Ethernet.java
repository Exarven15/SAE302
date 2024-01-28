public class Ethernet extends Frame {

    String MACsrc;
    String MACdst;
    String Brandsrc;
    String Branddst;

    public Ethernet (String MACsrc, String MACdst, String Brandsrc, String Branddst) {
        this.MACsrc = MACsrc;
        this.MACdst = MACdst;
        this.Brandsrc = Brandsrc;
        this.Branddst = Branddst;
    }

    public Ethernet () {
        this.MACsrc = "";
        this.MACdst = "";
        this.Brandsrc = "";
        this.Branddst = "";
    }
}

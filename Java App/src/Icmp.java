public class Icmp extends Ip {

    String ICMPid;
    String ICMPtime;

    public Icmp (String ICMPid) {
        this.ICMPid = ICMPid;
    }

    public Icmp (String ICMPid, String ICMPtime) {
        this.ICMPid = ICMPid;
        this.ICMPtime = ICMPtime;
    }
}

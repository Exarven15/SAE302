public class Dns {

    String DNSQueryName;
    String DNSAnswerName;
    String DNSAnswerInfo;
    String DNSAnswerTime;

    public Dns (String DNSQueryName, String DNSAnswerName, String DNSAnswerInfo, String DNSAnswerTime) {
        this.DNSQueryName = DNSQueryName;
        this.DNSAnswerName = DNSAnswerName;
        this.DNSAnswerInfo = DNSAnswerInfo;
        this.DNSAnswerTime = DNSAnswerTime;
    }

    public Dns () {
        this.DNSQueryName = "";
        this.DNSAnswerName = "";
        this.DNSAnswerInfo = "";
        this.DNSAnswerTime = "";
    }
}

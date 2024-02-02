public class Dns {

    String DNSQueryName;
    String DNSAnswerName;
    String DNSAnswerAddress;
    String DNSAnswerTime;

    public Dns (String DNSQueryName) {
        this.DNSQueryName = DNSQueryName;
    }

    public Dns (String DNSQueryName, String DNSAnswerName, String DNSAnswerAddress, String DNSAnswerTime) {
        this.DNSQueryName = DNSQueryName;
        this.DNSAnswerName = DNSAnswerName;
        this.DNSAnswerAddress = DNSAnswerAddress;
        this.DNSAnswerTime = DNSAnswerTime;
    }
}

public class Tls {

    String ContentLength;
    String ConnectionType;
    String ConnectionName;
    String Content;
    String ContentProtocol;

    public Tls (String ConnectionType, String ContentLength, String ConnectionName) {
        this.ConnectionType = ConnectionType;
        this.ContentLength = ContentLength;
        this.ConnectionName = ConnectionName;
    }

    public Tls (String ConnectionType, String ContentLength, String Content, String ContentProtocol) {
        this.ConnectionType = ConnectionType;
        this.ContentLength = ContentLength;
        this.Content = Content;
        this.ContentProtocol = ContentProtocol;
    }
}

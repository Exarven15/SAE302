import java.util.Date;

public class Frame {

    Date Date;
    String Interface;
    String Id;

    public Frame (Date Date, String Interface, String Id) {
        this.Date = Date;
        this.Interface = Interface;
        this.Id = Id;
    }

    public Frame () {
        this.Date = null;
        this.Interface = "";
        this.Id = "";
    }
}

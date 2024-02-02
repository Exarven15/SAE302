public class Frame {

    String Date;
    String Interface;
    String Id;

    public Frame (String Date, String Interface, String Id) {
        this.Date = Date;
        this.Interface = Interface;
        this.Id = Id;
    }

    public Frame () {
        this.Date = "";
        this.Interface = "";
        this.Id = "";
    }

    public String getDate() {
        return Date;
    }

    public String getInterface() {
        return Interface;
    }
    
    public String getId() {
        return Id;
    }
}

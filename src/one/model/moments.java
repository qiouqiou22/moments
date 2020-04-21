package one.model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a moment.
 
 * @author kainan
 */
public class moments {

    private final StringProperty creationimagurl;
    private final StringProperty creationname;
    private final StringProperty creationurl;

    /**
     * Constructor.
     */
    public moments() {
        this.creationimagurl = new SimpleStringProperty();
        this.creationname = new SimpleStringProperty();
        this.creationurl=new SimpleStringProperty();
    }

    public void setcreationname(String creationname) {
        this.creationname.set(creationname);
    }

    public StringProperty creationnameProperty() {
        return creationname;
    }
    public String getcreationname() {
        return creationname.get();
    }
    public void setcreationgurl(String creationgurl) {
        this.creationurl.set(creationgurl);
    }

    public StringProperty creationgurlProperty() {
        return creationurl;
    }
    public String getcreationgurl() {
        return creationurl.get();
    }
    public void setcreationimagurl(String creationimagurl) {
        this.creationimagurl.set(creationimagurl);
    }

    public StringProperty creationimagurlProperty() {
        return creationimagurl;
    }
    public String getcreationimagurl() {
        return creationimagurl.get();
    }
    
}

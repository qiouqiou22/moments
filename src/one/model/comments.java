package one.model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * Model class for a comment.
 
 * @author kainan
 */
public class comments {

    private final StringProperty contents;
    private final StringProperty user_id;

    /**
     * Constructor.
     */
    public comments() {
        this.contents = new SimpleStringProperty();
        this.user_id = new SimpleStringProperty();

    }

    public String getcontents() {
        return contents.get();
    }

    public void setcontents(String contents) {
        this.contents.set(contents);
    }

    public StringProperty contentsProperty() {
        return contents;
    }

    public String getuser_id() {
        return user_id.get();
    }

    public void setuser_id(String user_id) {
        this.user_id.set(user_id);
    }

    public StringProperty user_idProperty() {
        return user_id;
    }
    
}

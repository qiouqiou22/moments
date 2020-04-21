package one.model;



import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Friend.
 *
 * @author kainan
 */
public class Friends {

    private final StringProperty friendsname;
    private String imageurl;
    private IntegerProperty friendsid;
  
    public Friends() {
    	this(null);
    	
    }

    /**
     * Constructor.
     * 
     * @param friendsname
     */
    public Friends(String friendsname) {
        
    	this.friendsname = new SimpleStringProperty(friendsname);

    }

    public int getfriendsid() {
        return friendsid.get();
    }

    public void setfriendsid(int friendsid) {
        this.friendsid.set(friendsid);
    }

    public IntegerProperty friendsidProperty() {
        return friendsid;
    }
	public String getFriendsname() {
        return friendsname.get();
    }

    public void setfriendsname(String friendsname) {
        this.friendsname.set(friendsname);
    }

    public StringProperty friendsnameProperty() {
        return friendsname;
    }
    public String getimageurl() {
        return imageurl;
    }

    public void setimageurl(String imageurl) {
        this.imageurl=imageurl;
    }

    public String imageurlProperty() {
        return imageurl;
    }
  
}

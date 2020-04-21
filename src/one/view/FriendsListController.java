package one.view;
import java.io.File;
import org.controlsfx.dialog.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.TextFlow;
//import javafx.scene.image.ImageView;
/*import javafx.scene.control.
import javafx.scene.control.
*/
import one.MainApp;
import one.dao.friendsDao;
import one.dao.momentsDao;
import one.model.Friends;
import one.model.moments;

/**
 * ViewController class for a Friendlist XML.
 *
 * @author kainan
 */
public class FriendsListController {
    @FXML
    private TableColumn<Friends, String> NameColumn;
    @FXML
    private TableView<Friends> friendstable;
//    @FXML
//    private TableColumn<Friends, ImageView> IconColumn;
    // Reference to the main application.
    
	@FXML
    private TextField searchfriendField;
	@FXML
	private Label username;
	@FXML
	private ImageView usericon;
    @FXML
    private Label songname;
    @FXML
    private ToggleButton play;
    @FXML
    private ImageView songimage;
    @FXML
    private TextFlow commentplace;
    @FXML
    private TextField commentinp;
    @FXML
    private MediaPlayer newone;
    private Friends new_friends=new Friends();
    private friendsDao Newfriends;
    private moments new_moment;
    private MainApp mainApp;
    
    /**
     * The constructor.
     */
    public FriendsListController() {
    		
    }
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */

	/**
	 * Called when the user clicks the new button. Opens a dialog 
	 */
   
 
    @FXML
    private void initialize() {
        // Initialize the friendslist table with the one column.
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().friendsnameProperty());
		/*
		 * IconColumn.setCellValueFactory(cellData -> cellData.getValue().getImage1());
		 */
			// Clear person details.
			    showfriendsmoments(null);

			    // Listen for selection changes and show the person details when changed.
			   try { friendstable.getSelectionModel().selectedItemProperty().addListener(
			            (observable, oldValue, newValue) -> showfriendsmoments(newValue));}
			   catch(Exception e) {
				   e.printStackTrace();
				   System.out.println(e);
			   }
    }

    
    
    @FXML
    
    private void searchfriends(ActionEvent event) {
    	
    try {	
            this.Newfriends=new friendsDao();
            new_friends=Newfriends.findfriends1(searchfriendField.getText().trim());
    	    if(new_friends !=null) {
    	         System.out.println(new_friends.getFriendsname()+new_friends.getimageurl());
				 Image Usericon = new Image("file:///"+new File(new_friends.getimageurl()).getAbsolutePath()); 
				 usericon.setImage(Usericon);
				 username.setText(new_friends.getFriendsname());
				
             }
    }
    catch(Exception e){
    	e.printStackTrace();
    	System.out.println("Please type a person!!!");
    }
    }
    
    //this is a problem it should be set a alarm for adding the same person. but because of the database, this function not performed well.
    @FXML
    private void Addfriends(ActionEvent event) {
    	try{
    		Newfriends.addfriends(this.new_friends);
    	}catch(Exception e) {
    		System.out.println("You have added this friends!");
    	}
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        friendstable.setItems(mainApp.getfriendsData());
    }
	
	    private  moments showfriendsmoments(Friends selecfriends) { 
		          
	       
	          try {	
	        			   if(selecfriends!=null) {
	        			   new_moment=new moments();
	                       momentsDao newmoment=new momentsDao();
	                       new_moment=newmoment.findmoments(friendstable.getSelectionModel().getSelectedItem().getFriendsname());
	           	           if(newmoment !=null) {
	                          System.out.println(new_moment.getcreationname()+new_moment.getcreationimagurl()+new_moment.getcreationgurl());
	       				      Image songimagicon = new Image("file:///"+new File(new_moment.getcreationimagurl()).getAbsolutePath()); 
	       				      songimage.setImage(songimagicon);
	       				      songname.setText(new_moment.getcreationname());
	       				      
	       				        }
	                   }
	              }
	           catch(Exception e){
	           	
	           	e.getStackTrace();
	           }
			  return new_moment;
	  
	  }
	    /**
	     * Called when the user clicks on the delete button.
	     */
	    @FXML
	    private void Deletefriends() {
	    	int selectedIndex = friendstable.getSelectionModel().getSelectedIndex();
	        if (selectedIndex >= 0) {
	        	friendstable.getItems().remove(selectedIndex);
	        	String a=friendstable.getSelectionModel().getSelectedItem().getFriendsname();
	        	System.out.println(a);
	            momentsDao delete1=new momentsDao();
	            delete1.deletemoment(a);
	        } else {
	            // Nothing selected.(but this one cant work because of lost libraries)
	            Dialogs.create()
	                .title("No Selection")
	                .masthead("No Person Selected")
	                .message("Please select a person in the table.")
	                .showWarning();
		
		
	            
	        
	       }
	    }
	    //called when a user click play torggle button
	    @FXML
	    private void playsong() {
	    	 try {	
  			   Media a=new Media( "file:///"+new File(new_moment.getcreationgurl()).getAbsolutePath().replace("\\", "/"));
  			   System.out.println("file:///"+new File(new_moment.getcreationgurl()).getAbsolutePath().replace("\\", "/"));
  			   newone=new MediaPlayer(a);
  			   if(play.isSelected()) {
  				 newone.play();
  				   }
     	       else {
     	    	  newone.pause();}
     	       
  			   }
	           catch(Exception e){
	           	e.getStackTrace();
	           	
	           }
			  
	  
	  }
	    
/*	    
//when i want to perform the realize the play music and show image i have met problems on passing url as parameter. 
//this is nightmare when checking problem and find a way out just for inserting. this usually happens on an amateur like me. 
//still in database, the image could be insert as local path url, but i have to use absolute path url for MediaPlayer.
		/*
		 * System.out.println("file:"+new
		 * File(new_moment.getcreationgurl()).getAbsolutePath());
		 */
//		This function cant work because i want to use class path to load media file. However it could only play with absolute url.
		 
	    
	    
	/*
	 * @FXML private void addingcontent(ActionEvent event) { commentinp.getText();
	 * commentplace.getChildren().add(<String,commentinp.getText()>); }
	 */
	 @FXML
	 private void addcomments(ActionEvent event) {
		try { 
			 commentplace.getChildren().add(commentinp);
	 }catch(Exception e) {
		 e.getStackTrace();
		 
	 }
	 }
	    
	    
}
	 


package one;

import java.io.IOException;
/*import java.sql.Connection;
import java.sql.SQLException;*/

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import one.dao.friendsDao;
/*import one.dao.dbUtil;*/
/*import one.dao.friendsDao;*/
import one.model.Friends;
import one.view.FriendsListController;

public class MainApp extends Application {

	private Stage primaryStage;
	private friendsDao data=new friendsDao();
	
	 private ObservableList<Friends> friendsData =FXCollections.observableArrayList();
	 
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("MomentsAndFriends");

		showFriendsList();
	}

	/**
	 * Initializes and Shows the FriendsList
	 */
	public void showFriendsList() {
		try {
			// Load FriendsList from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/FriendsList.fxml"));
			AnchorPane FriendsList = (AnchorPane) loader.load();
			// Show the scene.
			Scene scene = new Scene(FriendsList);
			scene.getStylesheets().add(getClass().getResource("view/style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			// Give the controller access to the main app.
			FriendsListController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	  public MainApp() {
	   
	   data.getfriends();
		
	     /*//this is an a former initialized way.
		 * friendsData.add(new Friends("Hans")); friendsData.add(new Friends("Ruth"));
		 * friendsData.add(new Friends("Heinz")); friendsData.add(new
		 * Friends("Cornelia")); friendsData.add(new Friends("Hey"));
		 */
	  
	  
	  }
	 

	
	  public ObservableList<Friends> getfriendsData() { return friendsDao.friendsData; }
	 
	public static void main(String[] args) {
		launch(args);

	}
}

/*//this is for test databaseto check if the database is conneted or not use it before block 'lanch(args);'
 * Friends a=new Friends(); friendsDao b=new friendsDao();
 * a=b.findfriends1("kainan");
 * System.out.println(a.getFriendsname()+a.getimageurl());
 */
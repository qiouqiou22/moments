package one.dao;
import java.sql.Connection;
//import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.controlsfx.dialog.Dialogs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import one.model.Friends;


 public class friendsDao implements friendsDaoInt {
	public static ObservableList<Friends> friendsData = FXCollections.observableArrayList();
	@Override
	public Friends findfriends1(String name){
		dbUtil dbutil=new dbUtil();
	    Connection conn=null;
	    conn=dbutil.dbConnect();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Friends new_friends=new Friends(); 
			
		String sql="select * from ns_users where user_name=?";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			if(rs.next()){
				new_friends.setfriendsname(rs.getString("user_name"));
				new_friends.setimageurl(rs.getString("user_avatar"));
			}
			System.out.println("find one");
		} catch (SQLException e) {	
			 Dialogs.create()
	            .title("No results")
	            .masthead("Can't find this user! ")
	            .message("Please try again.")
	            .showWarning();
			
		}finally{
			dbutil.dbClose(conn, stmt,rs);
		}
		return new_friends;
	};
	@Override
	public void addfriends(Friends friends){
		dbUtil dbutil=new dbUtil();
	    Connection b=null;
	    b=dbutil.dbConnect();
		PreparedStatement stmt=null;
		 String sql="insert into ns_friends(usernama,image_url) value(?,?)"; 
		try {
			stmt=b.prepareStatement(sql);
			stmt.setString(1, friends.getFriendsname());
            stmt.setString(2, friends.getimageurl()); 
			stmt.executeUpdate();
			System.out.println("add Frinds successfully!");
		} catch (SQLException e) {			
			e.printStackTrace();
			
		}finally{
			dbutil.dbClose(b, stmt,null);
		}		
	}
//this sql function cant delete data in database,because cant use safe way to delete data use varchar type usernama
	@Override
    public void deletefriends(String name){
		dbUtil dbutil=new dbUtil();
	    Connection b=null;
	    b=dbutil.dbConnect();
		PreparedStatement stmt=null;
		String sql="delete * from ns_friends where usernama=?";
		try {
			stmt=b.prepareStatement(sql);
			stmt.setString(1, name);
		    stmt.executeQuery();
			System.out.println("Successfully Deleted.");
	}
		catch(SQLException e) 
		{
		e.printStackTrace();
		}
	}
	
	@Override
	public void getfriends() {
		dbUtil dbutil=new dbUtil();
	    Connection b=null;
	    b=dbutil.dbConnect();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="select usernama from ns_friends";
		try {
			stmt=b.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				String s=rs.getString("usernama");
				friendsData.add(new Friends(s));
			}
	    }catch(SQLException e) {
		e.printStackTrace();
	      }
  }
 }


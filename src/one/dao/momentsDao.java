package one.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import one.model.moments;

public class momentsDao implements momentDaoInt{
    
	/* @Override */
	public moments findmoments(String name){
		dbUtil dbutil=new dbUtil();
	    Connection conn=null;
	    conn=dbutil.dbConnect();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		moments new_moment=new moments(); 
			
		String sql="select * from ns_creating where user_id=?";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			if(rs.next()){
				new_moment.setcreationname(rs.getString("song_name"));
				new_moment.setcreationgurl(rs.getString("creatingsong_url"));
				new_moment.setcreationimagurl(rs.getString("creatingsong_image"));
			}
			System.out.println("find one");
		} catch (SQLException e) {	
			System.out.println("cant find one");
			e.printStackTrace();
		}finally{
			dbutil.dbClose(conn, stmt,rs);
		}
		return new_moment;
	}
	
	public void deletemoment(String name) {
		dbUtil dbutil=new dbUtil();
	    Connection conn=null;
	    conn=dbutil.dbConnect();
		PreparedStatement stmt=null;
		String sql="delete from ns_friends where usernama=?";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.executeQuery();
		
		System.out.println("deleted");
	}
		catch(SQLException e) {
			e.printStackTrace();}
		}
}

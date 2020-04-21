package one.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
 
public class dbUtil {
	private static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String connStr="jdbc:mysql://localhost:3306/ns?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false";
	
	//database connecting method. includes scentences output to check the connection.
	public Connection dbConnect(){		
		Connection conn=null;
		try {
			Class.forName(JDBC_DRIVER);
		}
		catch(ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			
		}
		System.out.println("JDBC Driver has been registered!");
		
		try {
			
			conn=DriverManager.getConnection(connStr,"root","qkn19970610");
			System.out.println("log in");
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return conn;
	}
	
	//database closing method
	public void dbClose(Connection conn,PreparedStatement pstmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}
}



//Another way to set up database 
//however i used the spring xml to create database connection at first 
//but i change to an easy way cause i am not functionally performed well in spring framework.
/*
 * //import java.sql.Connection;
 */
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.sql.rowset.CachedRowSet;
//
//public class dbUtil{
//	private static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
//	private static Connection connection=null;
//	private static final String connStr="jdbc:mysql://localhost/ns";
//
//	public static void dbConnect() /* throws SQLException, ClassNotFoundException */{
//		try {
//			Class.forName(JDBC_DRIVER);
//		}
//		catch(ClassNotFoundException e) {
//			System.out.println("Where is your MySQL JDBC Driver?");
//			e.printStackTrace();
//			/* throw e; */
//		}
//		System.out.println("JDBC Driver has been registered!");
//	
//	try {
//		connection=DriverManager.getConnection(connStr,"root","qkn19970610");
//	}
//	catch(SQLException e){
//		System.out.println("Connection Failed! Check output console"+e);
//			/* throw e; */
//	}
//	
//	
//
//	}
//	public static void dbDisconnect() throws SQLException{
//		try {
//			if(connection !=null && !connection.isClosed()) {
//				connection.close();
//			}
//		}
//		catch(Exception e) {
//			throw e;
//		}
//	}
//}
		
	

//	//this is for insert/delete/update operation
//	public static void dbExcecuteQuery(String sqlStmt)throws SQLException,ClassNotFoundException{
//		Statement stmt=null;
//		try {
//			dbConnect();
//			stmt=connection.createStatement();
//			stmt.executeUpdate(sqlStmt);
//		}
//		catch(SQLException e){
//			System.out.println("Problem occurred at dExecuteQuery operation"+e);
//		}
//		finally {
//			if(stmt!=null) {
//				stmt.close();
//			}
//			dbDisconnect();
//		}
//	}
//	public static ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException,SQLException{
//		Statement stmt=null;
//		ResultSet rs=null;
//		CachedRowSetImpl crs=null;
//		try {
//			dbConnect();
//			stmt=connection.createStatement();
//			crs=new CachedRowSetImpl();
//			crs.popularte(rs);
//		}
//		catch(SQLException e){
//			System.out.println("Error occured in dbException operation"+e);
//			throw e;
//		}
//		finally {
//			if(rs!=null) {
//				rs.close();				
//			}
//			if(stmt!=null) {
//				stmt.close();
//			}
//			dbDisconnect();
//		}
//		return crs;
//	}
//	
//}


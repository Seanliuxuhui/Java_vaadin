package com.example.group_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Stack;

import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;

/**
 * This class specifies the database which is connected to for user login
 * it also specifies the possible interactions with the database
 */
public class DBConnect {
	private UserInformation user;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:6666/SE";
	private  String USER = "root";
	private String PASS = "root";
	private static Connection conn;
	private static Statement stmt;
	private Stack<UserInformation> All_UserInfo = new Stack<UserInformation>();
	/**
	 * The Class constructor, attempts to connect to the database
	 */
	public DBConnect(){
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
		}catch(Exception ex){
			Notification error = new Notification("Error");
			error.setDescription("Cannot connect to the database!" + ex);
			error.setPosition(Position.BOTTOM_CENTER);
			error.show(Page.getCurrent());
		}
	}
	/** an Insert method, used for adding login details to database
	 * @param user
	 * 
	 */
	public void insert(UserInformation user){
		double longitude = 44.637480;
		double latitude = -63.587216;
		Random random = new Random();
		double new_longitude = longitude + 2 * random.nextDouble();
		double new_latitude= latitude + 2 * random.nextDouble();
		String longitude_string = String.valueOf(new_longitude);
		String latitude_string = String.valueOf(new_latitude);
		user.setLongtitude(longitude_string);
		user.setLatitude(latitude_string);
		
		String query = "INSERT INTO user_info VALUES('" + user.getUsername() + "','"+ user.getPassword()+"','"+ user.getLongitude()+"','"+ user.getLatitude()+"','"+""+user.getLatitude()+"')";
		System.out.println(query);
		try{
		stmt.executeUpdate(query);
		Notification success = new Notification("Register Success!");
		success.setDescription("Register as " + user.getUsername());
		success.setPosition(Position.MIDDLE_CENTER);
		success.show(Page.getCurrent());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/**
	 * a Fetch method, used for finding login details already in the databadse
	 * @param username
	 * @param password
	 */
	public boolean fetch(UserInformation user){
		String query = "SELECT * FROM user_info WHERE username = '" +user.getUsername() + "'" ;
		System.out.println(query);
		
		boolean verify = false;
		boolean connect = true;
		try{
			ResultSet rs = stmt.executeQuery(query);
			Notification info = new Notification("Login"); 
			rs.next();
			if(rs.getString("password").toLowerCase().equals(user.getPassword().toLowerCase()) && rs.getString("username").toLowerCase().equals(user.getUsername().toLowerCase())){
				info.setDescription("Successfully Login");
				info.setPosition(Position.BOTTOM_CENTER);
				info.show(Page.getCurrent());
				verify = true;
				return true;
			}else{
				verify = false;
			}
			
			if(!verify && connect){
				info.setDescription("Password Incorrect" + user.getPassword());
				info.setPosition(Position.BOTTOM_CENTER);
				info.show(Page.getCurrent());
			}
			rs.close();
			
		}catch(SQLException se){
			Notification info = new Notification("The user do not exists");
			info.setPosition(Position.MIDDLE_CENTER);
			info.show(Page.getCurrent());
		}
		
		return false;
	
	}
	/**
	 *  A method to return the userinformation object
	 * @return UserInformation object
	 */
	public UserInformation getUserinfo(String username){
		String query = "SELECT * FROM user_info WHERE username = '" +username + "'" ;
		System.out.println(query);
		try{
			ResultSet result = stmt.executeQuery(query);
			result.next();
			user = new UserInformation(result.getString("username"),result.getString("password"),result.getString("longitude"),result.getString("latitude"));
			result.close();
			
		}catch(SQLException se){
			Notification info = new Notification("The user do not exists");
			info.setPosition(Position.MIDDLE_CENTER);
			info.show(Page.getCurrent());
		}
		return user;
	}
	/**
	 * A method which returns a stack of all UserInformation objects
	 * @return Stack of all userInformation objects
	 */
	
	public Stack<UserInformation> getAllUserInfo(){
		String query = "SELECT * FROM user_info";
		int index = 0;
		try{
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				
				UserInformation temp = new UserInformation(rs.getString("username"),rs.getString("password"),rs.getString("longitude"),rs.getString("latitude"));
				All_UserInfo.add(index++, temp);
			}
			
			rs.close();
			
		}catch(SQLException se){
			Notification Empty_error =new Notification("You have no friends! Try to add some,now!");
			Empty_error.setPosition(Position.BOTTOM_CENTER);
			Empty_error.show(Page.getCurrent());
		}
		return All_UserInfo;
	}

}

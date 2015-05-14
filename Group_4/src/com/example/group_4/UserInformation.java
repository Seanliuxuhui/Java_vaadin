package com.example.group_4;
/**
 * This class is just a UserInformation object, it holds a username and password
 */

public class UserInformation {
	private String username;
	private String password;
	private String latitude;
	private String longitude;
	/**
	 * Class constructor, builds an object for the input values
	 * @param username
	 * @param password
	 */
	public UserInformation(String Username, String Password){
		this.username = Username;
		this.password = Password;
	}
	
	
	/** Class constructor, builds an object for the input values
	 * @param username
	 * @param password
	 * @param longitude
	 * @param latitude
	 */
	public UserInformation(String Username, String Password, String Longitude, String Latitude){
		this.username = Username;
		this.password = Password;
		this.longitude = Longitude;
		this.latitude = Latitude;
	}
	
	/**
	 * A simple get method for the username
	 * @return username
	 */
	public String getUsername(){
		return this.username;
		
	}
	/**
	 *A simple get method for the password (in plaintext!)
	 * @return password
	 */
	public String getPassword(){
		return this.password;
	}
	
	/**A simple get method for the longitude
	 * @return longitude
	 * 
	 */
	public String getLongitude(){
		return this.longitude;
	}
	
	
	/** A simple get method for the latitude
	 * @return latitude
	 * 
	 * 
	 * */
	public String getLatitude(){
		return this.latitude;
	}
	
	/**
	 *A simple set method for the longitude 
	 * @param longitude
	 */
	public void setLongtitude(String longitude){
		this.longitude = longitude;
	}
	/**
	 *A simple set method for the latitude 
	 * @param latitude
	 */
	public void setLatitude(String latitude){
		this.latitude = latitude;
	}
	 
	
	
	
}

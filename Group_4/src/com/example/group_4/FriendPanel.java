package com.example.group_4;

import java.util.Stack;

import com.example.group_4.DBConnect;
import com.example.group_4.UserInformation;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * This class specifies the FriendPanel layout
 * It fills the friends list from the database for the specified user
 */
public class FriendPanel extends VerticalLayout{
	
	private Stack <UserInformation> friendList = new Stack<UserInformation>();
	
	/**
	 * The Class Constructor, creates and the populates the friends list panel
	 */
	public FriendPanel(){
		setSizeUndefined();
		System.out.println("panel begin");
		DBConnect db = new DBConnect();
		friendList = db.getAllUserInfo();
		Panel friendPanel = new Panel();
		while(!friendList.isEmpty()){
			UserInformation user = friendList.pop();
			String username = user.getUsername();
			String password = user.getPassword();
			Label temp = new Label(username);
			addComponent(temp);
		}
	}
}

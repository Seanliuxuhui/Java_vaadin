package com.example.group_4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Stack;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vaadin.testbench.TestBenchTestCase;

/**
 * This class contains JUnit tests, which are run using Vaadin TestBench 4.
 *
 * To run this, first get an evaluation license from
 * https://vaadin.com/addon/vaadin-testbench and follow the instructions at
 * https://vaadin.com/directory/help/installing-cval-license to install it.
 *
 * Once the license is installed, you can run this class as a JUnit test.
 */
public class Group_4Test extends TestBenchTestCase {
//    @Rule
//    public ScreenshotOnFailureRule screenshotOnFailureRule =
//            new ScreenshotOnFailureRule(this, true);

    @Before
    public void setUp() throws Exception {
        setDriver(new FirefoxDriver()); // Firefox

        // To use Chrome, first install chromedriver.exe from
        // http://chromedriver.storage.googleapis.com/index.html
        // on your system path (e.g. C:\Windows\System32\)
        //   setDriver(new ChromeDriver()); // Chrome

        // To use Internet Explorer, first install iedriverserver.exe from
        // http://selenium-release.storage.googleapis.com/index.html?path=2.43/
        // on your system path (e.g. C:\Windows\System32\)
        //   setDriver(new InternetExplorerDriver()); // IE

        // To test headlessly (without a browser), first install phantomjs.exe
        // from http://phantomjs.org/download.html on your system path
        // (e.g. C:\Windows\System32\)
        //   setDriver(new PhantomJSDriver()); // PhantomJS headless browser
    }

    /**
     * Opens the URL where the application is deployed.
     */
    private void openTestUrl() {
        getDriver().get("http://localhost:8080/Group_4");
    }
    //test the zoom in function 
    @Test
    public void testZoomIn(){
    	openTestUrl();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.findElement(By.id("zoomin")).click();
    	assertEquals(false,driver.findElement(By.id("zoomin")).isEnabled());

    }
    //test the zoom out function
    @Test
    public void testZoomOut(){
    	openTestUrl();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.findElement(By.id("zoomout")).click();
    	assertEquals(false,driver.findElement(By.id("zoomout")).isEnabled());
    	
    }
    //test if google map is existed or not
    @Test
    public void testGoogleMapExistence(){
    	openTestUrl();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	assertEquals(true, driver.findElement(By.id("googlemap")).isDisplayed());
    }
    //test if signin is functionable
    @Test
    public void testLogin(){
    	openTestUrl();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.findElement(By.id("login")).click();
    	driver.findElement(By.id("signin")).click();
    	assertTrue(driver.findElement(By.id("welcome")).isEnabled());
    	
    }
    
    
  //task:2.1.1.1
  //test the implementation of the welcome label is done 
    @Test
    public void testWelcomeLabel(){
    	openTestUrl();
    	driver.findElement(By.id("login")).click();
    	assertTrue(driver.findElement(By.id("welcome_label")).isEnabled());

    }
    //task 2.1.1.2
    //test the implementation of the username input field is done
    @Test
    public void testInputFieldExistence(){
       openTestUrl();
       driver.findElement(By.id("login")).click();
       assertTrue(driver.findElement(By.id("username")).isDisplayed());
    }

    //Task 2.1.1.3
    //test the implementation of the password input field is done
    @Test
    public void testPasswordFieldExistence(){
    	openTestUrl();
    	driver.findElement(By.id("login")).click();
    	assertTrue(driver.findElement(By.id("password")).isDisplayed());
    }

    //Task 2.1.1.4
    //test the implementation of the sign in button is done
    @Test
    public void testSigninButtonExistence(){
    	openTestUrl();
    	driver.findElement(By.id("login")).click();
    	assertTrue(driver.findElement(By.id("signin")).isDisplayed());
    }
    //Task 2.1.1.5
    //test if the sign in button is clicked and there is no error in the input
    @Test
    public void testW_label_after_sign_in(){
    	openTestUrl();
    	driver.findElement(By.id("login")).click();
    	driver.findElement(By.id("signin")).click();
    	assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
    }
     
    
     //test the implementation of friendlist
    @Test
    public void testFriendsList(){
    	openTestUrl();
    	driver.findElement(By.id("login")).click();
    	driver.findElement(By.id("signin")).click();
    	assertTrue(driver.findElement(By.id("Friends")).isDisplayed());
    }
   //test the implementation of the friend list --> friend
    @Test
    public void testFriend_friendbutton(){
    	openTestUrl();
    	driver.findElement(By.id("login")).click();
    	driver.findElement(By.id("signin")).click();
    	driver.findElement(By.id("Friends")).click();
    	assertTrue(driver.findElement(By.id("friend")).isDisplayed());
    	
    }
    
   //test when friend button is click whether the graffiti will show up
    @Test
    public void testFriendbutton_click(){
    	openTestUrl();
    	driver.findElement(By.id("login")).click();
    	driver.findElement(By.id("signin")).click();
    	driver.findElement(By.id("Friends")).click();
    	assertTrue(driver.findElement(By.id("friend")).isEnabled());
    	//because the pop up window is located on the google map and up to now, we have not found anything 
    	assertTrue(driver.findElement(By.id("googletemp")).isDisplayed());
    }
    

    /**
     * test if google map can locate the position of current user  
     * 
     * */
    @Test
    public void testCurrentUser(){
    	openTestUrl();
    	DBConnect db = new DBConnect();
    	UserInformation user = db.getUserinfo("Sean");
    	driver.findElement(By.id("login")).click();
    	String username = driver.findElement(By.id("username")).getText();
    	driver.findElement(By.id("signin")).click();
    	assertEquals(user.getLongitude(), db.getUserinfo(username).getLongitude());
    	assertEquals(user.getLatitude(), db.getUserinfo(username).getLatitude());
    	
    }
    
    /**
     * test if the number of markers shown in the google map is equal to the number of user in the database
     * 
     */
    @Test
    public void testMarkerNumber(){
    	openTestUrl();
    	DBConnect db = new DBConnect();
    	Stack<UserInformation>  user_list =db.getAllUserInfo();
    	int number_of_user = user_list.size();
    	driver.findElement(By.id("login")).click();
    	driver.findElement(By.id("signin")).click();
    	String markers = driver.findElement(By.id("number_of_friends")).getText();
    	int marker = Integer.valueOf(markers);
    	assertEquals(number_of_user, marker);
    	
    }
    
}
package com.example.group_4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;

public class CanvasViewTest extends TestBenchTestCase {
	 @Before
	    public void setUp() throws Exception {
	        setDriver(new FirefoxDriver());
	 }
	 
	    private void openTestUrl() {
	        getDriver().get("http://localhost:8080/Group_4");
	    }
	    
	    @Test
	    public void attemptToGetToTheCanvasView() {
	    	//this test isn't working at all, but I figured that I would commit it to show process
	    	
	    	openTestUrl();
	    	
	    	/* trying to wrap the map as a button so that I can click it
	    	 * there's almost certainly a better element to wrap it as than a button
	    	 * but the map can't even be found in the first place so it's kind of moot
	    	 */
	    	
	    	ButtonElement button = wrap(ButtonElement.class , driver.findElement(By.id("googlemap")));
	    	

	    	/* ideally, this would click the map twice in the same spot
	    	 * as to create, and then click on a button, launching the canvas view
	    	 */
	    	button.doubleClick();
	 
	    	
	    	//easiest element to check for on the canvas view is the button
	    	assertFalse(driver.findElement(By.id("return")).isDisplayed());
	    }
	 
}

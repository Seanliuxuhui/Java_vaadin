package com.example.group_4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * ScreenshotEvent contains methods to take a screenshot with specific file
 * outputs.
 * <p>
 * May use any string and/or date to sort the screenshots. Choosing not to enter
 * a string or date will automatically sort the screenshots by test name.
 * 
 * @author Taylor Stone
 * @version $Revision: 1.1 $
 */
public class ScreenshotEvent {

	public static Log log = LogFactory.getLog(ScreenshotEvent.class);

	/**
	 * Method takeScreenshot.
	 * 
	 * @param driver WebDriver
	 * @param testName String
	 * @param date String
	 * @throws IOException
	 */
	public static void takeScreenshot(WebDriver driver, String testName, String date) throws IOException, ClassCastException {
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = String.format("%s_%s", caps.getBrowserName(), caps.getVersion());
		File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(tempFile, new File(String.format("screenshots/%s/%s/%s.png", testName, browserName, date)));
		log.info("Screenshot of failure was taken.");
	}

}

package com.example.group_4;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.example.group_4.TestBase;

/**
 * @author Taylor Stone
 * @version $Revision: 1.3 $
 */
public class TestBase {
	/**
	 * Field testName.
	 */
	public static String testName = "No Test Name Specified";
	/**
	 * Field className.
	 */
	public static String className = "No Class Name Specified";
	/**
	 * Log log.
	 */
	public static Log log = LogFactory.getLog(TestBase.class);

	/**
	 * Starts the WebDriver based on DriverType.
	 * 
	 * @param driverType DriverType
	 * @param url String
	 * @param timeOut int
	 * @return WebDriver
	 */
	public static WebDriver startDriver(DriverType driverType, String url, int timeOut) {
		WebDriver driver;

		switch (driverType) {
		case INTERNETEXPLORER:
			driver = new InternetExplorerDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
			break;
		case CHROME:
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
			break;
		case SAFARI:
			driver = new SafariDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
			break;
		case PHANTOM:
			driver = new PhantomJSDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
			break;
		default:
			throw new InvalidParameterException(String.format("Invalid DriverType: %s\n", driverType.toString()));
		}
		return driver;
	}

	/**
	 * Starts the WebDriver based on DriverType.
	 * 
	 * @param driverType DriverType
	 * @param url String
	 * @param timeOut int
	 * @param capabilities DesiredCapabilities
	 * @return WebDriver
	 */
	public static WebDriver startDriver(DriverType driverType, String url, int timeOut, DesiredCapabilities capabilities) {
		WebDriver driver;

		switch (driverType) {
		case INTERNETEXPLORER:
			driver = new InternetExplorerDriver(capabilities);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
			break;
		case FIREFOX:
			driver = new FirefoxDriver(capabilities);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
			break;
		case CHROME:
			driver = new ChromeDriver(capabilities);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
			break;
		case SAFARI:
			driver = new SafariDriver(capabilities);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
			break;
		case PHANTOM:
			driver = new PhantomJSDriver(capabilities);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
			break;
		default:
			throw new InvalidParameterException(String.format("Invalid DriverType: %s\n", driverType.toString()));
		}
		return driver;
	}

	/**
	 * Starts the Remote WebDriver based on DriverType and RemoteAddress URL.
	 * Defaults RemoteAddress to localhost:4444/wd/hub if URL is incorrect.
	 * 
	 * @param remoteAddress URL
	 * @param url String
	 * @param timeOut int
	 * @param capabilities DesiredCapabilities
	 * @return WebDriver
	 */
	public static WebDriver startRemoteDriver(URL remoteAddress, String url, int timeOut, DesiredCapabilities capabilities) {
		WebDriver driver;

		driver = new RemoteWebDriver(remoteAddress, capabilities);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * Method logJUnitStart.
	 */
	public static void logJUnitStart() {
		log.info(String.format("Starting test: %s %s\n", className, testName));
	}

	/**
	 * Method logTestPassed.
	 */
	public static void logTestPassed() {
		log.info("Test Passed.\n");
	}

	/**
	 * Method logTestFailed.
	 */
	public static void logTestFailed() {
		log.warn("Test failed.\n");
	}

	/**
	 * Method logScreenshotFailed.
	 * 
	 * @param sf
	 *            Exception
	 */
	public static void logScreenshotFailed(Exception sf) {
		log.error("Screenshot couldn't write.\n", sf);
	}

	/**
	 * Method logHardFailure.
	 */
	public static void logHardFailure() {
		log.error("Test didn't finish due to hard failure.\n");
	}

	/**
	 * Method logGracefulFailure.
	 */
	public static void logGracefulFailure() {
		log.warn("Test failed gracefully.\n");
	}

}

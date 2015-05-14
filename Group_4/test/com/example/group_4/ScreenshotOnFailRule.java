package com.example.group_4;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;




/**
 * ScreenshotOnFailRule overrides JUnit failed method.
 * <p>
 * Takes a screenshot on failure. If the screenshot cannot be taken for any
 * reason it will log a SEVERE message and halt all tests in a test suite.
 * <p>
 * Does not automatically close the WebDriver. However, this screenshot is taken
 * with the TestBase driver. If you are using your own driver, you will need to
 * make your own screenshot on fail Rule.
 * 
 * @author Taylor Stone
 * @version $Revision: 1.3 $
 */
public class ScreenshotOnFailRule extends TestWatcher {

	private WebDriver driver;

	public ScreenshotOnFailRule(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Field shouldStopTests.
	 */
	private static boolean shouldStopTests = false;
	/**
	 * Field FILENAME_DATE_PATTERN. (value is ""yyyy-MM-dd_HH_mm_ss_SS"")
	 */
	private static final String FILENAME_DATE_PATTERN = "yyyy-MM-dd_HH_mm_ss_SS";
	/**
	 * Field today.
	 */
	private final Date today = Calendar.getInstance().getTime();
	/**
	 * Field ymdhmss.
	 */
	private final DateFormat ymdhmss = new SimpleDateFormat(FILENAME_DATE_PATTERN);
	/**
	 * Field date.
	 */
	private String date = ymdhmss.format(today);

	/**
	 * Method starting.
	 * 
	 * @param desc Description
	 */
	@Override
	public void starting(Description desc) {
		TestBase.log.info("Screenshot On Failure Enabled.");
	}

	/**
	 * Method failed.
	 * 
	 * @param e Throwable
	 * @param d Description
	 */
	@Override
	public void failed(Throwable e, Description d) {
		TestBase.testName = d.getMethodName();
		try {
			ScreenshotEvent.takeScreenshot(driver, TestBase.testName, date);
		} catch (IOException ioe) {
			TestBase.logScreenshotFailed(ioe);
			shouldStopTests = true;
		} catch (ClassCastException cce) {
			TestBase.logScreenshotFailed(cce);
		}
		if (shouldStopTests) {
			TestBase.logHardFailure();
			System.exit(0);
		}
	}

}

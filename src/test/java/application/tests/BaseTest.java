package application.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import application.pages.BasePage;

public class BaseTest extends BasePage {

	public BaseTest() {
		super();
	}
	@BeforeMethod
	public void launchBrowser() {
		initialization();
	}
	
	/*
	 * @AfterMethod public void tearDown() { closeBrowser(); }
	 */
	
	@AfterMethod
	public void tearDownBrowser() {
		quitBrowser();
	}
	
}

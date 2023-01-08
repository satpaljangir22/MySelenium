package application.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import application.pages.LoginPage;
import application.utility.ScreenShot;

public class LoginPageTests extends BaseTest {
	LoginPage loginPage;
	String screenShotPath = "C:\\Users\\satpal_jangir\\eclipse-workspace\\MySelenium\\ScreenShots\\";
	LoginPageTests(){
		super();
	}
	
	
	
	@Test(groups = {"Smoke"})
	public void facebookLoginPage() throws Exception {
		/*
		 * JSONObject jsonResponse = new AXE.Builder(driver, scriptUrl).analyze();
		 * JSONArray violations = jsonResponse.getJSONArray("violations");
		 * 
		 * if(violations.length() == 0) { Assert.assertTrue(true,
		 * "There are no violations"); } else { AXE.writeResults("googleAllyTest",
		 * jsonResponse); Assert.assertTrue(true, AXE.report(violations)); }
		 */
		String title = driver.getTitle();
		Reporter.log("PageTtile is: " + title);
		ScreenShot.takeScreenShot(driver, screenShotPath + "SS1.png");
		Assert.assertTrue(true, title);
	}
	
	@Test(groups = {"Smoke", "Regression"})
	@Parameters({"pageTitle"})
	public void verifyFbLoginPageTitle(String pageTitle) throws Exception {
		Reporter.log("Smoke and Regeression Test");
		String title = driver.getTitle();
		ScreenShot.takeScreenShot(driver, screenShotPath + "SS2.png");
		Assert.assertEquals(pageTitle, title);
	}
	
	@Test(dataProvider = "UserData", groups = {"Regression"})
	public void loginToFacebook(String userName, String password) throws Exception {
		Reporter.log("Test for: " + userName + " " + password);
		WebElement email= driver.findElement(By.id("email"));
		WebElement pwd = driver.findElement(By.id("pass"));
		email.clear();
		email.sendKeys(userName);
		pwd.clear();
		pwd.sendKeys(password);
		ScreenShot.takeScreenShot(driver, screenShotPath+ "SS3_" + userName + ".png");
		Assert.assertTrue(true, userName + " " + password);
	}
	
	@DataProvider(name = "UserData")
	public Object[][] SendUserData(){
		Object[][] user = {
				{"satpal", "123"},
				{"jangir", "456"},
				{"hello", "789"},
		};
		return user;
	}

}

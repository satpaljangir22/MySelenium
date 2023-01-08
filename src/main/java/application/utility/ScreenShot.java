package application.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class ScreenShot {
	
	public static void takeScreenShot(WebDriver driver, String filePath) throws Exception {
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File outFile = new File(filePath);
		FileUtils.copyFile(srcfile, outFile);
		Reporter.log("Taking Screenshot");
	}
}

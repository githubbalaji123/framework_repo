package practice.testng;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenshotinTestNg<EventFiringWebDriver> {
	@Test
	public void amazonTest() throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://amazon.com");
		TakesScreenshot ts=(TakesScreenshot)driver;
		//EventFiringWebDriver efd= new EventFiringWebDriver(driver); this is depreciated
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShot/image1.png");
		org.openqa.selenium.io.FileHandler.copy(src, dest);
		
		
		/*
		 * EventFiringWebDriver efd= new EventFiringWebDriver(driver);
		 * File scrFile=efd.getScreenShotAs(OutputType.FILE);
		 * FileUtils.copyFile(scr, new File("./screenshot/test.png"));
		 * */
	}
}

package practice.testng;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion1stvideo {

	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName() + "  ===>Test Start");
		String expTxt = "Login";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String hpTxt = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		//Hard Assert [instead of using If else(){} as per rule of automation we use assert]
		Assert.assertEquals(expTxt, hpTxt);
		driver.close();
		System.out.println(mtd.getName() + "  ===>Test End");
	}
      @Test
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName() + " ===>Test Start");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	    boolean flag=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
	   //Hard Assert [instead of using If else(){} as per rule of automation we use assert]
	    Assert.assertTrue(flag);
	    driver.close();
	    System.out.println(mtd.getName() + "  ===>Test End");
	}

}

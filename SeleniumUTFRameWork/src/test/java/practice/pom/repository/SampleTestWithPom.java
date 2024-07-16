package practice.pom.repository;

import java.time.Duration;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithPom {
	
	@FindBy(name="user_name")
	WebElement ele1;
	
	@FindBy(name="user_password")
	WebElement ele2;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input(@value='Login')")})
	private WebElement ele3;
	
	@Test
	public void sampleTest() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
	     
		SampleTestWithPom s=PageFactory.initElements(driver,SampleTestWithPom.class);
		
	    s.ele1.sendKeys("admin");
	    s.ele2.sendKeys("admin");
	   
	    driver.navigate().refresh();
	   
	    s.ele1.sendKeys("admin");
	    s.ele2.sendKeys("admin");
	    s.ele3.click();
	    driver.quit();
	    
	}
}

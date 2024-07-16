package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExelUtility;

public class DataProviderAmazonProgram {
	
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String bname, String pname) {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=155259815513&hvpone=&hvptwo=&hvadid=674842289437&hvpos=&hvnetw=g&hvrand=3430032217386253528&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9061968&hvtargid=kwd-10573980&hydadcr=14453_2316415&gad_source=1");
	
	//search the product
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(bname,Keys.ENTER);
	//capture the product info
	String x="(//span[text()='"+pname+"'][1]/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span/span/span[2])[1]";
	String price=driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
  }
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		ExelUtility elib= new ExelUtility();
		int rowcount=elib.getRowcount("mobo");
		Object [][] ob=new Object[rowcount][2];
		for (int i = 0; i < rowcount; i++) {
			ob[i][0]=elib.getDataFromExcel("mobo",i+1, 0);//brand name
			ob[i][1]=elib.getDataFromExcel("mobo",i+1, 1);//model name
		}
		
		return ob;
	}
}

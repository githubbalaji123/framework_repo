package practice.pom.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest {

	public static void main(String[] args) throws Throwable {
		 FileInputStream fis= new FileInputStream("./src/main/resources/cmnData.properties");
		 Properties pObj= new Properties();
		 pObj.load(fis);
		  String URL = pObj.getProperty("url");
		  String USERNAME = pObj.getProperty("username");
		  String PASSWORD = pObj.getProperty("password");
		  
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get(URL);
		 
		  WebDriverUtility wlib=new WebDriverUtility();
		  wlib.waitForPageToLoad(driver);
		 
		  ExelUtility elib= new ExelUtility();
		  javaUtility jlib=new javaUtility();
		  String lastName=elib.getDataFromExcel("Org", 7, 2) + jlib.getRandomNumber();
//log in to the app
		  
		  LoginPage lp=new LoginPage(driver);
	  
	  //{
		  /*lp.getUsernameEdt().sendKeys(USERNAME);
		  lp.getPasswordEdt().sendKeys(PASSWORD);
		  lp.getLoginBtn().click();*/
	    //}
		     
		  lp.LoginToapp(USERNAME, PASSWORD);
//navigate to the org page
           HomePage op=new HomePage(driver);
           op.getOrgLink().click();
             // we are using business libraries for multiple actions
//create new organization
         OrganizationsPage cop=new OrganizationsPage(driver);
         cop.getCreateNewOrgBtn().click();
            
/*add new organization and click on save button(Two actions here means,multiple actions so that we can use business method)*/
            CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
            cnop.createOrg(lastName);
//verifying the creations of organization of header orgnameinfo
            OrganizationInfoPage oip=new OrganizationInfoPage(driver);
            String actOrgName=oip.getHeaderMsg().getText();
            if (actOrgName.contains(lastName)) {
				System.out.println(lastName+ ": is verified and the testCase is====>> PASS"
						+ "\n And Here i write the code to delete the Current Org which is Created.....");
			}else {
				System.out.println("Organization is not created and the testCase isXXX--Failed--XXX");
			}
         
//go backto org page and search for org and in dynamic webtable select and delete org
            op.getOrgLink().click();
            cop.getSearchEdt().sendKeys(lastName);
            wlib.select(cop.getSearchDDwn(), "Organization Name");
            cop.getSearchNow().click();
  /*-----------------------------------------------------------------------------------------*/
            //dynamic data deletion will starts here 
        driver.findElement(By.xpath("//a[text()='"+lastName+"']/../../td[8]/a[text()='del']")).click();
            wlib.switchToAlertAndAccept(driver);
            
            
//Log_Out
           op.logout();
            driver.quit();

	}

}

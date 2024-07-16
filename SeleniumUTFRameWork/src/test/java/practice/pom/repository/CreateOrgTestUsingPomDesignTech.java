package practice.pom.repository;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
public class CreateOrgTestUsingPomDesignTech {

	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
			  String URL =flib.getDataFromPropertiesFile("url");;
			  String USERNAME =flib.getDataFromPropertiesFile("username");
			  String PASSWORD = flib.getDataFromPropertiesFile("password");
			  
			  WebDriver driver=new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.get(URL);
			 
			  WebDriverUtility wlib=new WebDriverUtility();
			  wlib.waitForPageToLoad(driver);
			  LoginPage lp=new LoginPage(driver);
			  lp.LoginToapp(USERNAME, PASSWORD);

//navigate to the org page
               HomePage op=new HomePage(driver);
               op.getOrgLink().click();
//create new organization
             OrganizationsPage cop=new OrganizationsPage(driver);
             cop.getCreateNewOrgBtn().click();
                
/*add new organization and click on save button(Two actions here means,multiple actions so that we can use business method)*/
                 ExelUtility elib= new ExelUtility();
			     javaUtility jlib=new javaUtility();
			     String lastName=elib.getDataFromExcel("Org", 7, 2) + jlib.getRandomNumber();  
                 CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
                 cnop.createOrg(lastName);
//verifying the creations of organization of header orgnameinfo
                OrganizationInfoPage oip=new OrganizationInfoPage(driver);
                String actOrgName=oip.getHeaderMsg().getText();
                if (actOrgName.contains(lastName)) {
					System.out.println(lastName+ ": is verified and the testCase is====>> PASS");
				}else {
					System.out.println("Organization is not created and the testCase isXXX--Failed--XXX");
				}
//Log_Out
                op.logout();
                driver.quit();
	}
}

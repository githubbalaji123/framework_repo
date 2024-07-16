package practice.testng;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.PopupInContactPageByPlusBtn;

import junit.framework.Assert;

public class thaOnnumeyilla extends BaseClass{

	@Test
	public void createContact() throws Throwable{
		ExelUtility e=new ExelUtility();
		String lastNamee=e.getDataFromExcel("org", 1, 2);
		
		HomePage h=new HomePage(driver);
		h.getContactLink().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.getContactCreateBtn().click();
		
		CreateNewContactPage cpp=new CreateNewContactPage(driver);
		
		cpp.getLastNameTxtField().sendKeys(lastNamee);
		cpp.getSaveBtn().click();
		
	}
	@Test
	public void createContactWithDates() throws Throwable {
		HomePage h=new HomePage(driver);
		h.getContactLink().click();
		
		String lastNamee=elib.getDataFromExcel("org", 1, 2);
		ContactPage cp=new ContactPage(driver);
		cp.getContactCreateBtn().click();
		
		CreateNewContactPage cpp=new CreateNewContactPage(driver);
		cpp.getLastNameTxtField().sendKeys(lastNamee);
		cpp.getSupportStartDate().clear();
		cpp.getSupportStartDate().sendKeys(jlib.getSystemDateYYYYDDMM());
		cpp.getSupportEndtDate().clear();
		cpp.getSupportEndtDate().sendKeys(jlib.getRequiredDateYYYYDDMM(30));
		cpp.getSaveBtn().click();
	}
	
	@Test
	public void createContactWithOrgandVerify() throws Throwable {
		HomePage h=new HomePage(driver);
		h.navigateToOrgModule();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		String lastName=elib.getDataFromExcel("org", 1, 2)+jlib.getRandomNumber();
		cnop.createOrg(lastName);
		String orgName=elib.getDataFromExcel("org",1,3)+jlib.getRandomNumber();
		Thread.sleep(3000);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		oip.getContactLintBtn().click();
		Thread.sleep(3000);
		
		ContactPage cp=new ContactPage(driver);
		cp.getContactCreateBtn().click();
		
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.getLastNameTxtField().sendKeys(lastName);
		ccp.getSelectBtnIcon().click();
		
		wlib.switchToTabOnURL(driver, "http://localhost:8888/index.php?module=Accounts");
		PopupInContactPageByPlusBtn pop=new PopupInContactPageByPlusBtn(driver);
		pop.getPlusBtnSearchTxtField().sendKeys(lastName);
		pop.getPlusSaveBtn().click();
		
		driver.findElement(By.xpath("//a[text()='"+lastName+"']")).click();
		wlib.switchToTabOnURL(driver,"http://localhost:8888/index.php?module=Contacts");
		
		
		ccp.getSaveBtn().click();
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		org.testng.Assert.assertEquals(cip.getOrgNAmeTxtField().getText(), " "+lastName, "OrgNameIsWrong");
		
	}
}

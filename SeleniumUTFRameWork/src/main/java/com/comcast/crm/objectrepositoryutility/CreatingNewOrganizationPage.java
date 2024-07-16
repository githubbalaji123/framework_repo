package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {                 //rule no 3 is done here
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[contains(@title,'Save [Alt+S]')][1]")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	WebElement indusDropDwn;
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrg(String lastName) {
	/*we are taking this orgname in createContactTest u can see that in src/test/java*/
		orgNameEdt.sendKeys(lastName);
		Select sel=new Select(indusDropDwn);
		sel.selectByValue("Technology");
		saveBtn.click();
	}
}

package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
		WebDriver driver;
		public OrganizationInfoPage(WebDriver driver) {                 
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
	
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	@FindAll({@FindBy(xpath="(//a[text()='Contacts'])[1]"),
        @FindBy(xpath="(//td[@class='tabUnSelected'])[4]")})
	private WebElement contactLinkBtn;
	
	
	public WebElement getContactLintBtn() {
		return contactLinkBtn;
	}


	public WebElement getHeaderMsg() {
		return headerMsg;
	}
}

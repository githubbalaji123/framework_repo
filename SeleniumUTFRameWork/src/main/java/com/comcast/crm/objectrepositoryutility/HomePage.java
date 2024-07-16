package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	 WebDriver driver;
		public HomePage(WebDriver driver) {                 //rule no 3 is done here
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
	
	@FindBy(linkText ="Organizations")
      private WebElement orgLink;

    @FindBy(linkText ="Contacts")
      private WebElement contactLink;
    
    @FindBy(linkText="Campaigns")
    private WebElement campaignlnk; 
    
    @FindBy(linkText="More")
    private WebElement morelnk; 
      
    @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
    private WebElement adminImg;
    
    @FindBy(partialLinkText ="Sign Out")
    private WebElement sigNOutLink;
      
      public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSigNOutLink() {
		return sigNOutLink;
	}

	public WebElement getOrgLink() {
			return orgLink;
		}

		public WebElement getContactLink() {
			return contactLink;
		}
		
		public WebElement getCampaignlnk() {
			return campaignlnk;
		}

		public WebElement getMorelnk() {
			return morelnk;
		}
		
		/*Business libraries*/
		public void navigateToCampaignPage() {
			Actions act=new Actions(driver);
			act.moveToElement(morelnk).perform();
			campaignlnk.click();
		}

		public void logout() {
			Actions act=new Actions(driver);
			act.moveToElement(adminImg).perform();
			sigNOutLink.click();
		}
		
		public void navigateToOrgModule() {
			HomePage h=new HomePage(driver);
			h.getOrgLink().click();
		}
}


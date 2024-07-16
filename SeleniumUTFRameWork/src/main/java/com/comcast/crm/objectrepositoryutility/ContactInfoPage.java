package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
  WebDriver driver;
	
    public ContactInfoPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLastNAmeTxtField() {
		return lastNAmeTxtField;
	}

	public WebElement getOrgNAmeTxtField() {
		return OrgNAmeTxtField;
	}

	public WebElement getSsDate() {
		return ssDate;
	}

	public WebElement getSeDate() {
		return seDate;
	}

	@FindBy(xpath="(//td[@class='dvtCellInfo'])[3]")
	private WebElement lastNAmeTxtField;
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']")
	private WebElement OrgNAmeTxtField;
	
	@FindBy(xpath="//td[@id='mouseArea_Support Start Date']")
	private WebElement ssDate;
	
	@FindBy(xpath="//td[@id='mouseArea_Support End Date']")
	private WebElement seDate;
	
	
}

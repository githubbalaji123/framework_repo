package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {                 //rule no 3 is done here
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[contains(@alt,'Create Organization...')]")
	private WebElement createNewOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;

	@FindBy(name="submit")
	private WebElement searchNow;
	
	public WebElement getSearchNow() {
		return searchNow;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDDwn() {
		return searchDDwn;
	}

	@FindBy(name="search_field")
	private WebElement searchDDwn;

	/*Here we don't need business method because we have only one action like click on the +org button*/	
	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
 
	
}

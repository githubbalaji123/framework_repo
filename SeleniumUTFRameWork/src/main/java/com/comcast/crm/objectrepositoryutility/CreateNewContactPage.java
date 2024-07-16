package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//input[@class='detailedViewTextBox'])[3]")
	private WebElement lastNameTxtField;
	
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement selectBtnIcon;
	
	@FindBy(xpath="//input[@id='jscal_field_support_start_date']")
	private WebElement supportStartDate;	
	
	@FindBy(xpath="//input[@name='support_end_date']")
	private WebElement supportEndtDate;	
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;

	public WebElement getLastNameTxtField() {
		return lastNameTxtField;
	}

	public WebElement getSelectBtnIcon() {
		return selectBtnIcon;
	}

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndtDate() {
		return supportEndtDate;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}	
	
}

package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopupInContactPageByPlusBtn {

	WebDriver driver;
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPlusBtnSearchTxtField() {
		return PlusBtnSearchTxtField;
	}

	public WebElement getPlusBtnDropDown() {
		return PlusBtnDropDown;
	}

	public WebElement getPlusSaveBtn() {
		return PlusSaveBtn;
	}

 public	PopupInContactPageByPlusBtn(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement PlusBtnSearchTxtField;
	
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement PlusBtnDropDown;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement PlusSaveBtn;
	
	
}

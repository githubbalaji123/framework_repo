package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage {
    /* rule no 1 create separate class for each and every page (Successfully created)*/
      WebDriver driver;
      
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	/*rule no 2 is Identify all the elements using annotations (Object Creation)*/
	  @FindBy(name="user_name")
	private  WebElement usernameEdt;
	  
	  @FindBy(name="user_password")
	private  WebElement passwordEdt;

	  @FindBy(id="submitButton")
	private  WebElement loginBtn;
	  
	  /* rule no 3 Object Initialization it should be done in the test script not in the Pom classes*/
	 
	  /* rule no 4 provide getters() mtd (Object Encapsulation)*/
	  
	  public WebElement getUsernameEdt() {
			return usernameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
	/* rule no 5 we can do another way also business class we can provide Action*/
		                  /*Business libraries*/ //this is required in multiple actions here there are 3 actions
		/*This method we cannot use for every applications only for special kind of application*/
		public void LoginToapp(String username , String password) {
			usernameEdt.sendKeys(username);
			passwordEdt.sendKeys(password);
			loginBtn.click();
		}
}

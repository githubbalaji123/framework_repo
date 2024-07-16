package com.comcast.crm.contactTest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		/*create an Object*/
	FileUtility flib =new FileUtility();
	ExelUtility elib= new ExelUtility();
	javaUtility jlib=new javaUtility();
	//read common data from json file
	String BROWSER =flib.getDataFromPropertiesFile("browser");
	String URL =flib.getDataFromPropertiesFile("url");
	String USERNAME =flib.getDataFromPropertiesFile("username");
	String PASSWORD =flib.getDataFromPropertiesFile("password");
	 
	  /*jlib.getRandomNumber();*/
	
	String lastName=elib.getDataFromExcel("Org", 7, 3) + jlib.getRandomNumber();
	
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();
	driver.get(URL);
	
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	
	driver.findElement(By.xpath("(//input[contains(@class,'detailedViewTextBox')])[3]")).sendKeys(lastName);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	String actLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
	if (actLastName.equals(lastName)) {
		System.out.println(lastName + " :information is verified==PASS");
	}else {
		System.out.println(lastName + " :information is Not==FAIL");
	}
	
	driver.close();
	
	}

}
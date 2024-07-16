package com.comcast.crm.basetest;

import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	public DataBaseUtility dblib = new DataBaseUtility();
	public FileUtility flib = new FileUtility();
	public ExelUtility elib = new ExelUtility();
	public javaUtility jlib = new javaUtility();
    public WebDriverUtility wlib=new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("===Connect to Db , Report config=====");
		//dblib.getDbconnection();
	}

	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("===Launch a Browser===");
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("===Login to application===");
		String URL = flib.getDataFromPropertiesFile("url");
		driver.get(URL);
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		LoginPage lglib = new LoginPage(driver);
		lglib.LoginToapp(USERNAME,PASSWORD);

	}

	@AfterMethod
	public void configAM() {
		System.out.println("===Logout the application===");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass
	public void ConfigAc() {
		System.out.println("===Close a Browser===");
		driver.quit();
	}

	@AfterSuite
	public void configAS() throws Throwable {
		System.out.println("===Close to Db, Report backup=====");
		//dblib.closeDbconnection();
	}
}

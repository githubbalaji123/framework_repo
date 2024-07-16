package com.comcast.crm.contactTest;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactTestWithAnnotation extends BaseClass{

	@Test
	public void createContactTest() throws Throwable
	{
		System.out.println("create contact test executed");
		
	}
	@Test
	public void createContactWithDates() {
		System.out.println("createContactWithDate & verify");
	}
	
}

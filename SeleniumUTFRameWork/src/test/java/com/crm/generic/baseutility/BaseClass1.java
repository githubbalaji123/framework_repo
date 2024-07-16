package com.crm.generic.baseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass1 {

	@BeforeSuite
	public void configBS() {
		System.out.println("===Connect to Db , Report config=====");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("===Close to Db, Report backup=====");
	}
	
	@BeforeClass
	public void configBC() {
		System.out.println("===Launch a Browser===");
	}
	
	@AfterClass
	public void ConfigAc(){
		System.out.println("===Close a Browser===");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("===Login to application===");
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("===Logout the application===");
	}
}

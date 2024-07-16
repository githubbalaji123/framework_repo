package practice.testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class configAnnotaTionn {

	@BeforeSuite
	public void bs() {
		System.out.println("BSuite");
	}
	@BeforeClass
	public void bc() {
		System.out.println("bclass");
	}
	@BeforeMethod
	public void configBm() {
		System.out.println("Bm");
	}
	@Test
	public void creaContact()
	{
		System.out.println("cc");
	}
	@Test
	public void createContactwithDate() {
		System.out.println("ccd");
	}
	@AfterMethod
	public void am()
	{
		System.out.println("am");
	}
	@AfterClass
	public void ac(){
		System.out.println("aclass");
	}
	@AfterSuite
	public void as() {
		System.out.println("AfterSuite");
	}
}

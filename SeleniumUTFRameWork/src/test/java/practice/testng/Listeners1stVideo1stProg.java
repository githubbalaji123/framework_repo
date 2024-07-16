package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class Listeners1stVideo1stProg extends BaseClass{

	@Test
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		String tit=driver.getTitle();
		Assert.assertEquals(tit, "login");
		
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		System.out.println("step 4");
		
	}
	
	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("execute createInvoiceWithContactTest");
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		System.out.println("step 4");
	}
}

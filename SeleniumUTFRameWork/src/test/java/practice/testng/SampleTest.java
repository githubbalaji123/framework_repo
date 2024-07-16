package practice.testng;

import org.apache.poi.util.SystemOutLogger;
import org.testng.annotations.Test;

public class SampleTest {

	@Test(priority = 3)
	public void contactTest() {
		System.out.println("execute test");
		System.out.println("******************");
		System.out.println("x-x-x-x-x-x-x-x-x-x-");
	}
	
	@Test(priority=2)
	public void createcontactwithMobileNumberTest() {
		System.out.println("execute test 2");
		System.out.println("-----------------------");
	}
		@Test(priority=1)
		public void Ztest() {
			System.out.println("execute test z");
			System.out.println("***********************");
	}
		
	@Test
	public void createOrderTest() {
		System.out.println("Execute create order test===>123");
	}
	
	@Test(dependsOnMethods = "createOrderTest")
	public void billingAnOrderTest() {
		System.out.println("Execute billing order test===;123");
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
	}
		
}

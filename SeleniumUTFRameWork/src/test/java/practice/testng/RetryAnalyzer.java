package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class RetryAnalyzer extends BaseClass {

	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void rA() {
		System.out.println("execute createInvoiceTest");
		String tit = driver.getTitle();
		Assert.assertEquals(tit, "login");

		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		System.out.println("step 4");

	}
}

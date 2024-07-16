package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Softassert {
 @Test
 public void fsttestCase() {
	 System.out.println("1St test case start");
	 System.out.println("Step 1");
	 System.out.println("Step 2");
	 System.out.println("Step 3");
	 SoftAssert assobj=new SoftAssert();
	 assobj.assertEquals("home", "logo");
	 assobj.assertAll();
	 System.out.println("Step 4");
	 System.out.println("1St test case start");
 }
 
 @Test
 public void sndtestCase() {
	 System.out.println("2nd test case start");
	 System.out.println("Step 1");
	 System.out.println("Step 2");
	 System.out.println("Step 3");
	 SoftAssert assobj=new SoftAssert();
	 assobj.assertTrue(true);
	 assobj.assertAll();
	 System.out.println("Step 4");
	 System.out.println("2nd test case start");
 }
}

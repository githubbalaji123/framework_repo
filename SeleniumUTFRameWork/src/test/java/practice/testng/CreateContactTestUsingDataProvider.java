package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTestUsingDataProvider {

	@Test(dataProvider = "getData")
	public void createContactTest(String fname, String sname) {
		System.out.println("1st name :"+fname+"\t2nd name :"+sname);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object [][] ob=new Object[2][2];
		ob[0][0]="BALAJI";
		ob[0][1]="CEO";
		
		ob[1][0]="BALAJI";
		ob[1][1]="GOOGLE";
		
		return ob;
	}
}

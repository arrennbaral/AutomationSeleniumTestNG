package utilities;

import org.testng.Assert;
public class AssertionUtil {
	
	public static void assertEquals(String actual, String expected, String msg) {
		// TODO Auto-generated method stub
		try{
		Assert.assertEquals(actual, expected, msg);
		System.out.println("[PASS]" + msg + " | Expected: " + expected + ", Actual: "+ actual);
		
		}catch(AssertionError e) {
			System.out.println("[FAIL]" + msg + " | Expected: " + expected + ", Actual: "+ actual);
			//e.printStackTrace();
			
		}

	}
	
	public void assertTrue() {
		// TODO Auto-generated method stub

	}
	
	public void assertFalse() {
		// TODO Auto-generated method stub

	}
	
	public void fail() {
		// TODO Auto-generated method stub

	}
	

}

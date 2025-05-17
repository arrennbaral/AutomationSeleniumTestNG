package testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.TakeScreenShot;
import utilities.ReadXLSData;

public class TestCaseFirst extends BaseTest {
	
	@Test(dataProviderClass = ReadXLSData.class, dataProvider = "testdata")
	public static void LoginTest(String username, String password) {
		
		driver.findElement(By.className(loc.getProperty("sign_in"))).click(); //locators -- properties
		driver.findElement(By.id(loc.getProperty("login_field"))).sendKeys(username);
		
		driver.findElement(By.id(loc.getProperty("next_button"))).click();
		driver.findElement(By.id(loc.getProperty("password_field"))).sendKeys(password);
		driver.findElement(By.id(loc.getProperty("password_field"))).click();
		TakeScreenShot.captureScreenshot(driver, "LoginTest");

		//System.out.println(driver.getTitle());
		//AssertJUnit.assertEquals(driver.getTitle(), "Zoho Accounts");
	}
	
//	@DataProvider(name = "testdata")
//	public Object [][] testData(){
//		
//		return new Object [][] {
//			{"arrennbaral@gmail.com", "2kWip@HgY!S9gAL"},
//			{"arrenngmail.com", "===="},
//			{"arrennbaral@gmaom", "==="},
//			{"arrennbail.com", "=="},
//			{"arrennbil.com", "==="},
//		};
//		
//	}
	

}

package testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.TakeScreenShot;
import utilities.TestListener;
import utilities.ReadXLSData;
import utilities.ClickUtil;
import utilities.Visible;
import utilities.AssertionUtil;
@Listeners(TestListener.class)
public class TestCaseFirst extends BaseTest {
	
	
	//@Test(dataProviderClass = ReadXLSData.class, dataProvider = "testdata")
	@Test(dataProvider = "testdata")
	public static void LoginTest(String username, String password) throws InterruptedException {
		
		driver.findElement(By.className(loc.getProperty("sign_in"))).click(); //locators -- properties
		driver.findElement(By.id(loc.getProperty("login_field"))).sendKeys(username);
		ClickUtil.safeClick(driver, By.id(loc.getProperty("next_button")));
		//driver.findElement(By.id(loc.getProperty("next_button"))).click();
		
		if(Visible.isVisible(driver, By.id(loc.getProperty("password_field")))) {
			driver.findElement(By.id(loc.getProperty("password_field"))).sendKeys(password);
		}else {
			System.err.println("Element not visible");
		}
		//driver.findElement(By.id(loc.getProperty("password_field"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("show_password"))).click();
		Thread.sleep(6000);
		driver.findElement(By.id(loc.getProperty("sign_in_button"))).click();
		if(Visible.isVisible(driver, By.xpath("//a[@id='all-apps']") )) {
			//Asserts asserts = new Asserts();
			String check =  driver.findElement(By.xpath("//a[@id='all-apps']")).getText();
			AssertionUtil.assertEquals(check, "ALL APPS", "Verifying if Logged in");
		}
		
		System.out.println(driver.findElement(By.xpath("//a[@id='all-apps']") ));
		TakeScreenShot.captureScreenshot(driver, "LoginTest");

		//System.out.println(driver.getTitle());
		//AssertJUnit.assertEquals(driver.getTitle(), "Zoho Accounts");
	}
	
	@DataProvider(name = "testdata")
	public Object [][] testData(){
		
		return new Object [][] {
			{"arrennbaral@gmail.com", "2kWip@HgY!S9gAL"},
//			{"arrenngmail.com", "===="},
//			{"arrennbaral@gmaom", "==="},
//			{"arrennbail.com", "=="},
//			{"arrennbil.com", "==="},
		};
		
	}
	

}

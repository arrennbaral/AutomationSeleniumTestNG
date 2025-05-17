package testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class TestCaseFirst extends BaseTest {
	
	@Test
	public static void LoginTest() {
		
		driver.findElement(By.className(loc.getProperty("sign_in"))).click(); //locators -- properties
		driver.findElement(By.id(loc.getProperty("login_field"))).sendKeys("arrennbaral@gmail.com");
		driver.findElement(By.id(loc.getProperty("next_button"))).click();
		driver.findElement(By.id(loc.getProperty("password_field"))).sendKeys("------");
		driver.findElement(By.id(loc.getProperty("password_field"))).click();

		//System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Zoho Accounts");
	}

}

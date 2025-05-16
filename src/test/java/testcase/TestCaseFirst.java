package testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class TestCaseFirst extends BaseTest {
	
	@Test
	public static void LoginTest() {
		
		driver.findElement(By.className("zgh-login")).click(); //locators -- properties
		driver.findElement(By.id("login_id")).sendKeys("arrennbaral@gmail.com");
		driver.findElement(By.id("nextbtn")).click();
		driver.findElement(By.id("password")).sendKeys("------");
		driver.findElement(By.id("nextbtn")).click();

		//System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Zoho Accounts");
	}

}

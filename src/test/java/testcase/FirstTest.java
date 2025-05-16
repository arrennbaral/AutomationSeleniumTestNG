package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class FirstTest {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.zoho.com/"); // move to base 
		driver.manage().window().maximize(); // move to base
		driver.findElement(By.className("zgh-login")).click(); //locators -- properties
		driver.findElement(By.id("login_id")).sendKeys("arrennbaral@gmail.com");
		driver.findElement(By.id("nextbtn")).click();
		driver.findElement(By.id("password")).sendKeys("_________");
		driver.findElement(By.id("nextbtn")).click();
	
		//System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Zoho Accounts");
		
		driver.quit();
		
		
		
		
		
		
		
	}
	

}

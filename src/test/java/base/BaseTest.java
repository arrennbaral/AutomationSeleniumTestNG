package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	
	
	@BeforeTest
	public void setUp() throws IOException {
		if(driver == null) {
			FileReader fr = new FileReader("/Users/arrennbaral/Desktop/Java-Selenium/Automation_Framework/TestAutomationFramework/src/test/resources/configfiles/config.properties");
			prop.load(fr);
			
		}
		if(prop.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize(); // move to base
		}else if(prop.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize(); // move to base
			
		}else if(prop.getProperty("browser").equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize(); // move to base
		}
		
	}
	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Closed Succesfully");
	}
}

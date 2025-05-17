package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	
	public static FileReader fr;
	public static FileReader fr_locators;
	public WebDriver getDriver() {
		return driver;
	}
	
	@BeforeMethod
	
	public void setUp() throws IOException {
		if(driver == null) {
			FileReader fr = new FileReader(System.getProperty("user.dir")+ "/src/test/resources/configfiles/config.properties");
			FileReader fr_locators = new FileReader(System.getProperty("user.dir")+ "/src/test/resources/configfiles/locators.properties");
			prop.load(fr);
			loc.load(fr_locators);
			
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless");
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
			//driver.manage().window().maximize(); // move to base
		}else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize(); // move to base
			
		}else if(prop.getProperty("browser").equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize(); // move to base
		}
		
	}
	@AfterMethod
	
	public void tearDown() {
		driver.close();
		System.out.println("TearDown Succesful");
	}
}

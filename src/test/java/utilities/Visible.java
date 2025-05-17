package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Visible {
	public static boolean isVisible(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Clicked element: " + locator.toString());
			return true;
			
		}catch(Exception e) {
			System.err.println("Element not clickable: " + locator.toString());
			//e.printStackTrace();
			return false;
		}
	}

}
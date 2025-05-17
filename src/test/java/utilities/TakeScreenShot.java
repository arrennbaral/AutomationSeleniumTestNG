package utilities;

import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

public class TakeScreenShot {
	
	public static void captureScreenshot(WebDriver driver,String testName) {
		
		//timeStamp
		String timeStamp = new SimpleDateFormat("yyyMMdd__HHmmss").format(new Date());
		String fileName = testName + "_" +timeStamp + ".png";
		
		//Take Screenshot = 
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File folder = new File("screenshots");
		if (!folder.exists()) {
		    folder.mkdirs();
		}

		File dest = new File("screenshots/"+fileName);
		
		try {
			FileUtils.copyFile(src,dest);
			System.out.println("Screenshot saved: " + dest.getAbsolutePath());
		}catch (IOException e) {
			System.err.println("Failed to save screenshot: " + e.getMessage());
		}
	}
	
	

}

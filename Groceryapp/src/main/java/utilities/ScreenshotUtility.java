package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

	public void getScreenshot(WebDriver driver, String failedtestcase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;  //enable screenshot functionality by casting driver
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //screenshot will get saved in a temporary path 
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); //to generate current timestamp
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");   //user.dir - to get the project directory . OutputScreenShot folder is created for saving screenshot

		if (!f1.exists()) {  //to avoid generation of OutputScreenShot folder multiple times
			f1.mkdirs();    //mkdir --> will create folder using java
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedtestcase + timeStamp 
				+ ".png"; //destination screenshot name format 
		File finalDestination = new File(destination); 
		FileHandler.copy(screenShot, finalDestination); //copy screenshot from temporary path to project folder
	}
	
} 
package testScript;

import org.testng.annotations.Test;

import constants.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	FileInputStream fileinput;
	Properties properties;
	WaitUtilities waitutility = new WaitUtilities();
  
	WebDriver driver;
	/*@BeforeMethod(alwaysRun=true)
  @Parameters("browser")
  public void initializeBrowserMethod(String browser) throws Exception {
	  properties = new Properties();
	  fileinput = new FileInputStream(Constants.CONFIGFILE);
	  properties.load(fileinput); //reads the config file and loads its properties into the properties obj
	  if (browser.equalsIgnoreCase("Chrome")) {
		  driver = new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("Edge")) {
			  driver = new EdgeDriver();
		  }
		  else if(browser.equalsIgnoreCase("Firefox")) {
			  driver = new FirefoxDriver();
		  }
		  else
		  {
			  throw new Exception("Invalid Browser");
		  }
	  driver.get(properties.getProperty("url")); 
	  driver.manage().window().maximize(); 
	  
	  waitutility.implicitWait(driver);
  }*/
	
	@BeforeMethod
	public void initializeBrowser()
	{
		driver = new ChromeDriver(); 
		driver.get("https://groceryapp.uniqassosiates.com/admin/login"); //for getting the URL
		driver.manage().window().maximize();
	    }
  

  @AfterMethod(alwaysRun=true)
  public void driverQuitMethod(ITestResult itestresult) throws IOException {  //ITestResult is an interface
	  if(itestresult.getStatus()==ITestResult.FAILURE) {
		  ScreenshotUtility screenshot = new ScreenshotUtility();
		  screenshot.getScreenshot(driver, itestresult.getName());
	  }
	  
	  waitutility.implicitWait(driver);
	  driver.quit();
  }

}

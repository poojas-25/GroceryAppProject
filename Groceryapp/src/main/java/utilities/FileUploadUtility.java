package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;

public class FileUploadUtility {
	
	public void fileUploadUsingSendKeys(WebElement element, String filePath)
	{
		element.sendKeys(filePath);
	}
	
	//file upload using robot class method
		public void fileUpload_RobotClass(WebElement element, String filePath) throws AWTException
		{
			element.click();
			StringSelection ss = new StringSelection("///home/hp/Documents/915c399d-7f3d-4f07-aa61-e5bce3804782.pdf");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); //will copy the file path to clipboard
			Robot robot = new Robot();
			robot.delay(10000);
			robot.keyPress(KeyEvent.VK_CONTROL); //will press 'control' key
			robot.keyPress(KeyEvent.VK_V); //will press 'v' key and will paste the path
			robot.delay(5000);
			robot.keyRelease(KeyEvent.VK_CONTROL); // will release 'control' key
			robot.keyRelease(KeyEvent.VK_V); // will release 'v' key
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER); //will press 'enter' key and file will get uploaded
			robot.keyRelease(KeyEvent.VK_ENTER); // will release 'enter' key
		}

	
}

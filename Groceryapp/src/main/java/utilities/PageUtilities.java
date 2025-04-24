package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {

	WebDriver driver;

	// dropdown methods
	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropdownByIndex(WebElement element, int value) {
		Select object = new Select(element);
		object.selectByIndex(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropdownByVisibleText(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByVisibleText(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public void selectMultipleDropdownValues(WebElement element, String value, int n) {
		Select object = new Select(element);
		boolean multipleselection = object.isMultiple();
		System.out.println(multipleselection);
		for (int i = 0; i < n; i++) {
			object.selectByIndex(i);
		}
		List<WebElement> selectedelementslist = object.getAllSelectedOptions(); // for printing selected elements from
																				// for loop
		for (int i = 0; i < selectedelementslist.size(); i++) {
			System.out.println(selectedelementslist.get(i).getText());
		}
	}

	public void deselectDropdownValues(WebElement element) {
		Select object = new Select(element);
		object.deselectAll();
	}

	//JavaScriptExecutor
	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public void downScrollJavaScriptExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
	
	public void upScrollJavaScriptExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}
	
	public void rightScrollJavaScriptExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,0)", "");
	}
	
	public void leftScrollJavaScriptExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(-350,0)", "");
	}

	//generateCurrentDateAndTime
	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
	
	//checkbox
	
	public void selectSingleCheckbox(WebElement element) {
		if(!element.isSelected()) 
		{
			element.click();
		}
	}
	
	public void deselectSingleCheckbox(WebElement element) {
		if(element.isSelected())       
		{
			element.click();
		}
	}
	
	//DragAndDrop
	
	public void dragAndDrop(WebElement element, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(element, target).perform();
	}
	
	//Alert Window
	
	public void confrimationAlertOkButton(WebElement element,WebDriver driver) {
		element.click();
		driver.switchTo().alert().accept();
	}
	
    public void confrimationAlertCancelButton(WebElement element,WebDriver driver) {
    	element.click();
    	driver.switchTo().alert().dismiss();
	}
    
    public void promptAlert(WebElement element,WebDriver driver, String text) {
    	element.click();
    	driver.switchTo().alert().sendKeys(text);
    	driver.switchTo().alert().accept();
    }
    
    //Mouse Action
    public void rightClickUsingMouse(WebElement element,WebDriver driver) {
    	Actions action =new Actions(driver);
    	action.contextClick(element).perform();
    }
    
    public void doubleClickUsingMouse(WebElement element, WebDriver driver) {
    	Actions action =new Actions(driver);
    	action.doubleClick(element).perform();
    }
}

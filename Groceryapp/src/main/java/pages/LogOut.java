package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class LogOut {
	PageUtilities page = new PageUtilities();
	WebDriver driver;

	public LogOut(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminDropdwon;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement selectLogout;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signinButton;

	public void logoutFromTheApplication() {
		adminDropdwon.click();
		selectLogout.click();
	}
	
	public boolean isLoginButtonDisplayed() {
		return signinButton.isDisplayed();
	}
}

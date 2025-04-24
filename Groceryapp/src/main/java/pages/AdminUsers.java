package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.PageUtilities;

public class AdminUsers {

	PageUtilities page = new PageUtilities();
	ExcelUtility excealread = new ExcelUtility();
	WebDriver driver;

	public AdminUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement addNewUserButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement enterUsername;
	@FindBy(xpath = "//input[@id='password']")
	WebElement enterPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDropdown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement userCreadtedAlert;

	public AdminUsers clickAddNewUserButton() {
		addNewUserButton.click();
		return this;
	}

	public AdminUsers clearExistingValues() {
		enterUsername.clear();
		enterPassword.clear();
		return this;
	}

	public AdminUsers enterValuesInTheFieldsForUserCreation() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "Admin_User");
		String password = ExcelUtility.getStringData(1, 1, "Admin_User");
		enterUsername.sendKeys(username);
		enterPassword.sendKeys(password);
		page.selectDropdownByVisibleText(userTypeDropdown, "Admin");
		return this;
	}

	public AdminUsers clickSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean isUserCreatedAlertDisplayed() {
		return userCreadtedAlert.isDisplayed();
	}

}

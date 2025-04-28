package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;
import utilities.PageUtilities;
import utilities.WaitUtilities;

public class ManageCategory {

	PageUtilities page = new PageUtilities();
	FileUploadUtility upload = new FileUploadUtility();
	Constants constants = new Constants();
	ExcelUtility excelutility = new ExcelUtility();
	WaitUtilities waitutility = new WaitUtilities();
	WebDriver driver;
	
	public ManageCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement addNewCategory;
	@FindBy(xpath = "//input[@id='category']")WebElement enterCategory;
	@FindBy(xpath = "//li[@id='134-selectable']")WebElement selectGroup;
	@FindBy(xpath = "//input[@id='main_img']")WebElement chooseImage;
	@FindBy(xpath = "//button[@type='submit']")WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement successfulAlert;
	@FindBy(xpath = "//i[@class=' fa fa-search']")WebElement searchButton;
	@FindBy(xpath = "//input[@placeholder='Category']")WebElement enterSategoryToBeSearched;
	@FindBy(xpath = "//button[@name='Search']")WebElement FinalsearchButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]") List<WebElement> tableSearch;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement deleteSuccessfulAlert;
	
	public ManageCategory clickAddNewCategory() {
		addNewCategory.click();
		return this;
	}
	
	public ManageCategory enterValuesForAddingNewCategory() {
		enterCategory.sendKeys("Automation_Category"+page.generateCurrentDateAndTime());
		selectGroup.click();
		String path = Constants.CATEGORYIMAGE;
		upload.fileUploadUsingSendKeys(chooseImage, path);
		return this;
	}
	
	public ManageCategory clickSaveButton() {
		saveButton.click();
		return this;
	}
	
	public boolean isSuccessfulAlertDisplayed() {
		return successfulAlert.isDisplayed();
	}
	
	public ManageCategory deleteCategoryAdded() {
		page.confrimationAlertOkButton(deleteButton, driver);
		waitutility.implicitWait(driver);
		return this;
	}
	
	public boolean isDeleteSuccessfulAlertDisplayed() {
		return deleteSuccessfulAlert.isDisplayed();
	}
}

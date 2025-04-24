package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.FileUploadUtility;
import utilities.PageUtilities;

public class ManageCategory {

	PageUtilities page = new PageUtilities();
	FileUploadUtility upload = new FileUploadUtility();
	Constants constants = new Constants();
	ExcelUtility excelutility = new ExcelUtility();
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
		enterCategory.sendKeys("Automation_Category");
		selectGroup.click();
		String path = constants.CATEGORYIMAGE;
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
	
	public ManageCategory clickSearchButton() {
		searchButton.click();
		return this;
	}
	
	public ManageCategory searchRequiredCategory() {
		enterSategoryToBeSearched.sendKeys("Automation_Category");
		FinalsearchButton.click();
		return this;
	}
	
	public boolean verifySearchResult(String element , List<WebElement> list) {
		int flag = 0;
		for(WebElement searchResult : list)
		{
			if(searchResult.getText().equals(element))
			{
				System.out.println(searchResult.getText());
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyCatergorySearchResult() {
		String element = "Automation_Category";
		boolean result = verifySearchResult(element, tableSearch);
		return result;
	}
	
	public ManageCategory deleteCategoryAdded() {
		if(this.verifyCatergorySearchResult()==true) {
			page.confrimationAlertOkButton(deleteButton, driver);
		}
		else
		{
			System.out.println("Category searched is not found");
		}
		
		return this;
	}
	
	public boolean isDeleteSuccessfulAlertDisplayed() {
		return deleteSuccessfulAlert.isDisplayed();
	}
}

package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtilities;
import utilities.WaitUtilities;

public class SubCategory {
	
	PageUtilities page = new PageUtilities();
	FileUploadUtility upload = new FileUploadUtility();
	Constants constants = new Constants();
	WaitUtilities waitutility = new WaitUtilities();
	WebDriver driver;

	public SubCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newButton; 
	@FindBy(xpath = "//select[@id='cat_id']")WebElement categoryDropdown;
	@FindBy(xpath = "//input[@id='subcategory']")WebElement subcategoryField; 
	@FindBy(xpath = "//input[@id='main_img']")WebElement chooseFile;
	@FindBy(xpath = "//button[@type='submit']")WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement successAlert;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/edit?edit=3452&page_ad=1']")WebElement editButton;
	@FindBy(xpath = "//button[@name='update']")WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement updateAlert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")WebElement searchButton;
	@FindBy(xpath = "//select[@id='un']")WebElement searchCategory;
	@FindBy(xpath = "//input[@name='ut']")WebElement searchSubcategoryField;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")List<WebElement> tableSearch;
	@FindBy(xpath = "//button[@name='Search']")WebElement searchFinal;
	
	public SubCategory clickNewButton() {
		newButton.click();
		return this;
	}
	
	public SubCategory selectCategory() {
		page.selectDropdownByVisibleText(categoryDropdown, "Vegetables");
		return this;
	}
	
	public SubCategory enterSubcategory() {
		subcategoryField.sendKeys("Carrots"+page.generateCurrentDateAndTime()); //current date and time will get added to the subcategory name so that it will be unique
		return this;
	}
	
	public SubCategory uploadImage() {
		String path = constants.IMAGEUPLOAD;
		upload.fileUploadUsingSendKeys(chooseFile, path);
		return this;
	}
    
	public SubCategory clickSaveButton() {
		saveButton.click();
		return this;
	}
	
	public boolean isAlertDisplayed() {
		return successAlert.isDisplayed();
	}
	
	public SubCategory editSubcategory() {
		editButton.click();
		page.selectDropdownByVisibleText(categoryDropdown, "veggies");
		subcategoryField.clear();
		subcategoryField.sendKeys("Potatoes"+page.generateCurrentDateAndTime());
		return this;
	}
	
	public SubCategory clickUpdateSubcategory() {
		updateButton.click();
		return this;
	}
	
	public boolean isUpdateAlertDisplayed() {
		return updateAlert.isDisplayed();
	}
	
	public SubCategory clickSubcategorySearchButton() {
		searchButton.click();
		return this;
	}
	
	public SubCategory selectCategoryToBeSearched() {
		page.selectDropdownByVisibleText(searchCategory, "Vegetables");
		return this;
	}
	
	public SubCategory enterSubcategoryToBeSearched() {
		searchSubcategoryField.sendKeys("Carrots"); //current date and time will get added to the subcategory name so that it will be unique
		return this;
	}
	
	public SubCategory searchSubcatogryEntered() {
		searchFinal.click();
		return this;
	}
	
	public boolean verifySearchResult(String element ,List<WebElement> list) {
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
	
	public boolean verifySubcatergorySearchResult() {
		String element = "Carrots";
		boolean result = verifySearchResult(element, tableSearch);
		return result;
	}
}

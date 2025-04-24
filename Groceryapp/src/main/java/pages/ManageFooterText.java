package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.PageUtilities;
import utilities.WaitUtilities;

public class ManageFooterText {

	PageUtilities page =new PageUtilities();
	ExcelUtility excealread = new ExcelUtility();
	WaitUtilities waitutilities = new WaitUtilities();
	WebDriver driver;
	
	public ManageFooterText(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")WebElement editButton;
	@FindBy(xpath = "//textarea[@name='address']")WebElement addAddress;
	@FindBy(xpath = "//input[@id='email']")WebElement addEmailId;
	@FindBy(xpath = "//input[@id='phone']")WebElement addPhoneNumber;
	@FindBy(xpath = "//button[@name='Update']")WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement updateSuccessfulAlert;
	
	public ManageFooterText clickEditButton() {
		waitutilities.waitForWebElementToBeClickable(driver, editButton);
		editButton.click();
		return this;
	}
	
	public ManageFooterText clearExistsingValues() {
		addAddress.clear();
		addEmailId.clear();
		addPhoneNumber.clear();
		return this;
	}
	
	public ManageFooterText addRequiredValuesFromExcelSheet() throws IOException {
		//String address = ExcelUtility.getIntegerData(1, 0, "Manage_FooterText");
		//String emailId = ExcelUtility.getIntegerData(1, 1, "Manage_FooterText");
		//String phoneNumber = ExcelUtility.getIntegerData(1, 2, "Manage_FooterText");
		
		String address = ExcelUtility.getStringData(1, 0, "Manage_FooterText");
		String emailId = ExcelUtility.getStringData(1, 1, "Manage_FooterText");
		String phoneNumber = ExcelUtility.getStringData(1, 1, "Manage_FooterText");
		addAddress.sendKeys(address);
		addEmailId.sendKeys(emailId);
		addPhoneNumber.sendKeys(phoneNumber);
		return this;
	}
	
	public ManageFooterText clickUpdateButton() {
		updateButton.click();
		return this;
	}
	
	public boolean isUpdateSuccessfulAlertDisplayed() {
		return updateSuccessfulAlert.isDisplayed();
	}
}

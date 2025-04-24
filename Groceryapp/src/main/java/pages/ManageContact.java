package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.FileUploadUtility;
import utilities.PageUtilities;
import utilities.WaitUtilities;

public class ManageContact {

	PageUtilities page = new PageUtilities();
	FileUploadUtility upload = new FileUploadUtility();
	FakerUtility faker = new FakerUtility();
	WaitUtilities waitutilities = new WaitUtilities();
	WebDriver driver;

	public ManageContact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[@class='fas fa-edit']")WebElement editContact;
	@FindBy(xpath = "//input[@id='phone']")WebElement addPhoneNumber;
	@FindBy(xpath = "//input[@id='email']")WebElement addEmail;
	@FindBy(xpath = "//textarea[@name='address']")WebElement addAddress;
	@FindBy(xpath = "//textarea[@name='del_time']")WebElement addDeliverTime;
	@FindBy(xpath = "//input[@id='del_limit']")WebElement deliveryChargeLimit;
	@FindBy(xpath = "//button[@name='Update']")WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement updateSuccessfulAlert;
	
	public ManageContact clickEditContact() {
		waitutilities.waitForWebElementToBeVisible(driver, editContact);
		editContact.click();
		return this;
	}
	
	public ManageContact clearValuesInTextFields() {
		addPhoneNumber.clear();
		addEmail.clear();
		addAddress.clear();
		addDeliverTime.clear();
		deliveryChargeLimit.clear();
		return this;
	}
	
	public ManageContact editContactDetails() {
		addPhoneNumber.sendKeys(faker.generatePhoneNumber());
		addEmail.sendKeys(faker.generateEmailID());
		addAddress.sendKeys(faker.generateAddress());
		addDeliverTime.sendKeys("3");
		deliveryChargeLimit.sendKeys("300");
		return this;
	}
	
	public ManageContact clickUpdateButton() {
		updateButton.click();
		return this;
	}
	
	public boolean isUpdateSuccessfulAlertDisplayed() {
		return updateSuccessfulAlert.isDisplayed();
	}
}

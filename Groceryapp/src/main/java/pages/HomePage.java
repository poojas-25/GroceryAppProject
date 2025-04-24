package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-sub-category\"]")WebElement subcategoryPage;
	@FindBy(xpath = "//a[text()='Home']")WebElement navigateToHome;
	@FindBy(xpath = "//div[@class='small-box bg-info']//parent::a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")WebElement manageContact;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")WebElement manageFooterText;
	@FindBy(xpath = "//div[@class='small-box bg-info']//parent::a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-admin\"]")WebElement adminUsers;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[11]/div/a")WebElement manageCategory;
	
	/*public void navigateToSubcategory() {
		subcategoryPage.click();
	}*/
	
	public SubCategory navigateToSubcategory() {
		subcategoryPage.click();
		return new SubCategory(driver);
		
	}
	
	public HomePage navigateToHomePage() {
		navigateToHome.click();
		return this;
	}
	
	public ManageContact navigateToManageContacts() {
		manageContact.click();
		return new ManageContact(driver);
	}
	
	public ManageFooterText navigateToManageFooterText() {
		manageFooterText.click();
		return new ManageFooterText(driver);
	}
	
	public AdminUsers navigateToAdminUsers() {
		adminUsers.click();
		return new AdminUsers(driver);
	}
	
	public ManageCategory navigateToManageCategory() {
		manageCategory.click();
		return new ManageCategory(driver);
	}
}

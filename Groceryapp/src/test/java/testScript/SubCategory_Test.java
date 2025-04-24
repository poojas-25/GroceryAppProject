package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SubCategory;

public class SubCategory_Test extends BaseClass {

	LoginPage login;
	HomePage home;
	SubCategory subcategory;

	@Test
	public void verifyAddingNewSubcategoryWithValidDetails() throws IOException {

		LoginPage login = new LoginPage(driver);

		home = login.loginUsingExcelData();
		subcategory = home.navigateToSubcategory().clickNewButton().selectCategory().enterSubcategory().uploadImage()
				.clickSaveButton();

		boolean isAlertDisplayed = subcategory.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, "Subcategory is not added successfully");
	}

	@Test
	public void verifyEditingASubcategoryAdded() throws IOException {
		LoginPage login = new LoginPage(driver);

		home = login.loginUsingExcelData();
		subcategory = home.navigateToSubcategory().editSubcategory().clickUpdateSubcategory();

		boolean isUpdateAlertDisplayed = subcategory.isUpdateAlertDisplayed();
		Assert.assertTrue(isUpdateAlertDisplayed, "Subcategory is not updated successfully");

	}

	@Test
	public void verifySearchingExistingSubcategoryFromTheList() throws IOException {
		LoginPage login = new LoginPage(driver);

		home = login.loginUsingExcelData();
		subcategory = home.navigateToSubcategory().clickSubcategorySearchButton().selectCategoryToBeSearched()
				.enterSubcategoryToBeSearched().searchSubcatogryEntered();

		boolean verifySearchResult = subcategory.verifySubcatergorySearchResult();
		Assert.assertTrue(verifySearchResult, "Search result not found message is displayed");
	}
}

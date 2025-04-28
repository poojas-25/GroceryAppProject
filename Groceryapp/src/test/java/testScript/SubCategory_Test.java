package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
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
		Assert.assertTrue(isAlertDisplayed, Constants.SC_VERIFYADDINGNEWSUBCATEGORYUSINGVALIDDETAILS);
	}

	@Test
	public void verifyEditingASubcategoryAdded() throws IOException {
		LoginPage login = new LoginPage(driver);

		home = login.loginUsingExcelData();
		subcategory = home.navigateToSubcategory().editSubcategory().updateSubcategoryImage().clickUpdateSubcategory();

		boolean isUpdateAlertDisplayed = subcategory.isUpdateAlertDisplayed();
		Assert.assertTrue(isUpdateAlertDisplayed, Constants.SC_VERIFYEDITINGSUBCATEGORYADDED);

	}

	@Test
	public void verifySearchingExistingSubcategoryFromTheList() throws IOException {
		LoginPage login = new LoginPage(driver);

		home = login.loginUsingExcelData();
		subcategory = home.navigateToSubcategory().clickSubcategorySearchButton().selectCategoryToBeSearched()
				.enterSubcategoryToBeSearched().searchSubcatogryEntered();

		boolean verifySearchResult = subcategory.verifySubcatergorySearchResult();
		Assert.assertTrue(verifySearchResult, Constants.SC_VERIFYSEARCHINGEXISTINGSUBCATEGORYFROMTHELIST);
	}
}

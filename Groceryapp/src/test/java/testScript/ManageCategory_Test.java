package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategory;
import pages.ManageContact;

public class ManageCategory_Test extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageCategory category;

	@Test
	public void verifyAddingAnewCategory() throws IOException {
		LoginPage login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		category = home.navigateToManageCategory().clickAddNewCategory().enterValuesForAddingNewCategory()
				.clickSaveButton();

		boolean isAlertSuccessfulDisplayed = category.isSuccessfulAlertDisplayed();
		Assert.assertTrue(isAlertSuccessfulDisplayed, "Not able to add a new category");
	}

	@Test
	public void verifyDeletingACategoryAddedAfterSearching() throws IOException {
		LoginPage login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		category = home.navigateToManageCategory().clickSearchButton();
		//category.clickSearchButton();
		category.verifyCatergorySearchResult();
		category.deleteCategoryAdded();
		boolean isDeleteSuccessfulAlertDisplayed = category.isDeleteSuccessfulAlertDisplayed();
		Assert.assertTrue(isDeleteSuccessfulAlertDisplayed, "Not able to delete the category added");
	}
}

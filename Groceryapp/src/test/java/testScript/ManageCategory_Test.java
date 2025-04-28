package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategory;

public class ManageCategory_Test extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageCategory category;

	@Test(groups ="smoke")
	public void verifyAddingAnewCategory() throws IOException {
		LoginPage login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		category = home.navigateToManageCategory().clickAddNewCategory().enterValuesForAddingNewCategory()
				.clickSaveButton();

		boolean isAlertSuccessfulDisplayed = category.isSuccessfulAlertDisplayed();
		Assert.assertTrue(isAlertSuccessfulDisplayed, Constants.MC_VERIFYADDINGANEWCATEGORY);
	}

	@Test(enabled=true)
	public void verifyDeletingACategoryAdded() throws IOException {
		LoginPage login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		category = home.navigateToManageCategory().deleteCategoryAdded();
		boolean isDeleteSuccessfulAlertDisplayed = category.isDeleteSuccessfulAlertDisplayed();
		Assert.assertTrue(isDeleteSuccessfulAlertDisplayed, Constants.MC_VERIFYDELETINGACATEGORYADDEDAFTERSEARCHING);
	}
}

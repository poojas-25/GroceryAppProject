package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsers;
import pages.HomePage;
import pages.LoginPage;

public class Admin_Users extends BaseClass {
	LoginPage login;
	HomePage home;
	AdminUsers admin;

	@Test
	public void verifyAddingNewUserWithValidDetails() throws IOException {

		LoginPage login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		admin = home.navigateToAdminUsers().clickAddNewUserButton().clearExistingValues()
				.enterValuesInTheFieldsForUserCreation().clickSaveButton();

		boolean isUserAddedAlertDisplayed = admin.isUserCreatedAlertDisplayed();
		Assert.assertTrue(isUserAddedAlertDisplayed, "User not created successfully");
	}
}

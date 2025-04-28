package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContact;

public class ManageContact_Test extends BaseClass {

	LoginPage login;
	HomePage home;
	ManageContact contact;

	@Test
	public void verifyEditingExistingContact() throws IOException {

		LoginPage login = new LoginPage(driver);

		home = login.loginUsingExcelData();
		contact = home.navigateToManageContacts().clickEditContact().clearValuesInTextFields().editContactDetails()
				.clickUpdateButton();

		boolean isUpdateSuccessfulAlertDisplayed = contact.isUpdateSuccessfulAlertDisplayed();
		Assert.assertTrue(isUpdateSuccessfulAlertDisplayed,Constants.MCONT_VERIFYEDITINGEXISTINGCONTACT );
	}
}

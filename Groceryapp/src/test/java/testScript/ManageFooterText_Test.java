package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterText;

public class ManageFooterText_Test extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageFooterText footer;

	@Test
	public void verifyUpdatingManageFooterText() throws IOException {
		LoginPage login = new LoginPage(driver);
		home = login.loginUsingExcelData();

		footer = home.navigateToManageFooterText().clickEditButton().clearExistsingValues()
				.addRequiredValuesFromExcelSheet().clickUpdateButton();

		boolean isSuccessfulAlertDisplayed = footer.isUpdateSuccessfulAlertDisplayed();
		Assert.assertTrue(isSuccessfulAlertDisplayed, Constants.MFT_VERIFYUPDATINGMANAGEFOOTERTEXT);
	}
}

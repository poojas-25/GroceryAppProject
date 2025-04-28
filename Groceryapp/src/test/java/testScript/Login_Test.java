package testScript;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;

public class Login_Test extends BaseClass {
  @Test
  public void loginUsingValidCredentials() {
	  LoginPage obj = new LoginPage(driver);
	  obj.enterUsernameOnUsernameField("admin");
	  obj.enterPasswordOnPasswordField("admin");
	  obj.clickLoginButton();
	  boolean isHomePageLoaded = obj.isIconDisplayed();
	  
      Assert.assertTrue(isHomePageLoaded, Constants.LP_VERIFYLOGINWITHVALIDCREDENTIALS);  //getting assertions messages from the class "Constants"
  }
  
  @Test
  public void loginUsingValidUsernameAndInvalidPassword() {
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameOnUsernameField("admin");
	  login.enterPasswordOnPasswordField("Admin1");
	  login.clickLoginButton();
	  boolean isAlertDisplayed = login.isAlertDisplayed();
	  Assert.assertTrue(isAlertDisplayed, Constants.LP_VERIFYLOGINWITHINVALIDPASSWORD);
  }
  
  @Test
  public void verifyUserLoginWithInvalidUsernameAndValidPassword() {
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameOnUsernameField("admin333");
	  login.enterPasswordOnPasswordField("admin");
	  login.clickLoginButton();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	  boolean isAlertDisplayed = login.isAlertDisplayed();
	  Assert.assertTrue(isAlertDisplayed, Constants.LP_VERIFYLOGINWITHINVALIDUSERNAME);
  }
  
  @Test(dataProvider = "invalidCredetials")
  public void verifyLoginWithInvalidCredentials(String a, String b) {
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameOnUsernameField(a);
	  login.enterPasswordOnPasswordField(b);
	  login.clickLoginButton();
	  boolean isAlertDisplayed = login.isAlertDisplayed();
	  Assert.assertTrue(isAlertDisplayed, Constants.LP_VERIFYLOGINWITHVALIDCREDENTIALS);
  }
  
  @DataProvider
  public Object[][] invalidCredetials(){
	  return new Object[][] {{"adim123","admintest"},{"testuser","testpassword"}};
  }
  
  @Test
  public void loginUsingValidCredentialsFromExcelsheet() throws IOException {  //getting data from excel sheet
	  LoginPage obj = new LoginPage(driver);
	  obj.loginUsingExcelData();
	  boolean isHomePageLoaded = obj.isIconDisplayed();
	  
      Assert.assertTrue(isHomePageLoaded, Constants.LP_VERIFYLOGINWITHVALIDCREDENTIALS);  
  }
  
}

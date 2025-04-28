package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LogOut;
import pages.LoginPage;

public class Log_Out extends BaseClass{
  @Test
  public void verifyLogoutFunction() throws IOException {
	  LoginPage login = new LoginPage(driver);
	  login.loginUsingExcelData();
	  
	  LogOut logout = new LogOut(driver);
	  logout.logoutFromTheApplication();
	  boolean isLogoutSuccessful = logout.isLoginButtonDisplayed();
	  Assert.assertTrue(isLogoutSuccessful, Constants.LO_VERIFYLOGOUTFUNCTION);
  }
}

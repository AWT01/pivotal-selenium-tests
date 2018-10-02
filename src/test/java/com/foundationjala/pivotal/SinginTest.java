package com.foundationjala.pivotal;

import com.foundationjala.pivotal.model.AbstractPage;
import com.foundationjala.pivotal.model.pageObject.login.HomePage;
import com.foundationjala.pivotal.model.pageObject.login.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */

public class SinginTest extends AbstractPage {

  WebDriver driver;

  @Test
  public void SiginByEmail() {
    this.driver = this.getDriver();
    HomePage homePage = new HomePage(driver);
    homePage.clickOnSignIn();

    SignInPage signInPage = new SignInPage(driver);
    signInPage.setUsernameTextBox("elianor@gmail.com");
    signInPage.clickOnLoginButton();
    signInPage.setPasswordTextBox("");
    signInPage.clickSignInButton();
  }
}



package org.fundacionjala.pivotal.model.pageobjects.login;

import org.fundacionjala.pivotal.model.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * .
 */
public class HomePage extends AbstractPage{

  @FindBy(how = How.LINK_TEXT, using = "Sign in") WebElement signin;

  // This method to click on Sign In
  public SignInPage clickOnSignIn() {
    SignInPage signInPage = new SignInPage();
    //wait.until(ExpectedConditions.elementToBeClickable(signin));
    signin.click();
    return signInPage;
  }
}

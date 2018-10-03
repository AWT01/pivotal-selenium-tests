package org.fundacionjala.pivotal.model.pageObject.login;

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
  public void clickOnSignIn() {
    //wait.until(ExpectedConditions.elementToBeClickable(signin));
    signin.click();
  }
}

package com.foundationjala.pivotal.model.pageObject.login;

import com.foundationjala.pivotal.model.AbstractPage;
import com.foundationjala.pivotal.model.PageObjectFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

  @FindBy(how=How.LINK_TEXT, using = "Sign in") WebElement signin;
  // This method to click on Sign In
  public void clickOnSignIn(){
    wait.until(ExpectedConditions.elementToBeClickable(signin));
    signin.click();
  }
}

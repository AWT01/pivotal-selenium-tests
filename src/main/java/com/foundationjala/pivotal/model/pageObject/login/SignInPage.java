package com.foundationjala.pivotal.model.pageObject.login;

import com.foundationjala.pivotal.model.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends AbstractPage {
  //Using FindBy for locating elements
  @FindBy(how= How.XPATH, using="//input[@type='text'][@id='credentials_username']") WebElement usernameTextBox;
  @FindBy(how=How.XPATH, using="//input[@type='submit'][@value='NEXT']") WebElement nextButton;
  //Using FindBy for locating elements
  @FindBy(how= How.XPATH, using="//input[@type='password'][@id='credentials_password']") WebElement passwordTextBox;
  @FindBy(how=How.XPATH, using="//input[@type='submit'][@value='SIGN IN']") WebElement signInButton;

  // This method is to set Email in the email text box
  public void setUsernameTextBox(String userEmail){
    wait.until(ExpectedConditions.visibilityOf(usernameTextBox));
    usernameTextBox.sendKeys(userEmail);
  }

  // This method is to click on Login Button
  public void clickOnLoginButton(){
    wait.until(ExpectedConditions.elementToBeClickable(nextButton));
    nextButton.click();
  }

  // This method is to set Email in the email text box
  public void setPasswordTextBox(String userEmail){
    wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
    passwordTextBox.sendKeys(userEmail);
  }

  // This method is to click on Login Button
  public void clickSignInButton(){
    wait.until(ExpectedConditions.elementToBeClickable(signInButton));
    signInButton.click();
  }

}

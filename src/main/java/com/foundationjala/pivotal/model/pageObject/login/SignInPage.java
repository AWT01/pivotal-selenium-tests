package com.foundationjala.pivotal.model.pageObject.login;

import com.foundationjala.pivotal.model.PageObjectFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInPage {

  WebDriver driver;

  public SignInPage(WebDriver driver){
    this.driver=driver;
    //Initialise Elements from Home Page
    PageObjectFactory.initElements(this.driver,this);
  }

  //Using FindBy for locating elements
  @FindBy(how= How.XPATH, using="//input[@type='text'][@id='credentials_username']") WebElement usernameTextBox;
  // This method is to set Email in the email text box
  public void setUsernameTextBox(String userEmail){
    usernameTextBox.sendKeys(userEmail);
  }

  @FindBy(how=How.XPATH, using="//input[@type='submit'][@value='NEXT']") WebElement nextButton;
  // This method is to click on Login Button
  public void clickOnLoginButton(){
    nextButton.click();
  }

  //Using FindBy for locating elements
  @FindBy(how= How.XPATH, using="//input[@type='password'][@id='credentials_password']") WebElement passwordTextBox;
  // This method is to set Email in the email text box
  public void setPasswordTextBox(String userEmail){
    passwordTextBox.sendKeys(userEmail);
  }

  @FindBy(how=How.XPATH, using="//input[@type='submit'][@value='SIGN IN']") WebElement signInButton;
  // This method is to click on Login Button
  public void clickSignInButton(){
    signInButton.click();
  }

}

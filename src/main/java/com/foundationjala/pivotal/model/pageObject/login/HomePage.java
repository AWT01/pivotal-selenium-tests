package com.foundationjala.pivotal.model.pageObject.login;

import com.foundationjala.pivotal.model.PageObjectFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

  WebDriver driver;
  //Page URL
  private static String PAGE_URL="https://www.pivotaltracker.com/";

  public HomePage(WebDriver driver){
    this.driver=driver;
    this.driver.get(PAGE_URL);
    //Initialise Elements
    PageObjectFactory.initElements(this.driver,this);
  }

  @FindBy(how=How.LINK_TEXT, using = "Sign in") WebElement signin;
  // This method to click on Sign In
  public void clickOnSignIn(){
    signin.click();
  }
}

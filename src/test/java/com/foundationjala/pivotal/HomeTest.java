package com.foundationjala.pivotal;
import com.foundationjala.pivotal.model.PageObjectFactory;
import com.foundationjala.pivotal.model.pageObject.login.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.foundationjala.pivotal.model.AbstractPage;

public class HomeTest extends AbstractPage {

  WebDriver driver;

  @Test
  public void init() throws Exception{
    driver = this.getDriver();
    HomePage homePage = new HomePage(driver);
    PageObjectFactory.initElements(driver, HomePage.class);
    homePage.clickOnSignIn();
    this.closeDriver();
  }
}

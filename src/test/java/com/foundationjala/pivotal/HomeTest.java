package com.foundationjala.pivotal;
import com.foundationjala.pivotal.model.PageObjectFactory;
import com.foundationjala.pivotal.model.pageObject.login.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.foundationjala.pivotal.model.AbstractPage;

public class HomeTest extends AbstractPage {



  @Test
  public void init() throws Exception{

    HomePage homePage = new HomePage();
    homePage.clickOnSignIn();
    this.closeDriver();
  }
}

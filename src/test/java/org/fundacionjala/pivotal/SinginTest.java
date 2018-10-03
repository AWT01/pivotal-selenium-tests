package org.fundacionjala.pivotal;

import org.fundacionjala.pivotal.model.AbstractPage;
import org.fundacionjala.pivotal.model.PageObjectFactory;
import org.fundacionjala.pivotal.model.pageObject.login.HomePage;
import org.fundacionjala.pivotal.model.pageObject.login.SignInPage;
import org.testng.annotations.Test;

/**
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */

public class SinginTest extends AbstractPage {

  @Test
  public void SiginByEmail() {
    HomePage homePage = new HomePage();
    homePage.initDriver();
    homePage.clickOnSignIn();

    SignInPage signInPage = new SignInPage();
    PageObjectFactory.initElements(homePage.getDriver(),signInPage);
    signInPage.setUsernameTextBox("elianor@gmail.com");
    signInPage.clickOnLoginButton();
    signInPage.setPasswordTextBox("200105574lo");
    signInPage.clickSignInButton();

    /*StoryPage storyPage = new StoryPage();
    PageObjectFactory.initElements(homePage.getDriver(),storyPage);
    storyPage.clickStoryButton();
    storyPage.clickAddSideBarStoryButton();*/


  }
}

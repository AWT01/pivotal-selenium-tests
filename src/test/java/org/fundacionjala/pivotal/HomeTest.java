package org.fundacionjala.pivotal;

import org.fundacionjala.pivotal.model.pageobjects.login.HomePage;
import org.testng.annotations.Test;

/**
 * Test Home Page.
 */
public class HomeTest {

    /**
    * Test button "sign in" on Home Page.
    */
    @Test
    public void init() {
        HomePage homePage = new HomePage();
        homePage.clickOnSignIn();
    }

}

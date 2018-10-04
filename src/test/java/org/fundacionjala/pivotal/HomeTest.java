package org.fundacionjala.pivotal;

import org.fundacionjala.pivotal.model.pageObject.login.HomePage;
import org.testng.annotations.Test;

/**
 * .
 */
public class HomeTest {

    /**
    * .
    */
    @Test
    public void init() {
        HomePage homePage = new HomePage();
        homePage.clickOnSignInButton();
    }

}

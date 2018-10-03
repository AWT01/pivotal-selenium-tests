package org.fundacionjala.pivotal;

import org.fundacionjala.pivotal.model.AbstractPage;
import org.fundacionjala.pivotal.model.PageObjectFactory;

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
        PageObjectFactory.initElements(homePage.getDriver(), homePage);
        homePage.clickOnSignIn();
        homePage.getDriver().close();
    }

}

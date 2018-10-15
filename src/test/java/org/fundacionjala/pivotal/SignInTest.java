package org.fundacionjala.pivotal;

import org.fundacionjala.pivotal.model.pageobjects.WebDriverManager;
import org.fundacionjala.pivotal.model.pageobjects.login.SignInPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Test of sign in page.
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */

public class SignInTest {
    /**
     * Test of sign in method, set valid user credentials for pivotaltracker.com inside this method.
     */
    @Test
    public void smartSignIn() {

       SignInPage.newCredentials("hapsneeze", "test12345");
       SignInPage.newCredentials("adrinrojas1","test12345");
    }
    /**
     * Close driver after test.
     */
    @AfterTest
    public void closeSession() {
        WebDriverManager.getInstance().getDriver().close();
    }
}

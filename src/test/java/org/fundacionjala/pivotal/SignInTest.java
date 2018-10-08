package org.fundacionjala.pivotal;

import org.fundacionjala.pivotal.model.pageobjects.login.SignInPage;
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
    public void signInByEmail() {
        SignInPage.loginAs("aaaaaa@aaaaa", "111111");
    }
}

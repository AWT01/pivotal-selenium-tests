package org.fundacionjala.pivotal.pageobjects.login;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.core.ui.CommonActions;
import org.fundacionjala.core.ui.CookieManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object for Pivotal Sign In Page.
 * @author Angelica Lopez, Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class SignInPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger("Sign in pivotal");

    @FindBy(css = "input[type='text'][id='credentials_username']")
    private WebElement usernameTextBox;

    @FindBy(css = "input[type='submit'][value='NEXT']")
    private WebElement nextButton;

    @FindBy(css = "input[type='password'][id='credentials_password']")
    private WebElement passwordTextBox;

    @FindBy(css = "input[type='submit'][value='SIGN IN']")
    private WebElement signInButton;

    /**
     * This method is to set Email in the email text box.
     * @param userEmail .
     */
    public void setUsernameTextBox(final String userEmail) {
        CommonActions.setText(usernameTextBox, userEmail);
    }

    /**
     * This method is to click on Login Button.
     */
    public void clickOnLoginButton() {
        CommonActions.click(nextButton);
    }

    /**
     * This method is to set Email in the email text box.
     * @param userPassword .
     */
    public void setPasswordTextBox(final String userPassword) {
        CommonActions.setText(passwordTextBox, userPassword);
    }

    /**
     * This method is to click on Login Button.
     * @return .
     */
    public Dashboard clickSignInButton() {
        CommonActions.click(signInButton);
        return new Dashboard();
    }

    /**
     * Smart login checking current session with cookies.
     * @param username that.
     * @param password that.
     * @return a Dashboard object
     */
    public static Dashboard credentials(final String username, final String password) {
            String currentSession = CookieManager.getValueOfCookieNamed("lastuser");

            LOGGER.log(Level.INFO, "Check if user: " + username + "is logged");
            LOGGER.log(Level.INFO, "User logged is: "
                    + CookieManager.getValueOfCookieNamed("lastuser"));
            // change sessions if needed
            if (!username.equals(currentSession)) {
                CookieManager.deleteAllCookies();
                    WebDriverManager.getInstance().getDriver().get(HomePage.HOME_PAGE_URL);
                    HomePage homePage = new HomePage();
                    SignInPage signInPage = homePage.clickOnSignInButton();
                    signInPage.setUsernameTextBox(username);
                    LOGGER.log(Level.INFO, "Sign in on pivotaltracker.com, user: " + username);
                    signInPage.clickOnLoginButton();
                    signInPage.setPasswordTextBox(password);
                    return signInPage.clickSignInButton();

            } else {
                LOGGER.log(Level.INFO, "User: " + username + "is already logged");
                return new Dashboard();
            }
    }
}

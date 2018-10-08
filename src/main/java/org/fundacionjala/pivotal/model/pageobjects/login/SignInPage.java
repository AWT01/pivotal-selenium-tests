package org.fundacionjala.pivotal.model.pageobjects.login;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.pivotal.model.pageobjects.AbstractPage;
import org.fundacionjala.pivotal.model.pageobjects.dashboard.PageDashboard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object for Pivotal Sign In Page.
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */
public class SignInPage extends AbstractPage {
    private static final Logger logger = LogManager.getLogger("Sign in pivotal");
    //Using FindBy for locating elements
    @FindBy(css = "input[type='text'][id='credentials_username']")
    private WebElement usernameTextBox;
    @FindBy(css = "input[type='submit'][value='NEXT']")
    private WebElement nextButton;
    //Using FindBy for locating elements
    @FindBy(css = "input[type='password'][id='credentials_password']")
    private WebElement passwordTextBox;
    @FindBy(css = "input[type='submit'][value='SIGN IN']")
    private WebElement signInButton;

    /**
     * This method is to set Email in the email text box.
     * @param userEmail .
     */
    public void setUsernameTextBox(final String userEmail) {
        wait.until(ExpectedConditions.visibilityOf(usernameTextBox));
        usernameTextBox.sendKeys(userEmail);
    }

    /**
     * This method is to click on Login Button.
     */
    public void clickOnLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    /**
     * This method is to set Email in the email text box.
     * @param userEmail .
     */
    public void setPasswordTextBox(final String userEmail) {
        wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
        passwordTextBox.sendKeys(userEmail);
    }

    /**
     * This method is to click on Login Button.
     * @return .
     */
    public PageDashboard clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        return new PageDashboard();
    }

    /**
     * Missing to implement switchUser.
     * @param username .
     * @param password .
     * @return .
     */
    public static PageDashboard loginAs(final String username, final String password) {
        HomePage homePage = new HomePage();
        homePage.getDriver().get(HomePage.HOME_PAGE_URL);
        SignInPage signInPage = homePage.clickOnSignInButton();
        signInPage.setUsernameTextBox(username);
        logger.log(Level.INFO, "Sign in on pivotaltracker.com, user: " + username);
        signInPage.clickOnLoginButton();
        signInPage.setPasswordTextBox(password);
        return signInPage.clickSignInButton();
    }

}

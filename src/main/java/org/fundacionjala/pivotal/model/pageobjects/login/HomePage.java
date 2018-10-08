package org.fundacionjala.pivotal.model.pageobjects.login;

import org.fundacionjala.pivotal.model.pageobjects.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Page Object for Pivotal Home Page.
 */
public class HomePage extends AbstractPage {
    //Page URL
    @FindBy(how = How.LINK_TEXT, using = "Sign in")
    private WebElement signin;

    /**
     * This method to click on Sign In.
     * @return .
     */
    public SignInPage clickOnSignInButton() {
        signin.click();
        return new SignInPage();
    }

}

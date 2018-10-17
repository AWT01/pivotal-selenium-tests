package org.fundacionjala.pivotal.pageobjects.login;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Page Object for Pivotal Home Page.
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */
public class HomePage extends AbstractPage {
    //Page URL
    @FindBy(how = How.LINK_TEXT, using = "Sign in")
    private WebElement signin;
    //TODO
    @FindBy(id = "AvatarDetails__imageContainer")
    private WebElement sessionName;
    /**
     * This method to click on Sign In.
     * @return .
     */
    public SignInPage clickOnSignInButton() {
        CommonActions.click(signin);
        return new SignInPage();
    }

    /**
     * method to get name of the session.
     * @return a string
     */
    public String getSessionName() {
        return CommonActions.getText(sessionName);
    }
}

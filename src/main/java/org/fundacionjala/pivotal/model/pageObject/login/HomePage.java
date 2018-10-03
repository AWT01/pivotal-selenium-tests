package org.fundacionjala.pivotal.model.pageObject.login;

import org.fundacionjala.pivotal.model.PageObjectFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * .
 */
public class HomePage {
    //Page URL
    private static final String PAGE_URL = "https://www.pivotaltracker.com/";

    private WebDriver driver;

    @FindBy(how = How.LINK_TEXT, using = "Sign in")
    private WebElement signin;
    /**
     * .
     * @param driver .
     */
    public HomePage(final WebDriver driver) {
        this.driver = driver;
        this.driver.get(PAGE_URL);
        //Initialise Elements
        PageObjectFactory.initElements(this.driver, this);
    }

    /**
     * This method to click on Sign In.
     */
    public void clickOnSignIn() {
        signin.click();
    }

    /**
     * .
     * @return .
     */
    public WebDriver getDriver() {
        return driver;
    }
}

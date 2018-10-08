package org.fundacionjala.pivotal.model.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Parent of Page Objects.
 */
public abstract class AbstractPage extends AbstractWebDriverEventListener {
    //Page URL
    public static final String HOME_PAGE_URL = "https://www.pivotaltracker.com/";
    private static final int WAIT_TIME = 30;
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor of class.
     */
    protected AbstractPage() {
        super();
        initDriver();
    }

    /**
     * Initilize WebDriver and WebDriverWait.
     */
    public void initDriver() {
        System.setProperty("webdriver.gecko.driver", "ThirdParty\\Geckodriver\\geckodriver.exe");
        this.driver = WebDriverManager.getInstance().getDriver();
        wait = new WebDriverWait(driver, WAIT_TIME);
        //Initialise Elements
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Return WebDriver object.
     * @return WebDriver object.
     */
    public WebDriver getDriver() {
        return driver;
    }
}

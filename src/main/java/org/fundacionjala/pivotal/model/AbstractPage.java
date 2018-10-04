package org.fundacionjala.pivotal.model;

import org.fundacionjala.pivotal.model.pageObject.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * .
 */
public abstract class AbstractPage extends AbstractWebDriverEventListener {
    //Page URL
    private static final String PAGE_URL = "https://www.pivotaltracker.com/";
    private static final int WAIT_TIME = 30;
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * .
     */
    protected AbstractPage() {
        super();
        initDriver();
    }

    /**
     *
     */
    public void initDriver() {
        System.setProperty("webdriver.gecko.driver", "ThirdParty\\Geckodriver\\geckodriver.exe");
        this.driver = WebDriverManager.getInstance().getDriver();
        wait = new WebDriverWait(driver, WAIT_TIME);
        this.driver.get(PAGE_URL);
        //Initialise Elements
        PageObjectFactory.initElements(this.driver, this);
    }
}

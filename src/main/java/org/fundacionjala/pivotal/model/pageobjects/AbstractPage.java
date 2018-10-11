package org.fundacionjala.pivotal.model.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Parent of Page Objects.
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */
public abstract class AbstractPage extends AbstractWebDriverEventListener {
    //Page URL
    public static final String HOME_PAGE_URL = "https://www.pivotaltracker.com/";
    private static final int WAIT_TIME = 30;
    public WebDriver driver;
    public WebDriverWait wait;

    /**
     * Constructor of class.
     */
    protected AbstractPage() {
        super();
        driver = browserFactory.goUpServer("firefox");
    }

    public static int getWaitTime() {
        return WAIT_TIME;
    }

}

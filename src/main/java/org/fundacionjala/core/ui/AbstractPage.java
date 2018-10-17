package org.fundacionjala.core.ui;

import org.fundacionjala.core.util.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * Parent of Page Objects.
 * @author Angelica Lopez, Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public abstract class AbstractPage {
    //Page URL
    public static final String HOME_PAGE_URL = Environment.getInstance().getProperties().getProperty("url");
    protected WebDriver driver;

    /**
     * Constructor of class.
     */
    protected AbstractPage() {
        this.driver = WebDriverManager.getInstance().getDriver();
        PageFactory.initElements(this.driver, this);
    }
}

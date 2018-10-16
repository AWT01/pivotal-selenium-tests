package org.fundacionjala.core.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * Parent of Page Objects.
 * @author Angelica Lopez, Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public abstract class AbstractPage extends AbstractWebDriverEventListener {
    //Page URL
    public static final String HOME_PAGE_URL = "https://www.pivotaltracker.com/";
    private WebDriver driver;

    /**
     * Constructor of class.
     */
    protected AbstractPage() {
        super();
        this.driver = WebDriverManager.getInstance().getDriver();
        PageFactory.initElements(this.driver, this);
    }
}

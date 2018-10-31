package org.fundacionjala.core.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Parent of Page Objects.
 * @author Angelica Lopez, Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public abstract class AbstractPage {
    protected WebDriver driver;

    /**
     * Constructor of class.
     */
    protected AbstractPage() {
        this.driver = WebDriverManager.getInstance().getDriver();
        PageFactory.initElements(this.driver, this);
    }
}

package org.fundacionjala.pivotal.model.pageobjects;

import org.openqa.selenium.WebDriver;

/**
 * Parent of Page Objects.
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */
public abstract class AbstractBrowser {

    /**
     * Initilize WebDriver and WebDriverWait.
     */
    public abstract void initDriver();

    /**
     * Return WebDriver object.
     * @return WebDriver object.
     */
    public abstract WebDriver getDriver();
}

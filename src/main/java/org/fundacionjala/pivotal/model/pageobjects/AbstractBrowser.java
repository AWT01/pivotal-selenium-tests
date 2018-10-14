package org.fundacionjala.pivotal.model.pageobjects;

import org.openqa.selenium.WebDriver;

/**
 * Parent of Page Objects.
 * @author Angelica Lopez, Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public abstract class AbstractBrowser {

    /**
     * Return WebDriver object.
     * @return WebDriver object.
     */
    public abstract WebDriver getDriver();
}

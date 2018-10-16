package org.fundacionjala.core.ui.browsers;

import org.openqa.selenium.WebDriver;

/**
 * Parent of Page Objects.
 * @author Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public interface AbstractBrowser {

    /**
     * Return WebDriver object.
     * @return WebDriver object.
     */
    WebDriver getDriver();
}

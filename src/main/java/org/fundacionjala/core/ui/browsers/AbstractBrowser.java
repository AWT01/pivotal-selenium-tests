package org.fundacionjala.core.ui.browsers;

import org.openqa.selenium.WebDriver;

/**
 * Parent of Page Objects.
 */
public interface AbstractBrowser {

    /**
     * Return WebDriver object.
     * @return WebDriver object.
     */
    WebDriver getDriver();
}

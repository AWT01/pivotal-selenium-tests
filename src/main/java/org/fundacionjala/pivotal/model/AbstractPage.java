package org.fundacionjala.pivotal.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * .
 */
public abstract class AbstractPage extends AbstractWebDriverEventListener {

    /**
    * .
    */
    protected AbstractPage() {
    super();
    }

    /**
    * .
    * @return .
    */
    public static WebDriver instanceFirefoxDriver() {
      System.setProperty("webdriver.gecko.driver", "ThirdParty\\Geckodriver\\geckodriver.exe");
      return new FirefoxDriver();
    }

}

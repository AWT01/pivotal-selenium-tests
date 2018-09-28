package com.foundationjala.pivotal.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public abstract class AbstractPage extends AbstractWebDriverEventListener {

  protected WebDriver driver;
  PageObjectFactory pageObjectFactory;

  public AbstractPage() {
    super();
  }

  public WebDriver getDriver() {
    System.setProperty("webdriver.gecko.driver", "ThirdParty\\Geckodriver\\geckodriver.exe");
    // Create a new instance of the Firefox driver
    // Notice that the remainder of the code relies on the interface,
    // not the implementation.
    this.driver = new FirefoxDriver();
    return driver;
  }

  public void initPage(WebDriver driver, PageObjectFactory pageObjectFactory) {
    this.pageObjectFactory = pageObjectFactory;
    PageFactory.initElements(driver, pageObjectFactory);
  }

  public PageObjectFactory getFactory() {
    return pageObjectFactory;
  }
}

package com.foundationjala.pivotal.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage extends AbstractWebDriverEventListener {

  protected WebDriver driver;
  //Page URL
  private static String PAGE_URL="https://www.pivotaltracker.com/";
  public WebDriverWait wait;

  public AbstractPage() {
    super();
  }

  public void initDriver(){
    System.setProperty("webdriver.gecko.driver", "ThirdParty\\Geckodriver\\geckodriver.exe");
    this.driver = new FirefoxDriver();
    wait = new WebDriverWait(driver, 30);
    this.driver.get(PAGE_URL);
    //Initialise Elements
    PageObjectFactory.initElements(this.driver,this);
  }

  public WebDriver getDriver() {
    // Create a new instance of the Firefox driver
    // Notice that the remainder of the code relies on the interface,
    // not the implementation.
    return driver;
  }

  public void closeDriver(){
    this.driver.quit();
  }

}

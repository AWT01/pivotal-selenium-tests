package com.foundationjala.pivotal.model;
import org.openqa.selenium.WebDriver;

public interface PageObjectFactory {
    public Object newInstance (WebDriver webDriver, String name);
    public Object newPageObject (Object pageObjectClass);
}

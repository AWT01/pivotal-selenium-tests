package com.foundationjala.pivotal.model;
import org.openqa.selenium.WebDriver;

public interface PageObjectFactory <T> {
    public void newInstance (WebDriver webDriver, String name);
    public Class<T> newPage (Class<T> pageObjectClass);
}

package com.foundationjala.pivotal.model;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public interface PageObjectFactory {

    static void initElements(WebDriver driver, Object page) {
        PageFactory.initElements(driver, page);
    }
}

package org.fundacionjala.pivotal.model;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * .
 */
public interface PageObjectFactory {

    /**
     * .
     * @param driver .
     * @param page .
     */
    static void initElements(WebDriver driver, Object page) {
        PageFactory.initElements(driver, page);
    }
}

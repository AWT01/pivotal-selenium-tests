package org.fundacionjala.pivotal.util;

import org.fundacionjala.pivotal.model.pageobjects.WebDriverManager;
import org.openqa.selenium.Cookie;

import java.util.Set;

public final class CookieManager {

    private CookieManager () {}

    /**
     * This method gets all the cookies
     * @return
     */
    public static Set<Cookie> getAllCookies() {
        return WebDriverManager.getInstance().getDriver().manage().getCookies();
    }

    /**
     *     This method gets a specified cookie
     */
    public static Cookie getCookieNamed(String name) {
        return WebDriverManager.getInstance().getDriver().manage().getCookieNamed(name);
    }

    /**
     *This method gets the value of a specified cookie.
     * @param name
     * @return
     */
    public static String getValueOfCookieNamed(String name) {
        return WebDriverManager.getInstance().getDriver().manage().getCookieNamed(name).getValue();
    }

    /**
     * This method deletes a specific cookie
     * @param name
     */
    public static void deleteCookieNamed(String name) {
        WebDriverManager.getInstance().getDriver().manage().deleteCookieNamed(name);
    }

    /**
     * This method deletes all cookies
     */
    public static void deleteAllCookies() {
        WebDriverManager.getInstance().getDriver().manage().deleteAllCookies();
    }
}

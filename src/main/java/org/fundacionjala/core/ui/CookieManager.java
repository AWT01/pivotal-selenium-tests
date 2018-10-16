package org.fundacionjala.core.ui;

import org.openqa.selenium.Cookie;

import java.util.Set;

/**
 * Class which manage cookies.
 * @author Adrian Rojas AWT - [01].
 * @version 0.1
 */
public final class CookieManager {

    /**
     * empty constructor.
     */
    private CookieManager() {
    }

    /**
     * This method gets all the cookies.
     * @return set of cookies
     */
    public static Set<Cookie> getAllCookies() {
        return WebDriverManager.getInstance().getDriver().manage().getCookies();
    }

    /**
     * This method gets a specified cookie.
     * @param name .
     * @return cookie object
     */
    public static Cookie getCookieNamed(final String name) {
        return WebDriverManager.getInstance().getDriver().manage().getCookieNamed(name);
    }

    /**
     *This method gets the value of a specified cookie.
     * @param name .
     * @return string
     */
    public static String getValueOfCookieNamed(final String name) {
        return WebDriverManager.getInstance().getDriver().manage().getCookieNamed(name).getValue();
    }

    /**
     * This method deletes a specific cookie.
     * @param name .
     */
    public static void deleteCookieNamed(final String name) {
        WebDriverManager.getInstance().getDriver().manage().deleteCookieNamed(name);
    }

    /**
     * This method deletes all cookies.
     */
    public static void deleteAllCookies() {
        WebDriverManager.getInstance().getDriver().manage().deleteAllCookies();
    }
}

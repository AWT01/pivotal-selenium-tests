package org.fundacionjala.pivotal.testng;

import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;
import org.fundacionjala.core.ui.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class DashboardTest {

    private Dashboard dashboard;

    /**
     * Set up of test Dashboard page, set the user credentials for pivotaltracker.com inside method.
     */
    @BeforeTest
    public void signIn() {
        dashboard = SignInPage.credentials(Environment.getInstance().getProperties().getProperty("user1"),
                Environment.getInstance().getProperties().getProperty("password1"));
    }

    /**
     * Test button "Create Project".
     */
    @Test
    public void pressCreateProjectButtonTest() {
        dashboard.clickCreateNewProjectButton();
    }

    /**
     * Close driver after test.
     */
    @AfterTest
    public void closeSession() {
        WebDriverManager.getInstance().getDriver().close();
    }
}

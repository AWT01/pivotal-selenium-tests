package org.fundacionjala.pivotal;
import org.fundacionjala.pivotal.model.pageobjects.dashboard.PageDashboard;
import org.fundacionjala.pivotal.model.pageobjects.login.SignInPage;
import org.fundacionjala.pivotal.util.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class DashboardTest {

    private PageDashboard dashboard;

    /**
     * Set up of test Dashboard page, set the user credentials for pivotaltracker.com inside method.
     */
    @BeforeTest
    public void signIn() {
        dashboard = SignInPage.loginAs("aaaaaa@aaaaa", "111111");
    }

    /**
     * Test button "Create Project".
     */
    @Test
    public void pressCreateProjectButtonTest() {
        dashboard.clickCreateNewProject();
    }

    /**
     * Close driver after test.
     */
    @AfterTest
    public void closeSession() {
        WebDriverManager.getInstance().getDriver().close();
    }
}

package org.fundacionjala.pivotal;
import org.fundacionjala.pivotal.model.pageObject.WebDriverManager;
import org.fundacionjala.pivotal.model.pageObject.dashboard.PageDashboard;
import org.fundacionjala.pivotal.model.pageObject.login.SignInPage;
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
     * .
     */
    @BeforeTest
    public void signIn() {
        dashboard = SignInPage.loginAs("elianor@gmail.com", "200105574lo");
    }

    /**
     * .
     */
    @Test
    public void pressCreateProjectButtonTest() {
        dashboard.clickCreateNewProject();
    }

    /**
     * .
     */
    @AfterTest
    public void closeSession() {
        WebDriverManager.getInstance().getDriver().close();
    }
}

package org.fundacionjala.pivotal;

import org.fundacionjala.pivotal.model.pageObject.WebDriverManager;
import org.fundacionjala.pivotal.model.pageObject.dashboard.PageDashboard;
import org.fundacionjala.pivotal.model.pageObject.dashboard.PageFormCreate;
import org.fundacionjala.pivotal.model.pageObject.login.SignInPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class CreateProjectTest {

    private PageFormCreate formPage;
    private PageDashboard dashboard;

    /**
     * .
     */
    @BeforeTest
    public void setUp() {
        dashboard = SignInPage.loginAs("kevin.herrera@fundacion-jala.org", "70723844");
    }

    /**
     * .
     */
    @Test
    public void testCreateProject() {
        formPage = dashboard.clickCreateNewProject();

        // Create project inteligente
        formPage.setProjectName("testProject");
        formPage.getExistingAccount("fundacion jala").click();
        formPage.createNewAccount("test account");
        formPage.setProjectPrivacy("public");

        //Implement assertions

    }

    /**
     * .
     */
    @AfterTest
    public void closeSession() {
        WebDriverManager.getInstance().getDriver().close();
    }
}

package org.fundacionjala.pivotal.testng;

import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;
import org.fundacionjala.pivotal.pageobjects.projects.Projects;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */
public class DeleteProjectTest {

    /**
     * Set up of test create project, set valid user credentials for pivotaltracker.com inside this method.
     */
    @BeforeTest
    public void setUp() {
        //Set user credentials before test
        SignInPage.loginAs(Environment.getInstance().getProperties().getProperty("user2"),
                Environment.getInstance().getProperties().getProperty("password2"));
    }

    /**
     * test of create project setting the name, account and privacy.
     */
    @Test
    public void testDeleteProject() {

        WebDriverManager.getInstance().getDriver().navigate().to("https://www.pivotaltracker.com/n/projects/2204878");
        Projects project = new Projects();
        project.enterProjectSettings();
        project.deleteProject();
    }

    /**
     * after test, close the driver.
     */
    @AfterTest
    public void closeSession() {
        WebDriverManager.getInstance().getDriver().close();
    }
}

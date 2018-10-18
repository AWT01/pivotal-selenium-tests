package org.fundacionjala.pivotal.testng;

import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.projects.Projects;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;
import org.fundacionjala.core.ui.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class CreateProjectTest {
    private Dashboard dashboard;
    private Projects project;

    /**
     * Set up of test create project, set valid user credentials for pivotaltracker.com inside this method.
     */
    @BeforeTest
    public void setUp() {
        //Set user credentials before test
        dashboard = SignInPage.credentials(Environment.getInstance().getProperties().getProperty("user2"),
                Environment.getInstance().getProperties().getProperty("password2"));
    }

    /**
     * test of create project setting the name, account and privacy.
     */
    @Test
    public void testCreateProject() {
        String projectName = "new test" + System.currentTimeMillis();
        project = dashboard.createNewProject(projectName, "public", "test account");
        //Asserting project name in project settings page
        project.enterProjectSettings();
        Assert.assertEquals(project.getProjectNameInputField().getAttribute("value"), projectName);

    }

    /**
     * after test, close the driver.
     */
    @AfterTest
    public void closeSession() {
        project.deleteProject();
        WebDriverManager.getInstance().getDriver().close();
    }
}

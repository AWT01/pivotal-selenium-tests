package org.fundacionjala.pivotal.testng;

import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.dashboard.FormCreate;
import org.fundacionjala.pivotal.pageobjects.projects.Projects;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;
import org.fundacionjala.core.ui.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class CreateProjectTest {
    private Dashboard dashboard;

    /**
     * Set up of test create project, set valid user credentials for pivotaltracker.com inside this method.
     */
    @BeforeTest
    public void setUp() {
        //Set user credentials before test
        dashboard = SignInPage.loginAs(Environment.getInstance().getProperties().getProperty("user2"),
                Environment.getInstance().getProperties().getProperty("password2"));
    }

    /**
     * test of create project setting the name, account and privacy.
     */
    @Test
    public void testCreateProject() {
        FormCreate formPage;
        formPage = dashboard.clickCreateNewProject();
        String projectName = "new test " + System.currentTimeMillis();
        //use of lambda strategy map pattern
        Map<String, String> formData = new HashMap<>();
        formData.put("name", projectName);
        formData.put("account", "test account");
        formData.put("privacy", "public");
        formData.keySet().forEach(form -> formPage.getStrategyFormMap(formData).get(form).fillCreateProjectForm());
        //submit data to create new project
        Projects projects = formPage.clickCreateButton();
        projects.enterProjectSettings();
        //Asserting project name in project settings page
        Assert.assertEquals(projects.getProjectNameInputField().getAttribute("value"), projectName);
    }

    /**
     * after test, close the driver.
     */
    @AfterTest
    public void closeSession() {
        WebDriverManager.getInstance().getDriver().close();
    }
}

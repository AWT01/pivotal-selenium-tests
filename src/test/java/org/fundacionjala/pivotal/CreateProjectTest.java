package org.fundacionjala.pivotal;

import java.util.HashMap;
import java.util.Map;
import org.fundacionjala.pivotal.model.pageobjects.WebDriverManager;
import org.fundacionjala.pivotal.model.pageobjects.dashboard.CreateProjectInputs;
import org.fundacionjala.pivotal.model.pageobjects.dashboard.PageDashboard;
import org.fundacionjala.pivotal.model.pageobjects.dashboard.PageFormCreate;
import org.fundacionjala.pivotal.model.pageobjects.dashboard.SettingsPage;
import org.fundacionjala.pivotal.model.pageobjects.login.SignInPage;
import org.testng.Assert;
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
     * Set up of test create project, set valid user credentials for pivotaltracker.com inside this method.
     */
    @BeforeTest
    public void setUp() {
        //Set user credentials before test
        dashboard = SignInPage.loginAs("aaaaa@aaaaa", "111111");
    }

    /**
     * test of create project setting the name, account and privacy.
     */
    @Test
    public void testCreateProject() {
        formPage = dashboard.clickCreateNewProject();
        String projectName = "new test " + System.currentTimeMillis();
        //use of lambda strategy map pattern
        Map<CreateProjectInputs, String> formData = new HashMap<>();
        formData.put(CreateProjectInputs.PROJECT_NAME, projectName);
        formData.put(CreateProjectInputs.PROJECT_ACCOUNT, "test account");
        formData.put(CreateProjectInputs.PROJECT_PRIVACY, "public");
        formData.keySet().forEach(form -> formPage.getStrategyFormMap(formData).get(form).fillCreateProjectForm());
        //submit data to create new project
        SettingsPage settingsPage = formPage.clickCreateButton();
        settingsPage.clickMoreButton();
        //Asserting project name in project settings page
        Assert.assertEquals(settingsPage.getProjectNameInputField().getAttribute("value"), projectName);
    }

    /**
     * test of create project setting the name, and account.
     */
    @Test
    public void testCreateProjectWithoutSetPrivacy() {
        formPage = dashboard.clickCreateNewProject();
        String projectName = "new test " + System.currentTimeMillis();
        //use of lambda strategy map pattern
        Map<CreateProjectInputs, String> formData = new HashMap<>();
        formData.put(CreateProjectInputs.PROJECT_NAME, projectName);
        formData.put(CreateProjectInputs.PROJECT_ACCOUNT, "test account");
        formData.keySet().forEach(form -> formPage.getStrategyFormMap(formData).get(form).fillCreateProjectForm());
        //submit data to create new project
        SettingsPage settingsPage = formPage.clickCreateButton();
        settingsPage.clickMoreButton();
        //Asserting project name in settings project panel
        Assert.assertEquals(settingsPage.getProjectNameInputField().getAttribute("value"), projectName);
    }

    /**
     * after test, close the driver.
     */
    @AfterTest
    public void closeSession() {
        WebDriverManager.getInstance().getDriver().close();
    }
}

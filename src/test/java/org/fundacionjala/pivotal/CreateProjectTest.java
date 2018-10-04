package org.fundacionjala.pivotal;

import java.util.HashMap;
import java.util.Map;
import org.fundacionjala.pivotal.model.pageObject.WebDriverManager;
import org.fundacionjala.pivotal.model.pageObject.dashboard.CreateProjectInputs;
import org.fundacionjala.pivotal.model.pageObject.dashboard.PageDashboard;
import org.fundacionjala.pivotal.model.pageObject.dashboard.PageFormCreate;
import org.fundacionjala.pivotal.model.pageObject.dashboard.SettingsPage;
import org.fundacionjala.pivotal.model.pageObject.login.SignInPage;
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
     * .
     */
    @BeforeTest
    public void setUp() {
        dashboard = SignInPage.loginAs("elianor@gmail.com", "200105574lo");    }

    /**
     * .
     */
    @Test
    public void testCreateProject() {
        formPage = dashboard.clickCreateNewProject();

        Map<CreateProjectInputs, String> formData = new HashMap<>();
        formData.put(CreateProjectInputs.PROJECT_NAME, "new test 10");
        formData.put(CreateProjectInputs.PROJECT_ACCOUNT, "test account");
        formData.put(CreateProjectInputs.PROJECT_PRIVACY, "public");
        formData.keySet().forEach(form -> formPage.getStrategyFormMap(formData).get(form).fillCreateProjectForm());
        SettingsPage settingsPage = formPage.clickCreateButton();
        settingsPage.clickMoreButton();
        //Asserting project name
        Assert.assertEquals(settingsPage.getProjectNameInputField().getAttribute("value"), "new test 10");
    }

    /**
     * .
     */
    @AfterTest
    public void closeSession() {
        WebDriverManager.getInstance().getDriver().close();
    }
}

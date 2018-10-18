package org.fundacionjala.pivotal.testng;

import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;
import org.fundacionjala.pivotal.pageobjects.workspaces.Workspaces;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class createWorkspaceTest {
    private Dashboard dashboard;
    private Workspaces workspace;

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
    public void testCreateWorkspace() {
        String workspaceName = "new test" + System.currentTimeMillis();
        workspace = dashboard.createNewWorkspace(workspaceName);
        //Asserting project name in project settings page
        Assert.assertTrue(workspaceName.equalsIgnoreCase(workspace.getWorkspaceName()));
    }

    /**
     * after test, close the driver.
     */
    @AfterTest
    public void closeSession() {
        workspace.enterWorkspaceSettings();
        workspace.deleteWorkspace();
        WebDriverManager.getInstance().getDriver().close();
    }
}


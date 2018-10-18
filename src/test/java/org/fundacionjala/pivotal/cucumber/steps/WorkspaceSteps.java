package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.dashboard.NewWorkspaceForm;
import org.fundacionjala.pivotal.pageobjects.workspaces.Workspaces;
import org.testng.Assert;

import java.util.Map;

/**
 * Workspace steps.
 */
public class WorkspaceSteps {
    private Dashboard dashboard = new Dashboard();
    private NewWorkspaceForm pageForm;
    private Workspaces workspace;
    private String workspaceName;

    /**
     * Enter environment for workspace.
     */
    @When("^I switch tab to workspaces and click the create button$")
    public void iSwitchTabToWorkspaces() {
        dashboard.clickWorkspaceTab();
        pageForm = dashboard.clickCreateWorkspaceButton();
    }

    /**
     * fill workspace form.
     * @param value name
     */
    @And("^I fill the fields of Create new workspace and press the create button$")
    public void iFillTheFieldsOfCreateNewWorkspaceAndPressTheCreateButton(final Map<String, String> value) {
        workspaceName = value.get("name") + System.currentTimeMillis();
        pageForm.setWorkspaceNameTextField(workspaceName);
        workspace = pageForm.clickCreateSubmit();
    }

    /**
     * Check if the workspace is created.
     */
    @Then("^I verify if the workspace is created$")
    public void iVerifyIfTheWorkspaceIsCreated() {
        Assert.assertTrue(workspaceName.equalsIgnoreCase(workspace.getWorkspaceName()));
    }
}

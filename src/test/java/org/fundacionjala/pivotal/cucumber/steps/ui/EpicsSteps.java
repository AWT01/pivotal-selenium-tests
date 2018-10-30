package org.fundacionjala.pivotal.cucumber.steps.ui;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;
import org.fundacionjala.pivotal.cucumber.steps.CommonSteps;
import org.fundacionjala.pivotal.pageobjects.epics.Epics;
import org.fundacionjala.pivotal.pageobjects.projects.Projects;
import org.testng.Assert;

/**
 * steps to create new epic.
 */
public class EpicsSteps {
    private Epics epicsPage;
    private Projects projects;

    /**
     * constructor for dependency injection.
     * @param projects projects page object
     */
    public EpicsSteps(final Projects projects) {
        this.projects = projects;
    }

    /**
     * click add epic action.
     */
    @When("^I click the add epics button$")
    public void iClickAddEpicsButton() {
        epicsPage = projects.clickEpicToggleButton();
        epicsPage.clickEpicAddButton();
    }

    /**
     * file the title of the epic with the data table.
     * @param value of the story
     */
    @When("^I fill the epic$")
    public void iFillStoryTitle(final Map<String, String> value) {
        CommonSteps.setLastTable(value);
        epicsPage.setEpicNameTextField(value.get("title"));
        epicsPage.clickEpicSaveButton();
    }

    /**
     * verify the title of the epic using a data table parameter.
     * @param tableData data for search and compare
     */
    @Then("^I verify if epic title is \"([^\"]*)\"$")
    public void iVerifyTheIs(final String tableData) {
        String[] keys = tableData.split("\\.");
        StringBuilder expectedName = new StringBuilder();
        if (keys.length >= 2) {
            expectedName.append(CommonSteps.getTablesMap().get(keys[0]).get(keys[1]));
        }
        Assert.assertEquals(epicsPage.getNameLocatorText(), expectedName.toString());
    }
}

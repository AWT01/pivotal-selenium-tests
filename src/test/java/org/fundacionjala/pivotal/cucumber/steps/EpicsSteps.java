package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;
import org.fundacionjala.pivotal.pageobjects.epics.Epics;
import org.testng.Assert;

/**
 * steps to create new epic.
 */
public class EpicsSteps {
    private Epics epicsPage;
    /**
     * click add epic action.
     */
    @When("^I click the add epics button$")
    public void iClickAddEpicsButton() {
        epicsPage = new Epics();
        epicsPage.clickEpicToggleButton();
        epicsPage.clickEpicAddButton();
    }

    /**
     * file the title of the epic with the data table.
     * @param value of the story
     */
    @When("^I fill the epic$")
    public void iFillStoryTitle(final Map<String, String> value) {
        epicsPage.setEpicNameTextField(value.get("title"));
        epicsPage.clickEpicSaveButton();
    }

    /**
     * click save the epic and check the creation.
     */
    @Then("^I verify if the epic was created$")
    public void iVerifyIfStoryWasCreated() {
        Assert.assertEquals("epicTest", epicsPage.getNameLocatorText());
    }
}

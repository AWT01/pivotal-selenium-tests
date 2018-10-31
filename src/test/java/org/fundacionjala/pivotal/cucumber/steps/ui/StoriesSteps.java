package org.fundacionjala.pivotal.cucumber.steps.ui;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.cucumber.steps.CommonSteps;
import org.fundacionjala.pivotal.pageobjects.story.Story;
import org.testng.Assert;

import java.util.Map;

/**
 * Class with the steps to create a story.
 * @author Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class StoriesSteps {
    private Story storyPage;

    /**
     * setup for story class.
     */
    public StoriesSteps(final Story storyPage) {
        this.storyPage = storyPage;
    }
    /**
     * click add story action.
     */
    @When("^I click the add story button$")
    public void iClickAddStoryButton() {
        storyPage.clickAddSideBarStoryButton();
    }

    /**
     * file the title of the story with the data table.
     * @param value of the story
     */
    @When("^I fill the story$")
    public void iFillStoryTitle(final Map<String, String> value) {
        storyPage.setStoryTitle(value.get("title"));
        storyPage.clickSaveButton();
    }

    /**
     * click save the story and check the creation.
     */
    @Then("^I verify if the story is \"([^\"]*)\"$")
    public void iVerifyIfStoryWasCreated(final String expectedStory) {
        String[] keys = expectedStory.split("\\.");
        StringBuilder story = new StringBuilder();
        if (keys.length >= 2) {
            story.append(CommonSteps.getTablesMap().get(keys[0]).get(keys[1]));
        }
        Assert.assertEquals(storyPage.getFirstStory(), story.toString());
    }

    /**
     * click the story button.
     */
    @When("^I click the story$")
    public void iClickTheStory() {
        storyPage.clickExpandStoryButton();
    }
}

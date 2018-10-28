package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.core.ui.WebDriverManager;
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
    @Before
    public void setUp() {
        storyPage = new Story();
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
    @Then("^I verify if the story was created$")
    public void iVerifyIfStoryWasCreated(final Map<String, String> value) {
        Assert.assertEquals(storyPage.getFirstStory(), value.get("title"));
    }

    /**
     * click the story button.
     */
    @When("^I click the story$")
    public void iClickTheStory() {
        storyPage.clickExpandStoryButton();
    }
}

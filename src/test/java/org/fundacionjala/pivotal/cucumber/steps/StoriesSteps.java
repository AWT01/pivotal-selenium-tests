package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pageobjects.story.Story;
import org.testng.Assert;

/**
 * Class with the steps to create a story.
 * @author Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class StoriesSteps {
    private Story storyPage;
    /**
     * click add story action.
     */
    @And("^I click the add story button$")
    public void iClickAddStoryButton() {
        storyPage = new Story();
        storyPage.clickAddSideBarStoryButton();
    }

    /**
     * file the title of the story with the data table.
     * @param title of the story
     */
    @And("^I fill the story \"([^\"]*)\"$")
    public void iFillStoryTitle(final String title) {
        storyPage.setStoryTitle(title);
    }

    /**
     * click save the story and check the creation.
     */
    @Then("^I verify if the story was created$")
    public void iVerifyIfStoryWasCreated() {
        storyPage.clickSaveButton();
        Assert.assertEquals(storyPage.getFirstStory(), "storyTest");
    }
}

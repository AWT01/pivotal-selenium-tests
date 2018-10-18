package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;
import org.fundacionjala.pivotal.pageobjects.story.Story;
import org.testng.Assert;

import java.util.Map;

/**
 * Class with the steps to create a story.
 */
public class StoriesSteps {
    private Story storyPage;


    /**
     * click add story action.
     */
    @Then("^I click the add story button$")
    public void iClickAddStoryButton() {
        storyPage.clickAddSideBarStoryButton();
    }

    /**
     * file the title of the story with the data table.
     * @param value map for data table
     */
    @And("^I fill the story title$")
    public void iFillStoryTitle(final Map<String, String> value) {
        storyPage.setStoryTitle(value.get("title"));
    }

    /**
     * click save the story and check the creation.
     */
    @Then("^I verify if the story was created$")
    public void iVerifyIfStoryWasCreated() {
        storyPage.clickSaveButton();
        Assert.assertEquals(storyPage.getFirstStory(), "testStory");
    }
}

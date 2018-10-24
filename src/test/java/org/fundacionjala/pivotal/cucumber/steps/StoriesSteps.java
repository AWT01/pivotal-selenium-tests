package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.pivotal.pageobjects.story.Story;
import org.fundacionjala.pivotal.restapi.RequestManager;
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
     * evento of create a project.
     */
    @When("^I create a new project$")
    public void iCreateNewProject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "api8");
        jsonObject.addProperty("new_account_name", "test");
        String idProject = RequestManager.postRequest("/projects", jsonObject.toString())
                .jsonPath().get("id").toString();
        String newUrl = WebDriverManager.getInstance().getDriver().getCurrentUrl()
                .replace("dashboard", "n/projects/" + idProject);
        WebDriverManager.getInstance().getDriver().navigate().to(newUrl);
    }

    /**
     * click add story action.
     */
    @When("^I click the add story button$")
    public void iClickAddStoryButton() {
        storyPage = new Story();
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
    public void iVerifyIfStoryWasCreated() {
        Assert.assertEquals("storyTest", storyPage.getFirstStory());
    }
}

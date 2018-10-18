package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;
import org.fundacionjala.pivotal.pageobjects.story.Story;
import org.testng.Assert;

import java.util.Map;

/**
 * Class with the steps to create a story.
 * @author Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class StoriesSteps {
    private static final Logger LOGGER = LogManager.getLogger("Read properties");
    private Story storyPage;
    /**
     * Precondition, user must be logged in
     * and enter in a existing project.
     *
     * @param username inserted
     * @param password inserted
     */
    @Given("^username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void usernameAndPassword(final String username, final String password) {
        Dashboard dashboard;
        try {
            dashboard = SignInPage.newCredentials(Environment.getInstance().getProperties()
                    .getProperty(username), Environment.getInstance().getProperties()
                    .getProperty(password));
        } catch (NullPointerException exception) {
            LOGGER.error("The parameters of username or password are missing in the config.properties file");
            throw exception;
        }

        WebDriverManager.getInstance().getDriver()
                .get(dashboard.getFirstProject());
        storyPage = new Story();
    }

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

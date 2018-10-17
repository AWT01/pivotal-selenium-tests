package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;
import org.fundacionjala.pivotal.pageobjects.story.StoryPage;

public class StepsStories {
    private StoryPage storyPage;
    /**
     * Precondition, user must be logged in.
     *
     * @param username inserted
     * @param password inserted
     */
    @Given("^username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void usernameAndPassword(final String username, final String password) {
        SignInPage.newCredentials(Environment.getInstance().getProperties()
                .getProperty(username),
                Environment.getInstance().getProperties()
                        .getProperty(password));
        storyPage = new StoryPage();
    }

    @Then("^I click the add story button$")
    public void iClickAddStoryButton() {
        WebDriverManager.getInstance().getDriver()
                .get(Environment.getInstance().getProperties()
                        .getProperty("url")+"/projects/2204878");
        storyPage.clickAddSideBarStoryButton();
    }

    @And("^I fill the story $")
    public void iFillStoryTitle(final String title) {
        storyPage.setStoryTitle(title);
        throw new cucumber.api.PendingException();
    }

    @Then("^I verify if the story was created$")
    public void iVerifyIfStoryWasCreated() {
        System.out.println("fin");
        //storyPage.clickSaveButton();
        //Assert.assertEquals();
    }
}

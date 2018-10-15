package org.fundacionjala.pivotal.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.fundacionjala.pivotal.model.pageobjects.WebDriverManager;
import org.fundacionjala.pivotal.model.pageobjects.login.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class MyStepdefs {
    /**
     * Precondition, user must be logged in.
     * @param username inserted
     * @param password inserted
     */
    @Given("^I log in as \"([^\"]*)\" \"([^\"]*)\"$")
    public void iLogInAs(String username, String password) {
        SignInPage.newCredentials(username,password);
    }

    /**
     * New project is created
     * @param projectName specify the project name
     * @param privacy specify if project is private or public, defined as a boolean
     */
    @When("^I create a new project with name \"([^\"]*)\" with privacy set to \"([^\"]*)\"$")
    public void iCreateANewProjectWithNameWithPrivacySetTo(String projectName, String privacy) {
        boolean setPrivacy = Boolean.getBoolean(privacy);
        System.out.println("Project to be created must be called: " + projectName);
        if(setPrivacy)
            System.out.println("Project is private");
        else System.out.println("Project is public");
    }

    @Then("^The project is created$")
    public void theProjectIsCreated() {
        System.out.println("Check project name and type");
    }
    /**
     * after test, close the driver.
     */
}

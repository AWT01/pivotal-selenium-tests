package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.dashboard.FormCreate;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;

/**
 * This class have common steps for cucumber tests.
 */
public class CommonSteps {
    private static final Logger LOGGER = LogManager.getLogger("Common Steps");
    private static Dashboard dashboard;
    private static FormCreate formPage;

    /**
     * getter for dasboard.
     * @return dashboardpage
     */
    public static Dashboard getDashboard() {
        return dashboard;
    }

    /**
     * getter for form page.
     * @return formpage
     */
    public static FormCreate getFormPage() {
        return formPage;
    }

    /**
     * Precondition, user must be logged in.
     *
     * @param username inserted
     * @param password inserted
     */
    @Given("^I log in as \"([^\"]*)\" \"([^\"]*)\"$")
    public void iLogInAs(final String username, final String password) {
        try {
            dashboard = SignInPage.newCredentials(Environment.getInstance()
                            .getProperties().getProperty(username),
                    Environment.getInstance().getProperties().getProperty(password));
        } catch (NullPointerException exeption) {
            LOGGER.error("The username or password are missing on config.properties");
            throw exeption;
        }

    }
    /**
     * .
     * Project button is selected.
     */
    @When("^I click the create project button$")
    public void iClickTheCreateProjectButton() {
        formPage = dashboard.clickCreateNewProjectButton();
    }
}

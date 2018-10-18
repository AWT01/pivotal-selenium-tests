package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.Given;
import org.fundacionjala.core.util.Environment;
import org.fundacionjala.pivotal.pageobjects.login.SignInPage;

/**
 * Common steps.
 */
public class CommonSteps {

    /**
     * Precondition, user must be logged in
     * and enter in a existing project.
     *
     * @param username inserted
     */
    @Given("^I log in as \"([^\"]*)\"$")
    public void iLogInAs(final String username) {
        String password = username.replace("user", "password");
        SignInPage.credentials(Environment.getInstance().getProperties().getProperty(username),
                Environment.getInstance().getProperties().getProperty(password));
    }
}

package org.fundacionjala.pivotal.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pageobjects.comment.Comment;
import org.testng.Assert;

import java.util.Map;

/**
 * class with the comment steps.
 */
public class CommentsSteps {
    private Comment comment;

    /**
     * setup for comment class.
     */
    public CommentsSteps(final Comment comment) {
        this.comment = comment;
    }

    /**
     * fill area.
     * @param value map.
     */
    @When("^I set the comment$")
    public void iClickTheTextAreaAndSetTheComment(final Map<String, String> value) {
        comment.setTextAreaComment(value.get("comment"));
    }

    /**
     * save comment.
     */
    @When("^I save the comment$")
    public void iSaveTheComment() {
        comment.clickSaveComment();
    }

    /**
     * verify creation of the comment.
     */
    @Then("^I verify if the comment was created$")
    public void iVerifyIfTheCommentWasCreated(final Map<String, String> value) {
        Assert.assertEquals(comment.getFirstComment(), value.get("comment"));
    }

    /**
     * click action menu.
     */
    @When("^I click action menu$")
    public void iClickActionMenu() {
        comment.clickActionMenu();
    }

    /**
     * click edit button.
     */
    @When("^I click the edit button$")
    public void iClickTheEditButton() {
        comment.clickActionEditMenu();
    }
}

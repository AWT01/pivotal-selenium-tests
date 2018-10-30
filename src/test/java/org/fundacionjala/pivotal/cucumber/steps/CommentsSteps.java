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
     * fill area.
     * @param value map.
     */
    @When("^I click the textarea and set the comment$")
    public void iClickTheTextAreaAndSetTheComment(final Map<String, String> value) {
        comment = new Comment();
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
    public void iVerifyIfTheCommentWasCreated() {
        Assert.assertEquals(comment.getFirstComment(), "test comment");
    }
}

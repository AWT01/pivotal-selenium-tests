package org.fundacionjala.pivotal.cucumber.steps.ui;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;
import org.fundacionjala.pivotal.cucumber.steps.CommonSteps;
import org.fundacionjala.pivotal.pageobjects.comment.Comments;
import org.fundacionjala.pivotal.pageobjects.story.Story;
import org.testng.Assert;

/**
 * steps to test comments on stories.
 */
public class CommentSteps {
    private Story story;
    private Comments comments;

    /**
     * constructor for dependency injection.
     * @param story new story instance
     */
    public CommentSteps(final Story story) {
        this.story = story;
    }

    /**
     * fill comment text field and click send comment button.
     * @param dataTable data to fill comment
     */
    @When("^I create a new comment$")
    public void iCreateANewComment(final Map<String, String> dataTable) {
        CommonSteps.setLastTable(dataTable);
        comments = story.scrollToCommentTextField();
        comments.setTextAreaComment(dataTable.get("comment"));
        comments.clickSaveComment();
    }

    /**
     * verify if comment content is equal to map data value.
     * @param expectedComment name to compare
     */
    @Then("^I verify if comment is \"([^\"]*)\"$")
    public void iVerifyIfCommentIs(final String expectedComment) {
        String[] keys = expectedComment.split("\\.");
        StringBuilder comment = new StringBuilder();
        if (keys.length >= 2) {
            comment.append(CommonSteps.getTablesMap().get(keys[0]).get(keys[1]));
        }
        Assert.assertEquals(comments.getNewCommentText(), comment.toString());
    }
}

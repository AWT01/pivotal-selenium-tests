package org.fundacionjala.pivotal.pageobjects.comment;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * comment actions.
 */
public class Comment extends AbstractPage {
    @FindBy(css = "textarea[data-aid='Comment__textarea']")
    private WebElement textAreaComment;

    @FindBy(css = "button[data-aid='comment-submit']")
    private WebElement saveCommentButton;

    @FindBy(css = "div[data-aid='message']")
    private WebElement firstComment;

    /**
     * fills the textarea with the comment.
     * @param comment string.
     */
    public void setTextAreaComment(final String comment) {
        //CommonActions.click(textAreaComment);
        CommonActions.setText(textAreaComment, comment);
    }

    /**
     * click and save the comment.
     */
    public void clickSaveComment() {
        CommonActions.click(saveCommentButton);
    }

    /**
     * get text.
     * @return string.
     */
    public String getFirstComment() {
        return CommonActions.getText(firstComment);
    }
}

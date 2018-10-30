package org.fundacionjala.pivotal.pageobjects.comment;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * comments actions.
 */
public class Comments extends AbstractPage {
    @FindBy(css = "textarea[data-aid='Comment__textarea']")
    private WebElement textAreaComment;

    @FindBy(css = "button[data-aid='comment-submit']")
    private WebElement saveCommentButton;

    @FindBy(css = "div[data-aid='message']")
    private WebElement firstComment;

    @FindBy(css = "div[data-aid='action-menu']")
    private WebElement actionMenuButton;

    @FindBy(xpath = "//span[text()='Edit']")
    private WebElement actionEditButton;

    @FindBy(css = "div[data-aid='message']>span>p")
    private WebElement newCommentContainer;

    /**
     * fills the textarea with the comment.
     * @param comment string.
     */
    public void setTextAreaComment(final String comment) {
        CommonActions.setText(textAreaComment, comment);
    }

    /**
     * click and save the comment.
     */
    public void clickSaveComment() {
        CommonActions.scrollToElement(saveCommentButton);
        CommonActions.click(saveCommentButton);
    }

    /**
     * get text.
     * @return string.
     */
    public String getFirstComment() {
        return CommonActions.getText(firstComment);
    }

    /**
     * click action menu.
     */
    public void clickActionMenu() {
        CommonActions.click(actionMenuButton);
    }

    /**
     * click action edit button.
     */
    public void clickActionEditMenu() {
        CommonActions.click(actionEditButton);
    }

    /**
     * get text of comment container.
     * @return text of comment
     */
    public String getNewCommentText() {
        return  CommonActions.getText(newCommentContainer);
    }
}

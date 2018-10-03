package org.fundacionjala.pivotal.model.pageObject.dashboard;

/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class FormParameters implements IFormFields {
    /**
     * .
     */
    public enum Privacy { PUBLIC, PRIVATE }
    private String projectName;
    private String accountName;
    private Privacy privacyValue;

    /**
     * .
     *
     * @param projectName  .
     * @param accountName  .
     * @param privacyValue .
     */
    @Override
    public void setFormFields(final String projectName, final String accountName, final Privacy privacyValue) {
        this.projectName = projectName;
        this.accountName = accountName;
        this.privacyValue = privacyValue;
    }

    /**
     * .
     * @return .
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * .
     * @return .
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * .
     * @return .
     */
    public Privacy getPrivacyValue() {
        return privacyValue;
    }
}

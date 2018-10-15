package org.fundacionjala.pivotal.util;

import org.fundacionjala.pivotal.model.pageobjects.dashboard.CreateProjectInputs;

import java.util.EnumMap;
import java.util.Map;

public class Helper {
    private String projectName;
    private String projectAccount;
    private String projectPrivacy;
    private Map<CreateProjectInputs, String> projectMap;

    /**
     * Get the Project Name for  delete purposes.
     *
     * @return String.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Set the Project Name value.
     *
     * @param projectName String.
     */
    public void setProjectName(final String projectName) {
        this.projectName = projectName;
    }
    /**
     * Get the Project Name for  delete purposes.
     *
     * @return String.
     */
    public String getProjectAccount() {
        return projectAccount;
    }

    /**
     * Set the Project Name value.
     *
     * @param projectAccount String.
     */
    public void setProjectAccount(final String projectAccount) {
        this.projectAccount = projectAccount;
    }
    /**
     * Get the Project Name for  delete purposes.
     *
     * @return String.
     */
    public String getProjectPrivacy() {
        return projectPrivacy;
    }

    /**
     * Set the Project Name value.
     *
     * @param projectPrivacy String.
     */
    public void setProjectPrivacy(final String projectPrivacy) {
        this.projectPrivacy = projectPrivacy;
    }

    /**
     * Get the project map.
     *
     * @return the project map object.
     */
    public Map<CreateProjectInputs, String> getProjectMap() {
        return projectMap;
    }

    /**
     * Set the project map.
     *
     * @param projectMap is the the map.
     */
    public void setProjectMap(final Map<CreateProjectInputs, String> projectMap) {
        this.projectMap = new EnumMap<>(projectMap);
        this.projectMap.replace(CreateProjectInputs.PROJECT_NAME, getProjectName());
        this.projectMap.replace(CreateProjectInputs.PROJECT_ACCOUNT, getProjectAccount());
        this.projectMap.replace(CreateProjectInputs.PROJECT_PRIVACY, getProjectPrivacy());
    }

}


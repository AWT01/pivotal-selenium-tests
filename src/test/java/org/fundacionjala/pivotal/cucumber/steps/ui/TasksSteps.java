package org.fundacionjala.pivotal.cucumber.steps.ui;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pageobjects.task.Task;
import org.testng.Assert;

import java.util.Map;

/**
 * steps for task feature.
 */
public class TasksSteps {
    private Task task;

    /**
     * setup for task class.
     */
    public TasksSteps(final Task task) {
        this.task = task;
    }

    /**
     * click enable.
     */
    @When("^I click the enable button of tasks$")
    public void iClickTheEnableButtonOfTasks() {
        task.clickEnableTaskButton();
    }

    /**
     * set title.
     * @param value map.
     */
    @When("^I set the name of the task$")
    public void iSetTheNameOfTheTask(final Map<String, String> value) {
        task.setAddEditText(value.get("title"));
    }

    @When("^I set the name of the new task$")
    public void iSetTheNameOfTheNewTask(final Map<String, String> value) {
        task.setAddNewTaskText(value.get("title"));
    }

    /**
     * save task.
     */
    @When("^I save the task$")
    public void iSaveTheTask() {
        task.clickSaveNewTaskButton();
    }

    /**
     * verify creation.
     */
    @Then("^I verify if the task was created$")
    public void iVerifyIfTheTaskWasCreated(final Map<String, String> value) {
        Assert.assertEquals(task.getFirstTask(), value.get("title"));
    }

    /**
     * get the first task created.
     */
    @When("^I select the task$")
    public void iSelectTheTask() {
        task.clickFirstTask();
    }

    /**
     * save the edit task.
     */
    @When("^I save the edited task$")
    public void iSaveTheEditedTask() {
        task.clickSaveEditTaskButton();
    }
}

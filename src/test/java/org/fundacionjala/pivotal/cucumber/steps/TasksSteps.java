package org.fundacionjala.pivotal.cucumber.steps;

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

    @When("^I click the enable button of tasks$")
    public void iClickTheEnableButtonOfTasks() {
        task = new Task();
        task.clickEnableTaskButton();
    }

    @When("^I set the name of the task$")
    public void iSetTheNameOfTheTask(final Map<String, String> value) {
        task.setAddText(value.get("title"));
    }

    @When("^I save the task$")
    public void iSaveTheTask() {
        task.clickSaveTaskButton();
    }

    @Then("^I verify if the task was created$")
    public void iVerifyIfTheTaskWasCreated() {
        Assert.assertEquals(task.getFirstTask(), "testTask");
    }
}

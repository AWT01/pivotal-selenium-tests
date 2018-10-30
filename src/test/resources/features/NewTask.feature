Feature: Manage task

    Background:
        Given I log in as "user1"
        And I send a post request "/projects" with data:
          | name              | projectapi |
          | new_account_name  | test       |
        And I verify the status code is "200"
        And I store the response as "Project1"

    @deleteProject
    Scenario: Create a new task
        When I open a project "Project1.name"
        And I click the add story button
        And I click the enable button of tasks
        And I set the name of the new task
        |title|testTask|
        And I save the task
        Then I verify if the task was created
        |title|testTask|
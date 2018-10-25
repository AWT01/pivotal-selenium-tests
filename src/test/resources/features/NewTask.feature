Feature: Manage task

    Background:
        Given I log in as "user1"
        And I create a new project
        And I click the add story button

    @deleteProject
    Scenario: Create a new task
        When I click the enable button of tasks
        And I set the name of the task
        |title|testTask|
        And I save the task
        Then I verify if the task was created
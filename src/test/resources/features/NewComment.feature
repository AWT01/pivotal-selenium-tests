Feature: Manage comment

  Background:
    Given I log in as "user1"
    And I create a new project
    And I open the project
    And I click the add story button

  @deleteProject
  Scenario: Create a new comment
    When I set the comment
    |comment|test comment|
    And I save the comment
    Then I verify if the comment was created
    |comment|test comment|
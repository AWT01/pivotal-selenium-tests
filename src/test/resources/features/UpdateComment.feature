Feature: Manage comment

  Background:
    Given I log in as "user1"
    And I create a new project
    And I create a new story
    And I create a new comment
    And I open the project

  @deleteProject
  Scenario: Update a comment
    When I click the story
    And I click action menu
    And I click the edit button
    And I set the comment
    |comment|edit|
    And I save the comment
    Then I verify if the comment was created
    |comment|test commentedit|
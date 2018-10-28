Feature: Manage Stories

  Background:
    Given I log in as "user1"
    And I create a new project
    And I create a new story
    And I open the project

  @deleteProject
  Scenario: Update a story
    When I click the story
    And I fill the story
    |title|edited|
    Then I verify if the story was created
    |title|storyTestedited|
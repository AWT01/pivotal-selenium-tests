Feature: Manage Stories

  Background:
    Given I log in as "user1"
    And I create a new project
    And I open the project

  @deleteProject
  Scenario: Create a new story
    When I click the add story button
    And I fill the story
    |title|storyTest|
    Then I verify if the story was created
    |title|storyTest|
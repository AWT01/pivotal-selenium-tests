Feature: Manage Stories
  Scenario Outline: Create a new story
    Given username "user1" and password "password1"
    Then I click the add story button
    And I fill the story <title>
    Then I verify if the story was created
    Examples:
      |title|
      |qqq|
      |fdf|

Feature: Manage Stories
  Scenario: Create a new story
    Given I log in as "adrinrojas1" "test12345"
    When I click the create project button
    And I fill the fields of Create new project and press the create button
      | name    | Public project |
      | account | newAccount     |
      | privacy | public         |

    And I click the add story button
    And I fill the story "storyTest"
    Then I verify if the story was created
Feature: Create a New Project

  @deleteProject
  Scenario: Create a new project with privacy set to public
    Given I log in as "adrinrojas1" "test12345"
    Then I click the create project button
    And I fill the fields of Create new project and press the create button
      | name    | Public project |
      | account | newAccount     |
      | privacy | public         |

    Then I verify if the project is created



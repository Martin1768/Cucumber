Feature: Login based scenarios

  Scenario: Valid admin login
    #Given user is able to access HRMS application
    When user enters admin username and password
    And user clicks on login button
    Then user is able to see dashboard page

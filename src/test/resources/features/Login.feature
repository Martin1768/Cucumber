Feature: Login based scenarios

  @loggin
  Scenario: Valid admin login
    #Given user is able to access HRMS application
    When user enters admin username and password
    And user clicks on login button
    Then user is able to see dashboard page
@logginin
  Scenario: Invalid admin login
    #Given user is able to access HRMS application
    When user enters invalid username and password
    And user clicks on login button
    Then user is able to see error message

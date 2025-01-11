Feature: Search employee

  Background:
    #Given user is able to access HRMS application
    When user enters admin username and password
    And user clicks on login button
    Then user is able to see dashboard page
    When user clicks on PIM button
    And user clicks on employee list option

  Scenario: Search employee by id
    #Given user is able to access HRMS application
    #When user enters admin username and password
    #And user clicks on login button
    #Then user is able to see dashboard page
    #When user clicks on PIM button
    #And user clicks on employee list option
    When user enters valid employee id
    And user clicks on search button
    Then user is able to see searched employee

  Scenario: Search employee by name
    #Given user is able to access HRMS application
    #When user enters admin username and password
    #And user clicks on login button
    #Then user is able to see dashboard page
    #When user clicks on PIM button
    #And user clicks on employee list option
    When user enters valid employee name
    And user clicks on search button
    Then user is able to see searched employee
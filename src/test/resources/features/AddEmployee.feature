Feature: Add epmployee

Background:
  #Given user is able to access HRMS application   // hooks opens the app
  When user enters admin username and password
  And user clicks on login button
  Then user is able to see dashboard page
  When user clicks on PIM button
  And user clicks on Add employee option

  @addemployee @add2names
    Scenario: Adding the employee by firstname and lastname
    And user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

  @addemployee @add3names
  Scenario: Adding the employee by firstname middlename and lastname
    And user enters firstname and middlename and lastname
    And user clicks on save button
    Then employee added successfully


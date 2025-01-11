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

  @addemployeebyparams
  Scenario: Adding employee using parameters
    And user enters "mark" and "anthony" and "jacob" in the application
    And user clicks on save button
    Then employee added successfully

  @addemployeebyhardtable
  Scenario Outline: Adding multiple employees
    And user adds "<firstname>" , "<middlename>" and "<lastname>"
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstname | middlename | lastname |
      | mark      | ms         | jacob    |
      | adam      | ms         | jacob    |
      | steve     | ms         | jacob    |

  @addemployeebydata
  Scenario: Adding multiple employees using data table
    When user adds multiple employees using table and save them
      | firstName | middleName | lastName |
      | mark      | ms         | jacob    |
      | adam      | ms         | jacob    |
      | steve     | ms         | jacob    |

  @addemployeebyexcel
  Scenario: Adding employees using excel file
    When user adds multiple employees from excel file

  @addemployeebyworkbooksheet
  Scenario Outline: Adding employees using workbooks and sheets
    When user adds multiple employees from workbook "<workbook>" and sheet "<sheet>"
    Examples:
      | workbook          | sheet  |
      | testsetUsers.xlsx | List 1 |
      | testdata.xlsx     | Sheet1 |


@admin
Feature: Admin - Users and access

  # **********************************************************************  #
                          # SCENARIO - 1 #
  # **********************************************************************  #

  Scenario: Admin can create an another admin user and delete the user

    Given I am logged in as an admin
    Then browse to users and access page
    And a user with username:"New Admin",email: "newadmin@test.com",password: "one two three four" and user type: Administrator is created
    And confirmation message is displayed as user created successfully
    Then the user:"New Admin" and email:"newadmin@test.com" is displayed on the list of available users
    When I delete the user:"New Admin"
    Then the user:"New Admin" does not exist in the list
    And I logout of florence

  # **********************************************************************  #
                          # SCENARIO - 2 #
  # **********************************************************************  #

  Scenario: Admin can create a publisher user and delete the user

    Given I am logged in as an admin
    Then browse to users and access page
    And a user with username:"New Publisher",email: "newpublisher@test.com",password: "one two three four" and user type: Publisher is created
    And confirmation message is displayed as user created successfully
    Then the user:"New Publisher" and email:"newpublisher@test.com" is displayed on the list of available users
    When I delete the user:"New Publisher"
    Then the user:"New Publisher" does not exist in the list
    And I logout of florence



  # **********************************************************************  #
                          # SCENARIO - 3 #
  # **********************************************************************  #

  Scenario: Admin can create a visualisation publisher and delete the user

    Given I am logged in as an admin
    Then browse to users and access page
    And a user with username:"New Visualisation Publisher",email: "newvisualisationpublisher@test.com",password: "one two three four" and user type: Visualisation_Publisher is created
    And confirmation message is displayed as user created successfully
    Then the user:"New Visualisation Publisher" and email:"newvisualisationpublisher@test.com" is displayed on the list of available users
    When I delete the user:"New Visualisation Publisher"
    Then the user:"New Visualisation Publisher" does not exist in the list
    And I logout of florence

  # **********************************************************************  #
                          # SCENARIO - 4 #
  # **********************************************************************  #

  Scenario: Admin can create a viewer and delete the user

    Given I am logged in as an admin
    Then browse to users and access page
    And a user with username:"New Viewer",email: "newviewer@test.com",password: "one two three four" and user type: Viewer is created
    And confirmation message is displayed as user created successfully
    Then the user:"New Viewer" and email:"newviewer@test.com" is displayed on the list of available users
    When I delete the user:"New Viewer"
    Then the user:"New Viewer" does not exist in the list
    And I logout of florence

  # **********************************************************************  #
                          # SCENARIO - 5 #
  # **********************************************************************  #

  Scenario: Admin can create a team and delete a team

    Given I am logged in as an admin
    Then browse to teams page
    And a team with teamname:"New Team" is created
    Then the team:"New Team" is displayed on the list of available teams
    When I delete the team:"New Team"
    Then the team:"New Team" does not exist in the list
    And I logout of florence

  # **********************************************************************  #
                          # SCENARIO - 6 #
  # **********************************************************************  #

  Scenario: Check Admin have access to all the options

    Given I am logged in as an admin
    Then I should have access to Collections
    And I should have access to Publishing queue
    And I should have access to Reports
    And I should have access to Users and access
    And I should have access to Teams
    And I logout of florence


  # **********************************************************************  #
                          # SCENARIO - 7 #
  # **********************************************************************  #

  Scenario: Admin can create a collection and delete a collection

    Given I am logged in as an admin
    And I create a MANUAL collection type
    And I create a new "Static landing page" and submit for review
    And I delete all the worked on pages in the collection
    When I delete the collection
    Then the collection does not exist
    And I logout of florence















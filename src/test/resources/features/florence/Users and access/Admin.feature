@admin
Feature: Admin - Users and access

  # **********************************************************************  #
                          # SCENARIO - 1 #
  # **********************************************************************  #

  Scenario: Admin can create an another random admin user and delete the user

    Given I am logged in as an admin
    Then browse to users and access page
    And I create a new Administrator user
    And confirmation message is displayed as user created successfully
    Then the user is displayed on the list of available users
    When I delete the user
    Then the user does not exist in the list
    And I logout of florence

  # **********************************************************************  #
                          # SCENARIO - 2 #
  # **********************************************************************  #

  Scenario: Admin can create an another random publisher user and delete the user

    Given I am logged in as an admin
    Then browse to users and access page
    And I create a new Publisher user
    And confirmation message is displayed as user created successfully
    Then the user is displayed on the list of available users
    When I delete the user
    Then the user does not exist in the list
    And I logout of florence


  # **********************************************************************  #
                          # SCENARIO - 3 #
  # **********************************************************************  #

  Scenario: Admin can create an another random visualisation publisher user and delete the user

    Given I am logged in as an admin
    Then browse to users and access page
    And I create a new Visualisation_Publisher user
    And confirmation message is displayed as user created successfully
    Then the user is displayed on the list of available users
    When I delete the user
    Then the user does not exist in the list
    And I logout of florence

  # **********************************************************************  #
                          # SCENARIO - 4 #
  # **********************************************************************  #

  Scenario: Admin can create an another random viewer and delete the user

    Given I am logged in as an admin
    Then browse to users and access page
    And I create a new Viewer user
    And confirmation message is displayed as user created successfully
    Then the user is displayed on the list of available users
    When I delete the user
    Then the user does not exist in the list
    And I logout of florence

  # **********************************************************************  #
                          # SCENARIO - 5 #
  # **********************************************************************  #

  Scenario: Admin can create a team and delete a team

    Given I am logged in as an admin
    Then browse to teams page
    And a new team is created
    And the new team is displayed on the list of available teams
    When I delete the new team
    Then the new team does not exist in the list
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
    And I create a "Static landing page" and submit for review
    And I delete all the worked on pages in the collection
    When I delete the collection
    Then the collection does not exist
    And I logout of florence

  # **********************************************************************  #
                       #  END OF SCENARIOS #
  # **********************************************************************  #


















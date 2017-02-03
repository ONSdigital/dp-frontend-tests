@publisher
Feature: Publisher - Users and access

  # **********************************************************************  #
                          # SCENARIO - 1 #
  # **********************************************************************  #

  Scenario: Check Publisher have access to all the options

    Given I am logged in as a publisher
    Then I should have access to Collections
    And I should have access to Publishing queue
    And I should have access to Reports
    And I should have access to Users and access
    And I should have access to Teams
    And I logout of florence


  # **********************************************************************  #
                          # SCENARIO - 2 #
  # **********************************************************************  #

  Scenario: Publisher cannot create a viewer/any user

    Given I am logged in as a publisher
    Then browse to users and access page
    And I create a new Viewer user
    Then I should see the text "You are not permitted to create users." on the pop-up
    And I logout of florence


   # **********************************************************************  #
                          # SCENARIO - 3 #
  # **********************************************************************  #

  Scenario: Publisher cannot create a team

    Given I am logged in as a publisher
    Then browse to teams page
    And a new team is created
    Then I should see the text "You are not permitted to create teams." on the pop-up
    And I logout of florence

  # **********************************************************************  #
                          # SCENARIO - 4 #
  # **********************************************************************  #

  Scenario: Publisher create a collection and another publisher view and delete the same collection

    Given I am logged in as a publisher
    And I create a MANUAL collection type
    And I click on Create/edit button
    And I create a "Static landing page" and submit for review
    And I logout of florence
    Given I am logged in as a lead publisher
    And I select the collection
    Then I delete all the worked on pages in the collection
    When I delete the collection
    Then the collection does not exist
    Then I logout of florence

   # **********************************************************************  #
                       #  END OF SCENARIOS #
  # **********************************************************************  #




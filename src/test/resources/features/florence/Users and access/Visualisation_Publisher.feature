@visualisation_publisher
Feature: Visualisation Publisher - Users and access

  # **********************************************************************  #
                          # SCENARIO - 1 #
  # **********************************************************************  #

  Scenario: Check Visualisation Publisher access to other options

    Given I am logged in as a visualisation publisher
    And I should have access to Collections
    And I should have access to Publishing queue
    And I logout of florence


  # **********************************************************************  #
                          # SCENARIO - 2 #
  # **********************************************************************  #

  Scenario: Visualisation Publisher create a collection and another visualisation publisher view and delete the same collection

    Given I am logged in as a visualisation publisher
    And I create a MANUAL collection type
    And I click on Create/edit button
    And upload visulisation and submit for review
    And I logout of florence
    Given I am logged in as an another visualisation publisher
    And I select the collection
    Then I delete all the worked on pages in the collection
    When I delete the collection
    Then the collection does not exist
    Then I logout of florence

   # **********************************************************************  #
                       #  END OF SCENARIOS #
  # **********************************************************************  #
    



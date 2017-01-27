@viewer
Feature: Viewer - Users and access

  # **********************************************************************  #
                          # SCENARIO - 1 #
  # **********************************************************************  #

  Scenario: Check Viewer access to other options in Ermintrude Website

    Given I am logged into Ermintrude website as a viewer
    Then I should have access to Collections
    And I logout of florence

  # **********************************************************************  #
                          # SCENARIO - 2 #
  # **********************************************************************  #

  Scenario: Viewer unable to access preview website

    Given I am logged in as a viewer into florence website
    Then I should see the text "You do not have the permissions to enter here. Please contact an administrator" on the pop-up

    # **********************************************************************  #
                       #  END OF SCENARIOS #
  # **********************************************************************  #








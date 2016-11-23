Feature: Viewer - Users and access

  # **********************************************************************  #
                          # SCENARIO - 1 #
  # **********************************************************************  #

  Scenario: Check Viewer access to other options in Ermintrude Website

    Given I am on the "Ermintrude" Website
    # Login as viewer
    When I enter "viewer@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    # Check collections access
    When I click on "Collections" link
    Then I should see the text "Select a collection"
    # Check Logout access
    When I click on "Logout" link
    Then I should see the text "Login"

  # **********************************************************************  #
                          # SCENARIO - 2 #
  # **********************************************************************  #

  Scenario: Viewer unable to access preview website

    Given I am on the Florence HomePage
    # Login as viewer
    When I enter "viewer@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should see the text "You do not have the permissions to enter here. Please contact an administrator"







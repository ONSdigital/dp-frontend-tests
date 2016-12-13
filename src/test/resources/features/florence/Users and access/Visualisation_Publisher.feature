Feature: Visualisation Publisher - Users and access

  # **********************************************************************  #
                          # SCENARIO - 1 #
  # **********************************************************************  #

  Scenario: Check Visualisation Publisher access to other options

    Given I am on the Florence HomePage
  # Login as visualisation publisher
    When I enter "visualisationpublisher@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section
    # Check collections access
    When I click on "Collections" link
    Then I should see the text "Select a collection"
    And I should see the text "Create a collection"
    # Check Publishing queue access
    When I click on "Publishing queue" link
    Then I should see the text "Select a publish date"
    # Check Logout access
    When I click on "Logout" link
    Then I should see the text "Login"

  # **********************************************************************  #
                          # SCENARIO - 2 #
  # **********************************************************************  #

  Scenario: Visualisation Publisher create a collection and another visualisation publisher view and delete the same collection

    Given I am on the Florence HomePage
  # Login as visualisation publisher
    When I enter "visualisationpublisher@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    # Create a manual collection
    When I enter "Visualisation Publisher Collection" in the Collection name field
    And I select Manual publish radio button
    And I click "Create collection" button
    #Then I should be on the Working on Collection section
    Then I should see the text "visualisations"
    When I click "Upload visualisation" button

    And I select "Visualisation" from the Select your option dropdown
    And I enter "DVC126" in the Unique ID field

    And I enter "Visualisation Publisher Page" in the Page name field
    And I click "Create page" button

    And I click "Save and submit for review" button

    Then I should see the text "1 pages awaiting review"

    And I should see the text "Visualisation Publisher Collection" in the list of collections

    And I click on "Logout" link

    Given I am on the Florence HomePage
  # Login as another visualisation publisher
    When I enter "visualisationpublisher2@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    And I should see the text "Visualisation Publisher Collection" in the list of collections

    # Delete a manual collection

    When I click on "Visualisation Publisher Collection" collection

    And I click on the visualisation publisher page awaiting review

    And I click "Delete file" button

    Then I should see the text "Are you sure you want to delete this page from the collection?"

    And I click "Delete" button

    And I click "OK" button

    And I click "Delete collection" button

    Then I should see the text "Are you sure you want to delete this collection?"

    And I click "Continue" button

    And I click "OK" button

    Then I should not see the "Visualisation Publisher Collection" collection

    And I click on "Logout" link

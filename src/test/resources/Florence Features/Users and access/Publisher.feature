Feature: Publisher - Users and access

  # **********************************************************************  #
                          # SCENARIO - 1 #
  # **********************************************************************  #

  Scenario: Check Publisher have access to all the options

    Given I am on the Florence HomePage
  # Login as publisher
    When I enter "publisher@test.com" in the Email field
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
    # Check Reports access
    When I click on "Reports" link
    Then I should see the text "Select a collection"
    # Check Users and access access
    When I click on "Users and access" link
    Then I should see the text "Select a user"
    And I should see the text "Create a user"
    # Check Teams access
    When I click on "Teams" link
    Then I should see the text "Select a team"
    And I should see the text "Create a team"
    # Check Logout access
    When I click on "Logout" link
    Then I should see the text "Login"

  # **********************************************************************  #
                          # SCENARIO - 2 #
  # **********************************************************************  #

  Scenario: Publisher cannot create a viewer/any user

    Given I am on the Florence HomePage
  # Login as publisher
    When I enter "publisher@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    When I click on "Users and access" link
    Then I should see the text "Create a user"
  # Create a viewer
    When I enter "New Viewer" in the Username field
    And I enter "newviewer@test.com" in the Create a user Email field
    And I enter "one two three four" in the Create a user Password field
    And I select Viewer radio button
    And I click "Create user" button
    Then I should see the text "You are not permitted to create users." on the pop-up
    And I click "OK" button
    And I click on "Logout" link

   # **********************************************************************  #
                          # SCENARIO - 3 #
  # **********************************************************************  #

  Scenario: Publisher cannot create a team

    Given I am on the Florence HomePage
  # Login as publisher
    When I enter "publisher@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    When I click on "Teams" link
    Then I should see the text "Create a team"
    # Create a New Team
    When I enter "New Team" in the Team Name field
    And I click "Create team" button
    Then I should see the text "You are not permitted to create teams." on the pop-up
    And I click "OK" button
    And I click on "Logout" link

  # **********************************************************************  #
                          # SCENARIO - 4 #
  # **********************************************************************  #

  Scenario: Publisher create a collection and another publisher view and delete the same collection

    Given I am on the Florence HomePage
  # Login as publisher
    When I enter "publisher@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    # Create a manual collection
    When I enter "Publisher Collection" in the Collection name field
    And I select Manual publish radio button
    And I click "Create collection" button
    #Then I should be on the Working on Collection section

    When I click "Create" button

    Then I should see the text "New page details"
    And I select "Static landing page" from the New page type dropdown
    And I enter "Publisher Page" in the Page name field
    And I click "Create page" button

    And I click "Save and submit for review" button

    Then I should see the text "1 pages awaiting review"

    And I should see the text "Publisher Collection" in the list of collections

    And I click on "Logout" link

    Given I am on the Florence HomePage
  # Login as another publisher
    When I enter "publisher2@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    And I should see the text "Publisher Collection" in the list of collections

    # Delete a manual collection

    When I click on "Publisher Collection" collection
    And I click on the page awaiting review

    And I click "Delete file" button

    Then I should see the text "Are you sure you want to delete this page from the collection?"

    And I click "Delete" button

    And I click "OK" button

    And I click "Delete collection" button

    Then I should see the text "Are you sure you want to delete this collection?"

    And I click "Continue" button

    And I click "OK" button

    Then I should not see the "Publisher Collection" collection

    And I click on "Logout" link




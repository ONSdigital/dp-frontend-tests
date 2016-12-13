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
    And a user with username:"New Viewer",email: "newviewer@test.com",password: "one two three four" and user type: Viewer is created
    Then I should see the text "You are not permitted to create users." on the pop-up
    And I logout of florence


   # **********************************************************************  #
                          # SCENARIO - 3 #
  # **********************************************************************  #

  Scenario: Publisher cannot create a team

    Given I am logged in as a publisher
    Then browse to teams page
    And a team with teamname:"New Team" is created
    Then I should see the text "You are not permitted to create teams." on the pop-up
    And I logout of florence

  # **********************************************************************  #
                          # SCENARIO - 4 #
  # **********************************************************************  #

  Scenario: Publisher create a collection and another publisher view and delete the same collection

    Given I am logged in as a publisher
    And I create a MANUAL collection type
    And I create a new "Static landing page" and submit for review
    And I logout of florence
    Given I am logged in as a lead publisher
    And I select the collection
    Then I delete all the worked on pages in the collection
    When I delete the collection
    Then the collection does not exist
    Then I logout of florence





#    Given I am on the Florence HomePage
#  # Login as publisher
#    When I enter "publisher@test.com" in the Email field
#    And I enter "one two three four" in the Password field
#    And I click "Log in" button
#    Then I should be on the collections section
#
#    # Create a manual collection
#    When I enter "Publisher Collection" in the Collection name field
#    And I select Manual publish radio button
#    And I click "Create collection" button
#    #Then I should be on the Working on Collection section
#
#    When I click "Create" button
#
#    Then I should see the text "New page details"
#    And I select "Static landing page" from the New page type dropdown
#    And I enter "Publisher Page" in the Page name field
#    And I click "Create page" button
#
#    And I click "Save and submit for review" button
#
#    Then I should see the text "1 pages awaiting review"
#
#    And I should see the text "Publisher Collection" in the list of collections
#
#    And I click on "Logout" link
#
#    Given I am on the Florence HomePage
#  # Login as another publisher
#    When I enter "publisher2@test.com" in the Email field
#    And I enter "one two three four" in the Password field
#    And I click "Log in" button
#    Then I should be on the collections section
#
#    And I should see the text "Publisher Collection" in the list of collections
#
#    # Delete a manual collection
#
#    When I click on "Publisher Collection" collection
#    And I click on the page awaiting review
#
#    And I click "Delete file" button
#
#    Then I should see the text "Are you sure you want to delete this page from the collection?"
#
#    And I click "Delete" button
#
#    And I click "OK" button
#
#    And I click "Delete collection" button
#
#    Then I should see the text "Are you sure you want to delete this collection?"
#
#    And I click "Continue" button
#
#    And I click "OK" button
#
#    Then I should not see the "Publisher Collection" collection
#
#    And I click on "Logout" link




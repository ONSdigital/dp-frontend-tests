Feature: Admin - Users and access

  # **********************************************************************  #
                          # SCENARIO - 1 #
  # **********************************************************************  #

  Scenario: Admin can create an another admin user and delete the user

    Given I am on the Florence HomePage
  # Login as admin
    When I enter "testuser@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    When I click on "Users and access" link
    Then I should see the text "Create a user"
  # Create an admin User
    When I enter "New Admin" in the Username field
    And I enter "newadmin@test.com" in the Create a user Email field
    And I enter "one two three four" in the Create a user Password field
    And I select Administrator radio button
    And I click "Create user" button
    Then I should see the text "User 'newadmin@test.com' has been created" on the pop-up
    And I click "OK" button
  # Confirming that new user was added to the list of users
    Then I should see the text "New Admin" in the list of users
    And I should see the text "newadmin@test.com" in the list of users

   # Delete an Admin User

    When I select "New Admin" in the Select a user Table

    And I click "Delete user" button

    Then I should see the text "Please enter the email address of the user you want to delete"

    And I enter "newadmin@test.com" in the Confirm deletion pop-up text box

    And I click "Delete" button

    And I click "OK" button

  # **********************************************************************  #
                          # SCENARIO - 2 #
  # **********************************************************************  #

  Scenario: Admin can create a publisher user and delete the user

    Given I am on the Florence HomePage
  # Login as admin
    When I enter "testuser@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    When I click on "Users and access" link
    Then I should see the text "Create a user"
  # Create an Publisher User
    When I enter "New Publisher" in the Username field
    And I enter "newpublisher@test.com" in the Create a user Email field
    And I enter "one two three four" in the Create a user Password field
    And I select Publisher radio button
    And I click "Create user" button
    Then I should see the text "User 'newpublisher@test.com' has been created" on the pop-up
    And I click "OK" button
  # Confirming that new user was added to the list of users
    Then I should see the text "New Publisher" in the list of users
    And I should see the text "newpublisher@test.com" in the list of users

   # Delete a Publisher User

    When I select "New Publisher" in the Select a user Table

    And I click "Delete user" button

    Then I should see the text "Please enter the email address of the user you want to delete"

    And I enter "newpublisher@test.com" in the Confirm deletion pop-up text box

    And I click "Delete" button

    And I click "OK" button

  # **********************************************************************  #
                          # SCENARIO - 3 #
  # **********************************************************************  #

  Scenario: Admin can create a visualisation publisher and delete the user

    Given I am on the Florence HomePage
  # Login as admin
    When I enter "testuser@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    When I click on "Users and access" link
    Then I should see the text "Create a user"
  # Create an Visualisation Publisher User
    When I enter "New Visualisation Publisher" in the Username field
    And I enter "newvisualisationpublisher@test.com" in the Create a user Email field
    And I enter "one two three four" in the Create a user Password field
    And I select Visualisation publisher radio button
    And I click "Create user" button
    Then I should see the text "User 'newvisualisationpublisher@test.com' has been created" on the pop-up
    And I click "OK" button
  # Confirming that new user was added to the list of users
    Then I should see the text "New Visualisation Publisher" in the list of users
    And I should see the text "newvisualisationpublisher@test.com" in the list of users

   # Delete a Visualisation Publisher User

    When I select "New Visualisation Publisher" in the Select a user Table

    And I click "Delete user" button

    Then I should see the text "Please enter the email address of the user you want to delete"

    And I enter "newvisualisationpublisher@test.com" in the Confirm deletion pop-up text box

    And I click "Delete" button

    And I click "OK" button

  # **********************************************************************  #
                          # SCENARIO - 4 #
  # **********************************************************************  #

  Scenario: Admin can create a viewer and delete the user

    Given I am on the Florence HomePage
  # Login as admin
    When I enter "testuser@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    When I click on "Users and access" link
    Then I should see the text "Create a user"
  # Create a Viewer User
    When I enter "New Viewer" in the Username field
    And I enter "newviewer@test.com" in the Create a user Email field
    And I enter "one two three four" in the Create a user Password field
    And I select Viewer radio button
    And I click "Create user" button
    Then I should see the text "User 'newviewer@test.com' has been created" on the pop-up
    And I click "OK" button
  # Confirming that new user was added to the list of users
    Then I should see the text "New Viewer" in the list of users
    And I should see the text "newviewer@test.com" in the list of users

   # Delete a Viewer User

    When I select "New Viewer" in the Select a user Table

    And I click "Delete user" button

    Then I should see the text "Please enter the email address of the user you want to delete"

    And I enter "newviewer@test.com" in the Confirm deletion pop-up text box

    And I click "Delete" button

    And I click "OK" button

  # **********************************************************************  #
                          # SCENARIO - 5 #
  # **********************************************************************  #

  Scenario: Admin can create a team and delete a team

    Given I am on the Florence HomePage
# Login as admin
    When I enter "testuser@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    When I click on "Teams" link
    Then I should see the text "Create a team"
# Create a New Team
    When I enter "New Team" in the Team Name field
    And I click "Create team" button
    Then I should see the text "New Team"

# Confirming that new user was added to the list of users
    Then I should see the text "New Team" in the list of teams

 # Delete a team

    And I select "New Team" in the Select a team Table
    When I click "Delete team" button
    Then I should see the text "Please enter the name of the team you want to delete"
    And I enter "New Team" in the Confirm deletion pop-up text box
    And I click "Delete" button
    And I click "OK" button

  # **********************************************************************  #
                          # SCENARIO - 6 #
  # **********************************************************************  #

  Scenario: Check Admin have access to all the options

    Given I am on the Florence HomePage
    # Login as admin
    When I enter "testuser@test.com" in the Email field
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
                          # SCENARIO - 7 #
  # **********************************************************************  #

  Scenario: Admin can create a collection and delete a collection

    Given I am on the Florence HomePage
    # Login as admin
    When I enter "testuser@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section
    # Create a manual collection
    When I enter "Admin Collection" in the Collection name field
    And I select Manual publish radio button
    And I click "Create collection" button
    #Then I should be on the Working on Collection section

    When I click "Create" button

    Then I should see the text "New page details"
    And I select "Static landing page" from the New page type dropdown
    And I enter "Admin Page" in the Page name field
    And I click "Create page" button

    And I click "Save and submit for review" button

    Then I should see the text "1 pages awaiting review"

    And I should see the text "Admin Collection" in the list of collections
    # Delete a manual collection

    When I click on "Admin Collection" collection

    And I click on the page awaiting review

    And I click "Delete file" button

    Then I should see the text "Are you sure you want to delete this page from the collection?"

    And I click "Delete" button

    And I click "OK" button

    And I click "Delete collection" button

    Then I should see the text "Are you sure you want to delete this collection?"

    And I click "Continue" button

    And I click "OK" button

    Then I should not see the "Admin Collection" collection

    And I click on "Logout" link











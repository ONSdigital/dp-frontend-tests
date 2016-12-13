Feature: Create a published schedule collection

  Scenario: Create and publish a schedule collection
    Given I am logged in as an admin
    And browse to users and access page
    When a user with username:"New User",email: "newuser@test.com",password: "one two three four" and user type: Viewer is created
    Then the user:"New User" and email:"newuser@test.com" is displayed on the list of available users

  Scenario: Delete the user
    Given I am logged in as an admin
    And browse to users and access page
    When I delete the user:"New User"
    Then the user:"New User" does not exist in the list

#  Scenario: Create a new random user
#    Given I am logged in as an admin
#    And browse to users and access page
#    When I create a new user
#    Then the user is displayed on the list of available users


#  Scenario: Create a user, team and schedule publish a collection
#
#    Given I am on the Florence HomePage
#    When I enter "testuser@test.com" in the Email field
#    And I enter "one two three four" in the Password field
#    And I click "Log in" button
#    Then I should be on the collections section
#
#    When I click on "Users and access" link
#    Then I should see the text "Create a user"
#    # Create a User
#    When I enter "New User" in the Username field
#    And I enter "newuser@test.com" in the Create a user Email field
#    And I enter "one two three four" in the Create a user Password field
#    And I select Viewer radio button
#    And I click "Create user" button
#    #Then I should see the text "User 'newuser@test.com' has been created"
#    And I click "OK" button
#
#    Then I should see the text "New User" in the list of users
#    And I should see the text "newuser@test.com" in the list of users
#
#    When I click on "Teams" link
#    Then I should see the text "Create a team"
#     # Create a Team
#    When I enter "Test Team" in the Team Name field
#    And I click "Create team" button
#    Then I should see the text "Test Team"
#     # Add the user to the team
#    When I click "Add/remove members" button
#    And I enter "newuser@test.com" in the Search for a user field
#    And I click "Add" button
#
#    Then the user "newuser@test.com" should be added to the team
#    And I click "Done" button
#
#     # Create a collection for scheduled publish
#    When I click on "Collections" link
#    Then I should see the text "Create a collection"
#    When I enter "Scheduled Publish Collection" in the Collection name field
#
#    And I select "Test Team" from the Select the team the collection can be previewed by dropdown
#    And I select Scheduled publish radio button
#    And I select Custom schedule radio button
#
#    And I enter "Tomorrows Date" in the Date field
#    And I select "10" from the Hour dropdown
#    And I select "30" from the Minute dropdown
#
#    And I click "Create collection" button
#
#    When I click on "Census" page
#    And I click "Create" button in Census
#    Then I should see the text "New page details"
#    And I select "Static landing page" from the New page type dropdown
#    And I enter "2021 Census" in the Page name field
#    And I click "Create page" button
#
#    Then I should see the text "Metadata"
#    And I click "Metadata" button
#
#    And I should see the text "2021 Census" in "Title" section
#    And I enter "This is summary page of 2021 Census" in the Summary field
#    And I enter "census" in the Keywords field
#    And I enter "This is Meta description of 2021 Census" in the Meta description field
#
#    And I click "Save and submit for review" button
#    Then I should see the text "1 pages awaiting review"
#    And I should see the text "2021 Census"
#    And I click on "Logout" link
#    # Log in as Viewer and change password
#    When I navigate to "Ermintrude" Website
#    And I enter "newuser@test.com" in the Email field
#    And I enter "one two three four" in the Password field
#    And I click "Log in" button
#    Then I should see the text "Change password"
#    And I enter "one two three four" in the Current password field
#    And I enter "two three four five" in the New password field
#    And I enter "two three four five" in the Confirm new password field
#    And I click "Update password" button
#    Then I should see the text "Password updated"
#    And I click "OK" button
#
#    Then I should see the text "Select a collection"
#
#    When I select "Scheduled Publish Collection" in the Collections Table
#
#    And I select "2021 Census" from the Select a document to view dropdown
#
#    Then I should see the text "2021 Census"
#    And I click on "Logout" link
#
#    # Log back as admin
#    When I navigate to "Florence" Website
#
#    When I enter "testuser@test.com" in the Email field
#    And I enter "one two three four" in the Password field
#    And I click "Log in" button
#    Then I should be on the collections section
#
#    When I click on "Users and access" link
#    Then I should see the text "Create a user"
#
#     # Delete a Team
#    When I click on "Teams" link
#    Then I should see the text "Create a team"
#
#    When I select "Test Team" in the Select a team Table
#    Then I should see the text "newuser@test.com"
#
#    When I click "Delete team" button
#
#    Then I should see the text "Please enter the name of the team you want to delete"
#
#    And I enter "Test Team" in the Confirm deletion pop-up text box
#
#    And I click "Delete" button
#
#    And I click "OK" button
#
#    # Delete a User
#    When I click on "Users and access" link
#
#    When I select "New User" in the Select a user Table
#
#    And I click "Delete user" button
#
#    Then I should see the text "Please enter the email address of the user you want to delete"
#
#    And I enter "newuser@test.com" in the Confirm deletion pop-up text box
#
#    And I click "Delete" button
#
#    And I click "OK" button
#
#    # Delete the scheduled collection
#
#    When I click on "Collections" link
#
#    When I click on "Scheduled Publish Collection" collection
#
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
#    Then I should not see the "Scheduled Publish Collection" collection
#
#    And I click on "Logout" link
#










    

























    




































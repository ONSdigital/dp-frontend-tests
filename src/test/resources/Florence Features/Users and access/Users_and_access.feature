Feature: End to end tests related to Authentication/Encryption

  Scenario: Publisher create a collection and viewer views the same collection

    Given I am on the Florence HomePage
    # Login as admin
    When I enter "testuser@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    When I click on "Teams" link
    Then I should see the text "Create a team"

    # Create a Labour Market Team
    When I enter "Labour Market Team" in the Team Name field
    And I click "Create team" button
    Then I should see the text "Labour Market Team"

    # Add viewer to Labour Market Team
    When I click "Add/remove members" button
    And I enter "viewer@test.com" in the Search for a user field
    And I click "Add" button

    Then the user "viewer@test.com" should be added to the team
    And I click "Done" button

    And I click on "Logout" link

    # Login as publisher
    When I enter "publisher@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section
    # Create a collection for scheduled publish
    When I enter "Labour Market Collection" in the Collection name field

    And I select "Labour Market Team" from the Select the team the collection can be previewed by dropdown
    And I select Scheduled publish radio button
    And I select Custom schedule radio button

    And I enter "Tomorrows Date" in the Date field
    And I select "10" from the Hour dropdown
    And I select "30" from the Minute dropdown

    And I click "Create collection" button

    When I click on "Census" page
    And I click "Create" button in Census
    Then I should see the text "New page details"
    And I select "Static landing page" from the New page type dropdown
    And I enter "Unemployment in Wales" in the Page name field
    And I click "Create page" button

    Then I should see the text "Metadata"
    And I click "Metadata" button

    And I should see the text "Unemployment in Wales" in "Title" section
    And I enter "This is summary page of Unemployment in Wales" in the Summary field
    And I enter "census" in the Keywords field
    And I enter "This is Meta description of Unemployment in Wales" in the Meta description field

    And I click "Save and submit for review" button
    Then I should see the text "1 pages awaiting review"
    And I should see the text "Unemployment in Wales"
    And I click on "Logout" link
    # Log in as Viewer and change password
    When I navigate to "Ermintrude" Website
    And I enter "viewer@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should see the text "Select a collection"

    When I select "Labour Market Collection" in the Collections Table

    And I select "Unemployment in Wales" from the Select a document to view dropdown

    Then I should see the text "Unemployment in Wales"
    And I click on "Logout" link

    # Log back as admin
    When I navigate to "Florence" Website

    When I enter "testuser@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    When I click on "Users and access" link
    Then I should see the text "Create a user"

     # Delete a Team
    When I click on "Teams" link
    Then I should see the text "Create a team"

    When I select "Labour Market Team" in the Select a team Table
    Then I should see the text "viewer@test.com"

    When I click "Delete team" button

    Then I should see the text "Please enter the name of the team you want to delete"

    And I enter "Labour Market Team" in the Confirm deletion pop-up text box

    And I click "Delete" button

    And I click "OK" button

    # Delete the scheduled collection

    When I click on "Collections" link

    When I click on "Labour Market Collection" collection

    And I click on the page awaiting review

    And I click "Delete file" button

    Then I should see the text "Are you sure you want to delete this page from the collection?"

    And I click "Delete" button

    And I click "OK" button

    And I click "Delete collection" button

    Then I should see the text "Are you sure you want to delete this collection?"

    And I click "Continue" button

    And I click "OK" button

    Then I should not see the "Labour Market Collection" collection

    And I click on "Logout" link













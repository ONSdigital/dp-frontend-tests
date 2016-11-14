Feature: Check a collection in florence website
  As a publish support team member
  I need to create a manual collection
  So that customer can view in ONS Website


  Scenario: Create a manual publish collection

    Given I am on the Florence HomePage
    When I enter "testuser@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    When I enter "Test Manual Publish Collection" in the Collection name field
    And I select Manual publish radio button
    And I click "Create collection" button

    Then I should be on the Working on Collection section

    When I click on "About us" static landing page

    And I click on "Edit" option

    And I click "Content" button

    And click on Edit button in Content section

    And I enter "ONS Stands for Office for national statistics. " in the Markdown editor field
    And I click "Save changes and exit" button

    And I click "Save and submit for review" button

    Then I should see the text "1 pages awaiting review"

    And I click on "Logout" link

    When I enter "automationtester@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    When I click on "Test Manual Publish Collection" collection

    And I click on the page awaiting review

    And I click "Review file" button

    And click on Edit button in Content section

    Then I should see the text "ONS Stands for Office for national statistics. " in "Markdown editor" section

    And I click "Save changes and exit" button

    And I click "Save and submit for approval" button

    Then I should see the text "1 pages awaiting approval"

    When I click "Approve collection" button

    Then a "manual collection" should be shown in "Publishing queue"

    And I should see the text "The following collection has been approved"

    When I click on "Test Manual Publish Collection" collection

    Then I should see the text "Approved pages in this collection"

    And I should see the text "About us"

    When I click "Publish collection" button

    Then I should see the text "Published!"

    And I should see the text "Your collection has successfully published"

    And I click "OK" button

    And I click on "Logout" link

    When I navigate to "ONS" Website

    And I click on "About" link

    Then I should be on the About us page

    Then I should see the text "ONS Stands for Office for national statistics." on the bottom of the page




















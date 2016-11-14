Feature: Content designer creates a content page to publish to the release calendar
  As a publish support team member
  I need to create a content page
  So that i can publish to the release calendar


  Scenario: Content designer navigates to "Browse" tab in Florence


    Given I am on the Florence HomePage
    When I enter "testuser@test.com" in the Email field
    And I enter "one two three four" in the Password field
    And I click "Log in" button
    Then I should be on the collections section

    When I enter "Release Calendar" in the Collection name field
    And I select Manual publish radio button
    And I click "Create collection" button

    Then I should be on the Working on Collection section

    Then I should be directed to "Browse" tab in Florence by default
    And Presented with "Edit" button 
    And Presented with "Create" button 
    And The web preview is displayed

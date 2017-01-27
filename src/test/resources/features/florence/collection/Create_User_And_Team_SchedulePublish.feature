@schedule_collection
Feature: Create a published schedule collection

  Scenario: Create and publish a schedule collection
    Given I am logged in as an admin
    And browse to users and access page
    And I create a new Viewer user
    Then the user is displayed on the list of available users
    And browse to users and access page
    When I delete the user
    Then the user:"New User" does not exist in the list
    Then I logout of florence


  Scenario: Create a user, team and schedule publish a collection

    Given I am logged in as an admin
    And browse to users and access page
    And I create a new Viewer user
    And browse to teams page
    And a new team is created
    And add the new user to the team
    And I create a SCHEDULED_CUSTOM collection type
    And I browse to the content businessindustryandtrade under collections
    And I click on Edit button
    And I enter keywords metadata and save for review
    Then browse to users and access page
    And I delete the user
    Then browse to teams page
    When I delete the new team
    And I select the collection
    Then I delete all the worked on pages in the collection
    When I delete the collection
    Then I logout of florence













    

























    




































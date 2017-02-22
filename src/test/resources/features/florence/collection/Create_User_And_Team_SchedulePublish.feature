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
    And I click on Create/edit button
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


  Scenario: Scheduled publish should begin at the scheduled time


    Given I am logged in as an admin
    And browse to teams page
    And a new team is created
    Then I logout of florence

    Given I am logged in as a publisher
    And I create a SCHEDULED_CUSTOM collection type
    And I click on Create/edit button
    And I browse to the content help under collections
    And I click on Create button
    And I create a "Static landing page" and submit for review
    Then I logout of florence
    And I am logged in as a lead publisher
    And I select the collection
    Then I review the files awaiting review with data-url:help/random page
    And I approve the collection
    When I click on publishing queue and publish scheduled collection
    Then I logout of florence
    Given I navigate to the ONS Website
    And I browse to help/random page on the ONS
    Then the ONS website does contain the new changes












    

























    




































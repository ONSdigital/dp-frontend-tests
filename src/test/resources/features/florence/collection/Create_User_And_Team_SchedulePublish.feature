Feature: Create a published schedule collection

  Scenario: Create and publish a schedule collection
    Given I am logged in as an admin
    And browse to users and access page
    When a user with username:"New User",email: "newuser@test.com",password: "one two three four" and user type: Viewer is created
    Then the user:"New User" and email:"newuser@test.com" is displayed on the list of available users
    And browse to users and access page
    When I delete the user:"New User"
    Then the user:"New User" does not exist in the list


  Scenario: Create a user, team and schedule publish a collection

    Given I am logged in as an admin
    And browse to users and access page
    And a user with username:"New User",email: "newuser@test.com",password: "one two three four" and user type: Viewer is created
    And browse to teams page
    And a team with teamname:"Test Team" is created
    And add a user newuser@test.com to the team
    And I create a SCHEDULED_CUSTOM collection type
    And I browse to the content businessindustryandtrade under collections
    And I click on Edit button
    And I enter keywords metadata and save for review
    Then browse to users and access page
    And I delete the user:"New User"
    Then browse to teams page
    When I delete the team:"Test Team"
    And I select the collection
    Then I delete all the worked on pages in the collection
    When I delete the collection
    Then I logout of florence













    

























    




































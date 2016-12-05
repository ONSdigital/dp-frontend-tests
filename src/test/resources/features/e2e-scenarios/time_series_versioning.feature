Feature: End to End time series versioning tests

  Scenario: Creating a time series collection

    Given I am logged in as an admin
    And I create a MANUAL collection type
    And I navigate to "Economy"
    Then I log out of florence

  Scenario: Review, approve and publish the collection

    Given I am logged in as a lead publisher
    When I select the collection
    And I review the files awaiting review
    And I approve the collection
    When I click on publishing queue and publish collection
    Then I log out of florence

  Scenario: Verify the collection on ONS Website

  Scenario: Create and Delete a collection
    Given I am logged in as an admin
    And I create a MANUAL collection type
    And I navigate to "Economy"
    And I select the collection
    And I delete all the worked on pages in the collection
    And I delete the collection
    Then I log out of florence









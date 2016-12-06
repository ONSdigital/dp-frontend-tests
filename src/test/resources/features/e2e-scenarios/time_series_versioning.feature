Feature: End to End time series versioning tests

  Scenario: Creating and publishing a time series collection
    Given I am logged in as an admin
    And I create a MANUAL collection type
    And I navigate to Economy
    Then I log out of florence
    Then I am logged in as a lead publisher
    When I select the collection
    And I review the files awaiting review
    And I approve the collection
    When I click on publishing queue and publish collection
    Then I log out of florence

    Then I am on the ONS Website
    When I search for "cxnv" timeseries dataset
    When I navigate to Business Investment time series dataset
    And I click the previous versions
    Then I should see the new time series dataset


  Scenario: Create and Delete a collection
    Given I am logged in as an admin
    And I create a MANUAL collection type
    And I navigate to Economy
    And I select the collection
    And I delete all the worked on pages in the collection
    And I delete the collection
    Then I log out of florence













Feature: End to End time series versioning tests

    Background:
        Given I am logged in as an admin
        And I delete the collection:TimeSeriesVersioningssss
        Then I log out of florence

    Scenario: Creating a time series collection

        Given I am logged in as a publisher
        And I create a collection:TimeSeriesVersioningssss
        And I navigate to "Economy"
        Then I log out of florence

    Scenario: Review, approve and publish the collection

        Given I am logged in as a lead publisher
        When I select "TimeSeriesVersioningssss" collection
        And I review the files awaiting review
        And I Approve the collection
        When I click on Publishing queue and publish collection
        Then I log out of florence

    Scenario: Verify the collection on ONS Website





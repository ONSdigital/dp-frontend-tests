@release_calendar
Feature:
  Create and publish a release calendar

  Scenario: Verify that the release calendar entry can be published successfully
    Given I am logged in as a publisher
    And I create a MANUAL collection type
    And create a new calendar entry
    And add the following details to the calendary entry
      | image | contactName | contactEmail       | telephone   |
      | true  | QA Tester   | ptestuser@test.com | 02920000000 |
    Then I logout of florence
    And I am logged in as a lead publisher
    And I select the collection
    And I review the calendar entry files awaiting review
    Then I approve the collection
    When I click on publishing queue and publish collection
    Then I logout of florence
    When I navigate to the ONS Website
    And click on UPCOMING release calendar
    And search for the release with keyword, published after and published before dates
    Then search results contains the release information
    Then verify the release information


  Scenario: Publish release calendar without email and ONS image
    Given I am logged in as a publisher
    And I create a MANUAL collection type
    And create a new calendar entry
    And add the following details to the calendary entry
      | image | contactName | telephone   |
      | false | QA Tester   | 02920000000 |
    Then I logout of florence
    And I am logged in as a lead publisher
    And I select the collection
    And I review the calendar entry files awaiting review
    Then I approve the collection
    When I click on publishing queue and publish collection
    Then I logout of florence
    When I navigate to the ONS Website
    And click on UPCOMING release calendar
    And search for the release with keyword, published after and published before dates
    Then search results contains the release information
    Then verify the release information
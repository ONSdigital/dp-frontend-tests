@searchindex_updates
Feature: Search Index Updates
  Any published content in florence should publish in ONS Website and update seach indexes

  Scenario: Publishing content should update search indexes

    Given I am logged in as a publisher
    And I create a MANUAL collection type
    And I click on Create/edit button
    And I browse to the content aboutus/transparencyandgovernance/freedomofinformationfoi under collections
    And create a new FOI entry
    And add the following details to the FOI entry
      | keywords | metaDescription | markdownText |
      | foi      | foi description | some text    |
    Then I logout of florence
    And I am logged in as a lead publisher
    And I select the collection

    And I review the foiEntry file awaiting review with data url aboutus/transparencyandgovernance/freedomofinformationfoi
    And I approve the collection
    When I click on publishing queue and publish collection
    Then I logout of florence

    # Navigate to the website to see the page exist

    Then I navigate to the ONS Website
    And I navigate to aboutus/transparencyandgovernance/freedomofinformationfoi/ on the ONS Website
    Then the ONS website does contain the FOI changes
    # To make sure page showing in search results/indexes
    When I search for the changes in the ONS Website
#    And I click on search result
#    Then the ONS website does contain the FOI changes


  Scenario: Publishing release calendar items should update the release calendar

    Given I am logged in as a publisher
    And I create a MANUAL collection type
    And I click on Create/edit button

    And I browse to the releases content under collections

    And create a new release calendar entry and submit for review

    Then I logout of florence

    Given I am logged in as a lead publisher
    And I select the collection
    And I review the calendar entry files awaiting review
    Then I approve the collection
    When I click on publishing queue and publish collection
    Then I logout of florence

    When I navigate to the ONS Website
    And click on UPCOMING release calendar
    And search for the release with keyword, published after and published before dates
    Then search results contains the release information

    # Now create a release calendar entry to an existing release
    Given I am logged in as a publisher
    And I create a SCHEDULED_CALENDAR_ENTRY collection type
    And I click on Create/edit button

    And I browse to the content peoplepopulationandcommunity/elections/electoralregistration/bulletins/electoralstatisticsforuk/2013-02-28 under collections
    And I click on Edit button
    And I enter keywords metadata and save for review
    And I edit the pages in progress and save for review
    Then I logout of florence

    Given I am logged in as a lead publisher
    And I select the collection
    And I change the Scheduled collection to Manual collection
    And I select the collection
    And I review the calendar entry files awaiting review
    And I approve the collection

    And I review the Electoral Statistics for UK: 2012 () bulletin file awaiting review with data-url:peoplepopulationandcommunity/elections/electoralregistration/bulletins/electoralstatisticsforuk/2013-02-28
    Then I approve the collection
    When I click on publishing queue and publish collection
    Then I logout of florence

    When I navigate to the ONS Website

    And click on PUBLISHED release calendar
    And search for the release with keyword, published after and published before dates
    Then search results contains the release information
    And search results contains the bulletin information











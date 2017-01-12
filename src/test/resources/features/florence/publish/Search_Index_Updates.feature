@searchindex_updates
Feature: Search Index Updates
  Any published content in florence should publish in ONS Website and update seach indexes

  Scenario: Publishing content should update search indexes

    Given I am logged in as a publisher
    And I create a MANUAL collection type
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


#  Scenario: Publishing release calendar items should update the release calendar



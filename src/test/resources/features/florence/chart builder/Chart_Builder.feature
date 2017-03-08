@chart_builder
Feature: Tests to check chart builder

  As a publish support team member
  I need to create a chart builder
  So that web users can understand the data easily.


  Scenario: Test to create a BAR Chart, verify in preview and in Website

    Given I am logged in as a publisher in sandpit env
    # Create a Manual Collection
    And I create a MANUAL collection type
    And I click on Create/edit button
    And I browse to the content businessindustryandtrade/business/activitysizeandlocation/ under collections
    And I click on Create button
    And I create a new Bulletin page

    # Add a bar chart and verify the chart details in preview
    And add a bar chart
    And verify the bar chart data in preview
    And I save and submit the collection for review
    And I logout of florence

    # Lead publisher will review and approve the collection
    Then I am logged in as a lead publisher in sandpit env
    When I select the collection
    Then I review the chart file awaiting review with data-url:businessindustryandtrade/business/activitysizeandlocation/bulletins/random page
    And I approve the collection
    When I click on publishing queue and publish collection
    Then I logout of florence

    # Check for the bar chart in website and its contents
    Given I navigate to the ONS Sandpit Website
    And I browse to businessindustryandtrade/business/activitysizeandlocation/bulletins/random page on the Sandpit ONS
    Then the ONS website does contain the new bar chart details


  Scenario: Test to create a LINE Chart, verify in preview and in Website

    Given I am logged in as a publisher in sandpit env
    # Create a Manual Collection
    And I create a MANUAL collection type
    And I click on Create/edit button
    And I browse to the content businessindustryandtrade/business/activitysizeandlocation/ under collections
    And I click on Create button
    And I create a new Bulletin page

    # Add a bar chart and verify the chart details in preview
    And add a line chart
    And verify the line chart data in preview
    And I save and submit the collection for review
    And I logout of florence

    # Lead publisher will review and approve the collection
    Then I am logged in as a lead publisher in sandpit env
    When I select the collection
    Then I review the chart file awaiting review with data-url:businessindustryandtrade/business/activitysizeandlocation/bulletins/random page
    And I approve the collection
    When I click on publishing queue and publish collection
    Then I logout of florence

    # Check for the line chart in website and its contents
    Given I navigate to the ONS Sandpit Website
    And I browse to businessindustryandtrade/business/activitysizeandlocation/bulletins/random page on the Sandpit ONS
    Then the ONS website does contain the new line chart details
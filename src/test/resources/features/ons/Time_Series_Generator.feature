@timeseriesgenerator
Feature: Time Series Generator

  Scenario: Custom time period for time series generator

    Given I am on the ONS HomePage
    And I navigate to Business Investment time series dataset
    And I navigate to Labour productivity time series page
    When I customize time period
    Then chart should reflect the time period chosen
    And can download customised time series


@links
Feature: Check all the links in ONS Website

  As a customer i want to click on a link of interest
  So that I can find information i need.

  Scenario: Check all links in Homepage

    Given I am on the ONS HomePage
    And I find all the available links
    And check if any links are broken
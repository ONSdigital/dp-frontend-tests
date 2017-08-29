Feature: Customise CPI dataset

  As a ONS Customer I want to customise the cpi dataset
  So that I can get only the information i need.

  @cpi
  Scenario: Navigate to the CPI dataset page

    Given I am on the ONS HomePage
    When I search for CPI dataset
    And I select CPI dataset from search results
    Then I should be on the CPI dataset landing page
    And there should be a dataset download page


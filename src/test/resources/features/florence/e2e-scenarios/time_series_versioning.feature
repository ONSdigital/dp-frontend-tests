@time_series
Feature: End to End time series versioning tests


  Scenario Outline: Creating and publishing a time series collection

    Given I am on the ONS HomePage
    And I navigate to Business Investment time series dataset
    And I click on "structured text (191.1 kB)" link

    Given I am logged in as an admin
    And I create a MANUAL collection type
    And I click on Create/edit button
    And I browse to the content economy/grossdomesticproductgdp/datasets/businessinvestment under collections
    And I click on Edit button
    And I upload a <filetype> file
    And I save and submit the collection for review
    And I logout of florence
    Then I am logged in as a lead publisher
    When I select the collection
    And I review the Current files awaiting review with data-url:economy/grossdomesticproductgdp/datasets/businessinvestment/current
    And I approve the collection
    When I click on publishing queue and publish collection
    Then I logout of florence
    Then I navigate to the ONS Website
    When I search for "cxnv" timeseries dataset
    When I navigate to Business Investment time series dataset
    And I click the previous versions
    Then I should see the new time series dataset
    Examples:
      | filetype |
      | CSDB     |

  Scenario: Create and Delete a collection
    Given I am logged in as an admin
    And I create a MANUAL collection type
    And I click on Create/edit button
    And I browse to the content economy/grossdomesticproductgdp/datasets/businessinvestment under collections
    And I click on Edit button
    And I select the collection
    And I delete all the worked on pages in the collection
    And I delete the collection
    Then I logout of florence
@delete_content
Feature: Delete Content
  As a publisher I am able to delete the content

  Scenario: Delete content should be removed from the florence/website

    Given I navigate to the ONS Website
    And I browse to "classifications/random page" on the ONS
    Then the ONS website does not contain the new changes

    #  Create content - create a page
    Given I am logged in as a publisher
    And I create a MANUAL collection type
    And I click on Create/edit button
    And I browse to the content classifications under collections
    And I click on Create button
    And I create a new "Generic static page" and submit for review

    Then I logout of florence
    #  Approve content/collection
    Given I am logged in as a lead publisher
    And I select the collection
    Then I review the files awaiting review with data-url:classifications/random page
    And I approve the collection
    When I click on publishing queue and publish collection
    Then I logout of florence
    # Navigate to the website to see the page exist
    Then I navigate to the ONS Website
    And I browse to classifications/random page on the ONS
    Then the ONS website does contain the new changes

    #  Create collection to Delete content
    Given I am logged in as a publisher
    And I create a MANUAL collection type
    And I click on Create/edit button
    And I browse to the content classifications/random page under collections
    And I delete the content
    Then I logout of florence
    #  Approve collection to Delete content
    Given I am logged in as a lead publisher
    And I select the collection
    Then I review the file awaiting deletion
    And I approve the collection
    When I click on publishing queue and publish collection

    # Make Sure content is deleted from florence and logout
    # Make sure content is deleted from Master
    When I browse to "classifications/random page" in a new tab on florence
    Then the Florence website does not contain the classifications changes
    And I browse to florence
    Then I logout of florence

    # Navigate to the website to see the page doesn't exist / content deleted
    Then I navigate to the ONS Website
    And I browse to "classifications/random page" on the ONS
    Then the ONS website does not contain the new changes


  Scenario: Delete content should be removed from search indexes

     # First Navigating to the website to see the page doesn't exist
    Given I navigate to the ONS Website
    And I browse to "classifications/random page" on the ONS
    Then the ONS website does not contain the new changes
    # To make sure page not showing in search results/indexes
    When I search for "random page" in the ONS Website
    Then there should not be any search results related to "random" page

    #  Create content - create a page
    Given I am logged in as a publisher
    And I create a MANUAL collection type
    And I click on Create/edit button
    And I browse to the content classifications under collections
    And I click on Create button
    And I create a new "Generic static page" and submit for review
    Then I logout of florence
    #  Approve content/collection
    Given I am logged in as a lead publisher
    And I select the collection
    Then I review the files awaiting review with data-url:classifications/random page
    And I approve the collection
    When I click on publishing queue and publish collection
    Then I logout of florence
    # Navigate to the website to see the page exist
    Then I navigate to the ONS Website
    And I browse to classifications/random page on the ONS
    Then the ONS website does contain the new changes

    # To make sure page showing in search results/indexes
    When I search for "random page" in the ONS Website
    Then there should be a search result related to "random" page

    #  Create collection to Delete content
    Given I am logged in as a publisher
    And I create a MANUAL collection type
    And I click on Create/edit button
    And I browse to the content classifications/random page under collections
    And I delete the content
    Then I logout of florence
    #  Approve collection to Delete content
    Given I am logged in as a lead publisher
    And I select the collection
    Then I review the file awaiting deletion
    And I approve the collection
    When I click on publishing queue and publish collection

    # Make Sure content is deleted from florence and logout
    # Make sure content is deleted from Master
    When I browse to "classifications/random page" in a new tab on florence
    Then the Florence website does not contain the classifications changes
    And I browse to florence
    Then I logout of florence

    # Navigate to the website to see the page doesn't exist / content deleted
    Then I navigate to the ONS Website
    And I browse to "classifications/random page" on the ONS
    Then the ONS website does not contain the new changes
    # To make sure page not showing in search results/indexes
    When I search for "random page" in the ONS Website
    Then there should not be any search results related to "random" page








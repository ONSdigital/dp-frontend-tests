Feature: Delete Content
  As a publisher I am able to delete the content

  Scenario: Delete content should be removed from the florence/website

    Given I navigate to the ONS Website
    And I browse to "classifications/xRtv2E6" on the ONS
    Then the ONS website does not contain the classifications changes

    #  Create content - create a page
    Given I am logged in as a publisher
    And I create a MANUAL collection type
    And I browse to the content classifications under collections
    And I click on Create button
    And I create a new "Generic static page" and submit for review
    Then I logout of florence
    #  Approve content/collection
    Given I am logged in as a lead publisher
    And I select the collection
    Then I review the xRtv2E6 files awaiting review with data-url:classifications/xrtv2e6
    And I approve the collection
    When I click on publishing queue and publish collection
    Then I logout of florence
    # Navige to the website to see the page exist
    Then I navigate to the ONS Website
    Then I browse to "classifications/xRtv2E6" on the ONS
    Then the ONS website does contain the classifications changes

    #  Create collection to Delete content
    Given I am logged in as a publisher
    And I create a MANUAL collection type
    And I browse to the content classifications/xrtv2e6 under collections
    And I delete the content
    Then I logout of florence
    #  Approve collection to Delete content
    Given I am logged in as a lead publisher
    And I select the collection
    Then I review the xRtv2E6 files awaiting deletion
    And I approve the collection
    When I click on publishing queue and publish collection

    # Make Sure content is deleted from florence and logout
    # Make sure content is deleted from Master
    When I browse to "classifications/xRtv2E6" in a new tab on florence
    Then the Florence website does not contain the classifications changes
    And I browse to florence
    Then I logout of florence

    # Navigate to the website to see the page doesn't exist / content deleted
    Then I navigate to the ONS Website
    Then I browse to "classifications/xRtv2E6" on the ONS
    Then the ONS website does not contain the classifications changes


  Scenario: Delete content should be removed from search indexes

     # First Navigating to the website to see the page doesn't exist
    Given I navigate to the ONS Website
    And I browse to "classifications/bDsx5G8" on the ONS
    Then the ONS website does not contain the classifications changes
    # To make sure page not showing in search results/indexes
    When I search for "bDsx5G8" in the ONS Website
    Then there should not be any search results related to "bDsx5G8" page

    #  Create content - create a page
    Given I am logged in as a publisher
    And I create a MANUAL collection type
    And I browse to the content classifications under collections
    And I click on Create button
    And I create a new "Generic static page" and submit for review
    Then I logout of florence
    #  Approve content/collection
    Given I am logged in as a lead publisher
    And I select the collection
    Then I review the bDsx5G8 files awaiting review with data-url:classifications/bdsx5g8
    And I approve the collection
    When I click on publishing queue and publish collection
    Then I logout of florence
    # Navige to the website to see the page exist
    Then I navigate to the ONS Website
    Then I browse to "classifications/bDsx5G8" on the ONS
    Then the ONS website does contain the classifications changes

    # To make sure page showing in search results/indexes
    When I search for "bDsx5G8" in the ONS Website
    Then there should be a search result related to "bDsx5G8" page

    #  Create collection to Delete content
    Given I am logged in as a publisher
    And I create a MANUAL collection type
    And I browse to the content classifications/bdsx5g8 under collections
    And I delete the content
    Then I logout of florence
    #  Approve collection to Delete content
    Given I am logged in as a lead publisher
    And I select the collection
    Then I review the bDsx5G8 files awaiting deletion
    And I approve the collection
    When I click on publishing queue and publish collection

    # Make Sure content is deleted from florence and logout
    # Make sure content is deleted from Master
    When I browse to "classifications/bDsx5G8" in a new tab on florence
    Then the Florence website does not contain the classifications changes
    And I browse to florence
    Then I logout of florence

    # Navigate to the website to see the page doesn't exist / content deleted
    Then I navigate to the ONS Website
    Then I browse to "classifications/bDsx5G8" on the ONS
    Then the ONS website does not contain the classifications changes
    # To make sure page not showing in search results/indexes
    When I search for "bDsx5G8" in the ONS Website
    Then there should not be any search results related to "bDsx5G8" page








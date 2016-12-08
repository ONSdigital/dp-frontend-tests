Feature: Check a collection in florence website
  As a publish support team member
  I need to create a manual collection
  So that customer can view in ONS Website


  Scenario: Create, review and publish a simple manual collection

    Given I am logged in as an admin
    And I create a MANUAL collection type
    And I browse to the content aboutus under collections
    And I click on the content header CONTENT
    And I edit the content within the active accordion
    And I enter text into the markdown editor
    Then I save and submit the collection for review
    Then I logout of florence
    Given I am logged in as a publisher
    And I select the collection
    Then I review the About us files awaiting review with data-url:aboutus
    And I approve the collection
    When I click on publishing queue and publish collection
    Then I logout of florence
    Then I browse to "aboutus" on the ONS


#
#    Then I should see the text "ONS Stands for Office for national statistics." on the bottom of the page




















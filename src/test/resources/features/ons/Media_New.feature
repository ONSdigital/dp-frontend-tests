@Media @imp
Feature: Check the media related information on ONS Website

  As a customer i want to find the media related information
  So that I am aware of the latest information from ONS

  Scenario: Navigate to Media

    Given I am on the ONS HomePage
    When I view the links displayed on the website header
    Then I should see the "Media" link displayed


  Scenario: Check media link in header

    Given I am on the ONS HomePage
    When I click on "Media" link
    Then I should be on the Media page
    And Provided with a clickable link to the "News" section
    And Provided with a clickable link to the "Statements and letters" section
    And Provided with a clickable link to the "Media contact information" section


  Scenario: Check News Content in Media page

    Given I am on the "Media" page
    When I click on "News" link
    Then I should be on the List of all news page
    And I should be provided with clickable links to all ONS published news
    And Links to published news are listed by date published
    And I can refine results using keywords like "crime"
    And Provided with links to The National Archives for archived releases



  Scenario: Click on first news result in List of all news page

    Given I am on the "Media" page
    When I click on "News" link
    Then I should be on the List of all news page
    When I click first link in published news
    Then I should not be on the List of all news page


  Scenario: Navigate to Statement and Letters page

    Given I am on the "Media" page
    When I click on "Statements and letters" link
    Then I should be on the List of all statements and letters page
    And I should be provided with clickable links to all ONS published statements and letters
    And Links to published statements and letters are listed by date published
    And I can refine results using keywords like "economic"
    And Provided with links to The National Archives for archived releases


  Scenario: Select to Statement and Letters page

    Given I am on the "List of all statements and letters" page
    When I click first link in published news
    Then I should not be on the List of all statements and letters page


  Scenario: Navigate to Contact Media Relations Office ( Media Contact Information )

    Given I am on the "Media" page
    When I click on "Media contact information" link
    Then I should be on the Contact Media Relations Office page
    And Provided with a mailto email address - media.relations@ons.gsi.gov.uk
    And Provided with a  "General and statistical enquiries" link within "You might also be interested in:" section of the page


  Scenario: Navigate to "General and statistical enquiries" page

    Given I am on the "Contact Media Relations Office" page
    When I click on "General and statistical enquiries" link
    Then I should be on the General and statistical enquiries page
    And Provided with descriptive metadata
    And Provided with a mailto email address - info@ons.gsi.gov.uk
    And Provided with a  "Office locations" link within "You might also be interested in:" section of the page


  Scenario: Click on the "Office locations" link

    Given I am on the "General and statistical enquiries" page
    When I click on "Office locations" link
    Then I should be on the Office locations page
    And Provided with office location and address in Newport
    And Provided with office location and address in Titchfield
    And Provided with office location and address in London
    And Each location has a clickable link to Google map








    












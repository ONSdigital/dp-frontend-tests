Feature:
  Create and publish a release calendar

  Scenario:
    Given I navigate to the ONS Website
    And click on PUBLISHED release calendar
    And search for the release with keyword, published after and published before dates
      | Profitability of UK companies: Jan to Mar 2016 | 01/08/2016 | 15/10/2016 |
    Then search results contains the release: Profitability of UK companies: Jan to Mar 2016
    Then verify the release information
      | header                                         | image | contact    | contact_email                | releaseDate   | nextRelease     |
      | Profitability of UK companies: Jan to Mar 2016 | true  | Eric Crane | profitability@ons.gsi.gov.uk | 5 August 2016 | 13 October 2016 |

#Feature: Content designer creates a content page to publish to the release calendar
#  As a publish support team member
#  I need to create a content page
#  So that i can publish to the release calendar
#
#  @donotrun
#  Scenario: Content designer navigates to "Browse" tab in Florence
#
#    Given I am on the Florence HomePage
#    When I enter "testuser@test.com" in the Email field
#    And I enter "one two three four" in the Password field
#    And I click "Log in" button
#    Then I should be on the collections section
#
#    When I enter "Release Calendar" in the Collection name field
#    And I select Manual publish radio button
#    And I click "Create collection" button
#
#    Then I should be on the Working on Collection section
#
#    Then I should be directed to "Browse" tab in Florence by default
#    And Presented with "Edit" button
#    And Presented with "Create" button
#    And The web preview is displayed
#    And The taxonomy is displayed
#
#    When I click "Create" button
#    Then I should be directed to the "Create" tab
#    And I should see the text "New page details"
#    And I select "Calendar entry" from the Select your option dropdown
#    And I enter "Future Date" in the Release date field
#    And I select "10" from the Hour dropdown
#    And I select "30" from the Minute dropdown
#    And I enter "Baby names in England and Wales: 2017" in the Page name field
#    And I click "Create page" button
#    Then I
#
#
#
#    And Provided with a field to enter the edition <EditionTitle>
#    And Provided with a field to enter the release date <ReleaseDate>
#    And The page name field to add the <ContentTitle>
#    And I am required to complete all fields within the "New page details" page before I can proceed
#    And Presented with a preview of the <ContentTitle>
#    And Provided with a "Create page" button
#    And Presented with a content type options list <ContentType> (as a drop-down)
#    And Provided with a page name field <ContentTitle>
#    And Provided with a "Create page" button
#    Examples:
#      |       ContentType      |             ContentTitle                                   |
#      |            hello            |        Baby names in England and Wales: 2015               |
#  Scenario Outline: Content designer selects content type on "New page details" page
#    Given I am presented with a content type drop down list
#    When I select <ContentType>
#    Then I should be presented with a release date calendar field <ReleaseDate>
#    And Presented with time drop down option for hours <TimeHour>
#    And Presented with time drop down option for minutes <TimeMinutes>
#    Examples:
#      |          ReleaseDate      |     TimeHour  |   TimeMinutes     |              ContentType               |
#      |22 September 2016           |      09        |             30     | 1 August 2017                       |
#
#  Scenario: Content designer clicks on  "Create page" button
#    Given I have selected <ContentType>
#    And Selected <ReleaseDate>
#    And Selected <TimeHour><TimeMinutes>
#    And Typed in <ContentTitle>
#    When Select the "Create page" button
#    Then I should directed to the "Edit" tab automatically
#    And The <ContentTitle> should be created
#    And Preview of <ContentTitle> displayed
#    And Provided with the metadata drop-down options
#    And Provided with the pre-release drop-down options
#    And Provided with the date changes drop-down option
#    And Provided with the drelated links drop-down option
#    And Provided with the preview release content drop-down option
#
#

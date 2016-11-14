Feature: Given a rapid prototype is developed
          When I represent the prototype to users
          Then I receive the feedback so that I can iterate the website functionality



  Scenario: Check content and download entire dataset

    Given I am on the "User Testing" page
    Then I should see the text "This dataset contains Census data relating to members of the Armed Forces and their Accommodation Type (Household or Communal)."
    And I should see the text "It is available by Gender, Age and Geographical Area."
    When I click "Choose dimensions >" button
    Then I should be on the Dimensions page
    And I should see the text "Choose dimensions"
    And I should see "Residence Type" dimension with "Household, communal establishment, all categories" text and "Change" link
    And I should see "Gender" dimension with "Female, male, all categories" text and "Change" link
    And I should see "Age" dimension with "16 and over, 16 to 24, 25 to 34, 35 to 49, 50 and over" text and "Change" link
    And I click "Continue >" button


   Scenario Outline: Both Sex with all age and accommodation type dataset

     Given I am on the "User Testing" page
     When I click the "Change" link for "Gender" dimension
     Then I should be on the Change option page
     When I select "<Gender>" check box
     And I click "Apply changes" button
     Then I should be on the Dimensions page
     And I should see "Sex" dimension with <Gender> option selected and "Change" link
     And I should see the "Download" button is enabled

     Examples: | Gender |
               | Male   |
               | Female |


  Scenario Outline: Both Accommodation type with all age and sex type dataset

    Given I am on the "User Testing" page
    When I click the "Change" link for "Accommodation" dimension
    Then I should be on the Change option page
    When I select "<Accommodation>" check box
    And I click "Confirm" button
    Then I should be on the Dimensions page
    And I should see "Accommodation" dimension with <Accommodation> option selected and "Change" link
    And I should see the "Download" button is enabled

    Examples: | Accommodation |
              | Communal      |
              | Household     |



  Scenario Outline: All Age group with all accommodation and sex type dataset

    Given I am on the "User Testing" page
    When I click the "Change" link for "Age" dimension
    Then I should be on the Change option page
    When I select "<Age Group>" check box
    And I click "Confirm" button
    Then I should be on the Dimensions page
    And I should see "Age" dimension with <Age Group> option selected and "Change" link
    And I should see the "Download" button is enabled

    Examples: | Age Group |
              | 16-24     |
              | 25-34     |
              | 35-49     |
              | 50+       |








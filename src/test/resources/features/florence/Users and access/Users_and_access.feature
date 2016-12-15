Feature: End to end tests related to Authentication/Encryption

  Scenario: Publisher create a collection and viewer views the same collection

    Given I am logged in as an admin
    Then browse to teams page
    And a team with teamname:"Labour Market Team" is created
    And add a viewer to the team
    And I logout of florence

    Given I am logged in as a publisher
    And I create a SCHEDULED_CUSTOM collection type
    And I browse to the content businessindustryandtrade under collections
    And I enter keywords metadata and save for review
    And I logout of florence
    # Log in as viewer and
    Given I am logged into Ermintrude website as a viewer
    And I select the collection
    And I select "Business, industry and trade" from the Select a document to view dropdown
    Then I should see the text "Business, industry and trade"
    And I logout of ermintrude

    Given I am logged in as an admin
    Then browse to teams page
    When I delete the team:"Labour Market Team"
    And I select the collection
    Then I delete all the worked on pages in the collection
    When I delete the collection
    Then I logout of florence





















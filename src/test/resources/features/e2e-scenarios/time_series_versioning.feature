Feature:
End to End time series versioning tests

    Background:
        Given I am logged in as an admin
        And I delete the collection:TimeSeriesGiri
        Then I log out of florence
    Scenario:
        Given I am logged in as a publisher
        And I create a collection:TimeSeriesGiri
        And I navigate to "Economy"

  #      Given I am logged in as a lead publisher


#


#
#      Scenario: Delete Collection
#        Given I am logged in as a publisher
#        And I delete the collection


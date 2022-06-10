Feature: User should be able to search the items


  @wip
  Scenario: Verify that user is able to search the item
    Given user is on the homepage of Amazon
    And user enter "guitar" on search box
    When user click on the search button
    Then user sees "guitar" on the homepage


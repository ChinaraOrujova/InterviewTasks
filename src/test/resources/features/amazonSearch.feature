Feature: User should be able to search the items


  @ui1
  Scenario: Verify that user is able to search the item
    Given user is on the homepage of Amazon
    And user enter "guitar" on search box
    When user click on the search button
    Then user sees "guitar" on the homepage



  @ui2
  Scenario: Verify that user is able to find the average price of all listed items
    Given user is on the homepage of Amazon
    And user enter "guitar" on search box
    When user click on the search button
    Then user sees list of results on the homepage
    And user get the average price of all listed guitar



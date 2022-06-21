Feature: User should be able to search the items


  @ui1
  Scenario: Verify that user is able to search the item
    Given user is on the homepage of Amazon
    When user enter "guitar" on search box
    And user click on the search button
    Then user sees "guitar" on the homepage





  @ui2
  Scenario: Verify average guitar prices
    Given user is on the homepage of Amazon
    When user enter "guitar" on search box
    And user click on the search button and see all the listed guitar
    Then user get the average price of all listed guitars




  @ui3
  Scenario: Verify that user is able to choose any item from the list
    Given user is on the homepage of Amazon
    When user enter "guitar" on search box
    And user click on the search button and see all the listed guitar
    Then user choose one item from the list


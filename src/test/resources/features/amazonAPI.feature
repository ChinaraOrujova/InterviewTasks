Feature: Amazon is up and running

  @api
  Scenario: verify Amazon is up and running by checking the search functionality
    When I send GET request
    Then status code should be 200

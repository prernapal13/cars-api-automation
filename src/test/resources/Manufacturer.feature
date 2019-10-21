Feature: Fetch Manufacturer List
  Test manufacturer api

  Scenario: Test car manufacturers api with valid data
    When User request for car manufacturers
    Then "GET" request should return response code 200
    And Response wkda should not be empty
    And Manufacturer map should contain manufacturer code "107" with manufacturer name "Bentley"

  Scenario: Test car manufacturers api with invalid query parameter wa_key
    When User request for car manufacturers with invalid query parameter "wakey"
    Then "GET" request should return response code 401

  Scenario: Test car manufacturers api without wa_key
    When User request for car manufacturers without wa_key
    Then "GET" request should return response code 401

  Scenario: Test car manufacturers api with invalid wa_key
    When User request for car manufacturers with invalid wa_key
    Then "GET" request should return response code 403

  Scenario: Test car manufacturer api with invalid service end point
    When User request for car manufacturers with invalid serviceendpoint
    Then "GET" request should return response code 404
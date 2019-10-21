Feature: Fetch Main Types List based on Manufacturer Code
  Test main types api based on manufacturer code

  Scenario Outline: Test main types api based on valid manufacturer code
    When User request car main-types based on "manufacturer" code <CODE>
    Then "GET" request should return response code 200
    And Response wkda should not be empty
    And Response should contain expected main types for manufacturer code <CODE>

    # manufacturer code 125 is having minimun number of main-type and 905 is having maximum number of main-type
    # 125 = 1 and 905 = 65
    Examples: 
      | CODE  |
      | "125" |
      | "905" |

  Scenario: Test main types api without manufacturer code
    When User request car main-types without manufacturer code
    Then "GET" request should return response code 400

  Scenario: Test main types api based on manufacturer code without wa_key
    When User request car main-types based on manufacturer code "107" without wa_key
    Then "GET" request should return response code 401

  Scenario: Test main types api based on manufacturer code with invalid wa_key
    When User request car main-types based on manufacturer code "107" with invalid wa_key
    Then "GET" request should return response code 403

  Scenario Outline: Test main types api based on non existing or invalid manufacturer code
    When User request car main-types based on "manufacturer" code <CODE>
    Then "GET" request should return response code 200
    And Response wkda should be empty

    Examples: 
      | CODE      |
      | "5000"    |
      | "!nv@lid" |

  Scenario: Test main types api with invalid query parameter
    When User request car main-types based on "manufacture" code "107"
    Then "GET" request should return response code 400

  Scenario: Test main types api with invalid service end point
    When User request car main-types based on "manufacturer" code "107" with invalid serviceendpoint
    Then "GET" request should return response code 404
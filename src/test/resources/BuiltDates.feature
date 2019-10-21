Feature: Fetch Built Dates List based on Manufacturer Code and Main Type
  Test built dates api based on manufacturer code & main type

  Scenario Outline: Test built dates api based on valid manufacturer code & main-type
    When User request for built-dates based on "manufacturer" code <CODE> and "main-type" <MAIN_TYPE>
    Then "GET" request should return response code 200
    And Response wkda should not be empty
    And Response should contain expected built-dates for manufacturer code <CODE> and main-type <MAIN_TYPE>

    # Comment: Testing main type apis with/without special characters
    Examples: 
      | CODE  | MAIN_TYPE      |
      | "107" | "Azure"        |
      | "225" | "Qashqai+2"    |
      | "425" | "K-Reihe 2700" |

  Scenario: Test built dates api based on manufacturer code & main-type without wa_key
    When User request for built-dates based on manufacturer code "107" and main-type "Azure" without wa_key
    Then "GET" request should return response code 401

  Scenario: Test built dates api based on manufacturer code & main-type with invalid wa_key
    When User request for built-dates based on manufacturer code "107" and main-type "Azure" with invalid wa_key
    Then "GET" request should return response code 403

  Scenario Outline: Test built dates api based on combination of invalid manufacturer code or main-type
    When User request for built-dates based on "manufacturer" code <CODE> and "main-type" <MAIN_TYPE>
    Then "GET" request should return response code 200
    And Response wkda should be empty

    Examples: 
      | CODE      | MAIN_TYPE |
      | "107"     | "!nv@liD" |
      | "!nvaliD" | "Azure"   |
      | "!nv@liD" | "!nv@liD" |

  Scenario: Test built dates api based on manufacturer code & without main-type
    When User request for built-dates based on manufacturer code "107" and without main-type
    Then "GET" request should return response code 400

  Scenario: Test built dates api based on without manufacturer code & main-type
    When User request for built-dates based on without manufacturer code and main-type "Azure"
    Then "GET" request should return response code 400

  Scenario: Test built dates api based on without manufacturer code & without main-type
    When User request for built-dates based on without manufacturer code and without main-type
    Then "GET" request should return response code 400

  Scenario Outline: Test built dates api based on combination of invalid query parameters manufacturer code or main-type
    When User request for built-dates based on <PARAM1> code "107" and <PARAM2> "Azure"
    Then "GET" request should return response code 400

    Examples: 
      | PARAM1         | PARAM2      |
      | "manufat"      | "main-type" |
      | "manufacturer" | "main"      |
      | "manu"         | "main"      |

  Scenario: Test built dates api with invalid service end point
    When User request for built-dates based on "manufacturer" code "107" and "main-type" "Azure" with invalid serviceendpoint
    Then "GET" request should return response code 404

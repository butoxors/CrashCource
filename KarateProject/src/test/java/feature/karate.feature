Feature: Quote generator

  Scenario: Fetch random quote

    Given path https://api.instagram.com/v1/users/searche'
    When method GET
    Then status 200

Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario Outline: Sunday isn't Friday
    Given today is Sunday
    When I ask whether it's Friday yet
    Then I should be told <answer>
    Examples:
    |answer|
    |Nope  |
    |Yes   |
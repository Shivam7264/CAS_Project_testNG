Feature: header features Service Lines

  @sanity
  Scenario: validation of Service Lines header
    Given the user checks header option Service Lines has icon
    When user clicks on Service Lines and print the list showing
    Then if user finds icon on any list item it hovers on it and prints it
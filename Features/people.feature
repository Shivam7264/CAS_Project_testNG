Feature: header features People

  @sanity
  Scenario: validation of People header
    Given the user checks header option  has icon
    When user clicks on People and print the list showing
    Then If user finds icon on any list item it hovers on it and prints it

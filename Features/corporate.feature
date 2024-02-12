Feature: header features Corporate Functions

  @sanity
  Scenario: Validation of Corporate Functions header
    Given The user checks header option Corporate Functions has icon
    When User clicks on Corporate Functions and print the list showing
    Then If user finds icon on any list item it hovers on it and prints it recursiverly

  @sanity
  Scenario: Validation of legal and corporate affairs in Corporate functions header
    Given The user clicks on corporate functions header
    When user finds Legal and corporate affairs and hover over it and clicks on Ethics & Compliance
    And verify the page legal and corporate affairs
    Then prints the list of Resources  available

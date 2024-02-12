Feature: Company header features validation

  @sanity
  Scenario: validation of company header
    When the user checks header option company has icon
    When user clicks on company and print the list showing
    Then user can hover if any list item has Triangle icon

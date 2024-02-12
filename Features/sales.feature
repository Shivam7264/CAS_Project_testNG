Feature: sales header features validation

  @sanity
  Scenario: validation of sales header
    Given the user checks header option sales has icon
    When user clicks on sales and print the list showing
    Then user can hover if any list item has icon

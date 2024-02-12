Feature: login features validation

  @sanity
  Scenario: validation of be user
    Given the user navigated to the cognizant page
    When the user clicks on user icon
    Then user can validate the mail contains @cognizant.com
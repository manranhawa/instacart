Feature: Stores deleivery details
  @regression
  Scenario: Get deleivery details of stores
    Given User Launch browser
    And opens URL "https://www.instacart.ca/"
  When User see the alert, clicks on the cross icon
    When user is on homepage
    Then user quits the browser
 
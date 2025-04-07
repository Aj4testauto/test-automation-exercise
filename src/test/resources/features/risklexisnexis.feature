@risk @sanity
Feature: risk solution

#  in progress
  Scenario: Risk Solution
    Given I am on the "risk-lexisnexis" page
    When I clicks on "About Us" and "Careers"
    And I click on search jobs button to search for "Automation Tester" Jobs
    Then I should see at least one job published
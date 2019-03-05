Feature: Login Feature
  Verify if user is able to Login in to the site

  Scenario: Login as a authenticated user
    Given user has launched the browser
    When user enters login details
    And user clicks Submit
    Then user is logged into SFDC

   Scenario: Click on the close dialogue
   Given user clicked Submit
   When user sees pop up
   And user clicks the close dialogue
   Then user is logged into sfdc

 
  
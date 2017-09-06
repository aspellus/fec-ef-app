Feature: HomePage
         As a committee treasurer/representative
         I want to go to home page URL
         So that I can enter my committee-id and view my custom portal page

@regression @smoke
Scenario: select a committee id from the drop down
Given I am on the home page
When I select a committee ID from the drop down
Then my custom portal page is displayed

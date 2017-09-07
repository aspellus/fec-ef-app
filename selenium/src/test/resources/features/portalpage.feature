Feature: PortalPage
  As a committee treasurer/representative
  I want to go to home page URL and enter my committee ID and submit
  so that I can view committee information on the logged in page

@regression @smoke
Scenario: select a committee id from the drop down
Given I am on the home page
When I select a committee ID from the drop down
Then my custom portal page is displayed
AND Under the page header my committee basic information should be displayed
AND Committee Basic Information will contain Committee Name, Address, Treasurer Name and Party Affiliation

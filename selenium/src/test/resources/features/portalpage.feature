Feature: PortalPage
  As a committee treasurer/representative
  I want to go to home page URL and enter my committee ID and submit
  So that I can view committee information and list of existing reports
  
@regression @smoke
Scenario: select a committee id from the drop down
  Given I am on the home page
  When I select a committee ID from the drop down
  Then my custom portal page is displayed
    And Under the page header my committee basic information should be displayed
    And the filings view is displayed by default

Scenario: select more committee info option to learn more about the committee
  Given I am on the home page
  When I select a committee ID from the drop down
  Then my custom portal page is displayed
    And I select the committee info tab
    And Committee Basic Information will contain Committee Type, Address, Treasurer Name and Party Affiliation

@regression @smoke
Scenario: List Filings for committee ID
  Given I am on the portal page
  When I select a committee ID from the drop down list
  Then all my previously filed reports should show up in tabular Form 
    And Table will contain Report_ID, Report_Type, Coverage_Start_Date, Coverage_End_Date, Receipt_date and Last_Uploaded_Date
    And Show actions to AMEND the filing

@regression @smoke
Scenario: Filter filings by Report Year
  Given I am on the portal page 
  When I search for 2017 using Report Year Filter
  Then my results should be the reports filed for year 2017 coverage dates only

@regression @smoke
Scenario: Filter filings by Form Type
  Given I am on the portal page 
  When I select Statement of Organization (F1) from the Form Type Filter
  Then my results should only contain Statement of Organizations (F1)
    
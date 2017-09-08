
Feature: PortalPage view Reports Functionality
  As a committee treasurer/representative
  I want to go to home page URL and enter my committee ID and submit
  So that I can view committee information and list of existing reports

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

Feature: Transaction Page
  As a committee treasurer/representative
  I want to go to transaction page by clicking “View/Amend” action button from the portal page
  So that I can click on Receipt, Disbursements, Loans and Debts tab to view and edit my transactions

@regression @smoke
Scenario: list all my receipts
  Given I am on the transaction page
  When I select Receipts tab
  Then Receipts basic information for this filing should be displayed in a table
    And Receipts basic information will consists of Line Number, Date, Name and Amount
    
    
@regression @smoke
Scenario: Add new receipt
  Given I am on the transaction page
  When I click New Receipt
  Then I should see a form to enter the receipt information
    And the form should contain Line Number, First Name, Last Name, Prefix, Suffix, Date, Amount, Memo Indicator, Employer, Occupation and Description
    And actions to Save or Delete
    
@regression @smoke
Scenario: Add new receipt and Save Action
  Given I am on the transaction page and filled the form
  When I click save button
  Then the transactions should be saved in sched_a database table
    And I should be able to find the just added transactions in receipts tab

@regression @smoke
Scenario: Edit receipt and Save Action
  Given I am on the transaction page and selected a receipt
  When I update the Name and click save
  Then the detailed receipt information should collapse 
    And the Name should be updated in the data base
    And the Updated Name should be displayed in the Receipts Tab
    
@regression @smoke
Scenario: Delete receipt
  Given I am on the transaction page and selected a receipt
  When I click delete
  Then alert me with a message "Are you sure you want to Delete this Receipt"
    And if YES is selected then delete the receipt from the database
    And remove the report from the Receipt Tab
    

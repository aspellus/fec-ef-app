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

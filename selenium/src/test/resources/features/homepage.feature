Feature: Homepage
    As a user,
    I want to view the homepage
    so that I can see the logo

@regression @smoke
Scenario: Homepage
Given I am on the homepage
Then the logo is clearly visible

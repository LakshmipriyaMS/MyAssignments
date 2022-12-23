Feature: Salesforce login and opportunity creation
@Smoke
Scenario Outline: Create new opportunity
Given user is on homepage
And type username as <username>
And type password as <password>
And click login button
Then user is on salesforce homepage
And Click on toggle menu button from the left corner
And Click view All and click Sales from App Launcher
And Click on Accounts tab 
Then Click on New button 
And Enter your name as <account name>
And Select Ownership
Then Click save and verify Account name

Examples:
|username|password|account name|
|hari.radhakrishnan@qeagle.com|Testleaf$321|Lakshmi|


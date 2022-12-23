Feature: Salesforce login and opportunity creation
@Functional
Scenario Outline: Create new opportunity
Given user is on homepage
And type username as <username>
And type password as <password>
And click login button
Then user is on salesforce homepage
And Click on toggle menu button from the left corner
And Click view All and click Sales from App Launcher
And Click on Opportunity tab 
And Click on New button 
And Enter Opportunity name as <opportunity name>
And Choose close date as Today 
And Select Stage as Need Analysis
Then click Save and VerifyOppurtunity Name

Examples:
|username|password|opportunity name|
|hari.radhakrishnan@qeagle.com|Testleaf$321|Lakshmipriya|

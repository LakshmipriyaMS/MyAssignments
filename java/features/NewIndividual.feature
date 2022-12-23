Feature: Salesforce login and new individual creation
@Regression
Scenario Outline: Create new dashboard
Given user is on homepage
And type username as <username>
And type password as <password>
And click login button
Then user is on salesforce homepage
And Click on toggle menu button from the left corner
And Click view All and click individuals
And Click on the Dropdown icon in the Individuals tab
Then Click on New Individual 
And Enter the Last Name as <lastname>
And Click save and verify Individuals Name

Examples:
|username|password|lastname|
|hari.radhakrishnan@qeagle.com|Testleaf$321|Kumar|

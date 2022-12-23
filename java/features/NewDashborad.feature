Feature: Salesforce login and dashboard creation
@Sanity
Scenario Outline: Create new dashboard
Given user is on homepage
And type username as <username>
And type password as <password>
And click login button
Then user is on salesforce homepage
And Click on toggle menu button from the left corner
And Click view All and click Dashboards from App launcher
And click New Dashboard
And enter dashboard name as <dashboard name> and click create
And click save and verify dashboard name

Examples:
|username|password|dashboard name|
|hari.radhakrishnan@qeagle.com|Testleaf$321|Priya|


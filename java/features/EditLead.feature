Feature: Login to leaftaps and Edit Lead
Scenario Outline: Edit Lead
#Given launch chrome browser
#And open url and maximize
And enter username as <username>
And enter password as <password>
And click on submit
And click on 'CRM/SFA' link
And click on 'Leads' link
And click on 'Create Lead' link
And enter the company name as <companyname>
And enter the first name as <first name>
And enter the last name as <last name>
And enter first name local as <first name local>
And enter department name as <department name>
And enter description as <description>
And enter the email id as <email>
And select the source
And select the state
Then click create Lead
Given click Edit
And update description
And click update
Then verify title

Examples:
|username|password|companyname|first name|last name|first name local|department name|description|email|
|DemoSalesManager|crmsfa|ABC|Lakshmi|Priya|||||
|DemoCsr|crmsfa|Test|Banu|Mathy|Priya|ECE|new update|priya@gmail.com|

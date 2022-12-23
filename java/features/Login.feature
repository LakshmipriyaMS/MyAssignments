Feature: Login to leaftaps
@Smoke
Scenario Outline: Create Lead
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
When click on create
Then verify lead is created

Examples:
|username|password|companyname|first name|last name|
|DemoCsr|crmsfa|ABC|Lakshmi|Priya|
#|DemoCsr|crmsfa|Test|Banu|Mathy|


Scenario:
And enter username as DemoSalesManger
And enter password as crmsfa
And click on submit


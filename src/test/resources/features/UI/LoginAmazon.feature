Feature: Login to Amazon application

Scenario: Login 
	Given user is on Amazon login page
	When enter the username and click continue
	Then enter the password
	Then click submit button
	Then click menu bar
	Then click logout button
	
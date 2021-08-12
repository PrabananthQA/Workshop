Feature: eCom Register

Scenario Outline: eCom Register Test Scenario

Given the user in the HomePage 
When title of login page is Your Store
Then user clicks on My Account
Then user choose Register
Then user land in Register Account Page
Then user enters "<First Name>"  
Then user enters "<Last Name>"
Then user enters "<E-Mail>"
Then user enters "<Telephone>"
Then user enters "<Password>" and "<Confirm Password>"
Then user Agrees to Privacy policy
Then user clicks continue
Then Your Account Has Been Created!
Then Close the browser


Examples:
	| First Name | Last Name | | E-Mail | | Telephone | | Password | | Confirm Password |
	| John  | Doe | | johndoe@gmail.com | | 9086754321 | | qwerty | | qwerty |
		
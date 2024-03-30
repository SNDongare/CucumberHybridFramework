@all
Feature: login functionality
Users should be able to access his/her account using login functionality

Background:
Given User navigated to login page

@login @validcredentials @smoke @regression
Scenario Outline: login with valid credentials
When user enters valid email <userName> address
And user enters valid <password> password
And click on login button
Then user should be able to successfully login
Examples:
|userName                          |password   |
|sachindongare2002@gmail.com       |Sachin@4467|
|sachindongare2003@gmail.com       |Sachin@4467|
#|sachindongare2004@gmail.com       |Sachin@4467|
#|sachindongare2005@gmail.com       |Sachin@4467|


@login @invalidcredentials @smoke @regression
Scenario: login with Invalid credentials
When user enters Invalid email address
And user enters Invalid password "Sachin@4467"
And click on login button
Then user should get proper warning message

@login @validusernameandinvalispassword @regression	
Scenario: login with valid username and invalid password
When user enters valid email "sachindongare2002@gmail.com" address
And user enters Invalid password "145345"
And click on login button
Then user should get proper warning message

@login @invalidusernameandvalidpassword @regression
Scenario: login with Invalid username and valid password
When user enters Invalid email address
And user enters valid "Sachin@4467" password
And click on login button
Then user should get proper warning message

@login @nocredentials @regression
Scenario: login without providing any creditials
When user don’t enters any email address
And user don’t enters any  password
And click on login button
Then user should get proper warning message




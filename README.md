This is a task for AAIB to automate a test case:
* TC1: Successfully register a new account at the Account Creation Link. This test should
simulate a user filling out the registration form and submitting it.

# Project Details:
## Main Framework used:
* [SHAFT_Engine](https://github.com/ShaftHQ/SHAFT_ENGINE) <br><img height="100" title="SHAFT_Engine" src="https://github.com/ShaftHQ/SHAFT_ENGINE/blob/main/src/main/resources/images/shaft.png">
## Demo Website used:
* [nopCommerce Demo Store](https://demo.nopcommerce.com/) <br><img title="nopCommerce Demo Store" src="https://demo.nopcommerce.com/Themes/DefaultClean/Content/images/logo.png">
## Project Design:
* Used Selenium that being utilized by SHAFT-Engine under the hood
* Used TestNG framework throughout the project with its great annotations
* Page Object Model (POM) design pattern.
* Fluent design approach (method chaining) for better test case readability.
* Data Driven Testing (store data as JSON files). 
* Used Allure reports to provide a comprehensive report about the test cases and their status

## How to run the project 
* Using Maven installed on your machine you just need to clone the repo on your machine and run the command in an opend terminal in the project directory and run the following command "mvn test"
* Using InteliJ IDE to run it through the Code Editor with Java JDK and Mvn installed on the machine
* Allure report will be generated automatically if not you can open it by allure serve if allure is installed on your device  

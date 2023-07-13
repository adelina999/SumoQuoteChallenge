# **SumoQuote Challenge**

This project demonstrates automated testing using Java , TestNG, POM and Selenium.

## **Description**

This project showcases automated tests for Signup and account, logging into the account and start a new order, using Java and Selenium. The tests are written to validate various features and functionalities of the application.

## **Prerequisites**

* Java Version 11
* Maven [version]
* Firefox, Chrome Web Browser
* WebDriverManager
* TestNG plugin

# **Installation**

* Clone the repository: git clone 
* Navigate to the project directory: cd 
* Set up the WebDriver
* MAke sure to have all the dependencies from pom.xml file
* Build the project: mvn clean install


#   **Usage**

* Run the test suite:
  * Command Line: mvn test
  * IDE: Run the test suite using your preferred IDE's testing framework. 
* The tests will run and generate test report (reports/ExtentReport.html)- I used very simple ExtentReport just as aproof of concept.

# **Acknowledgments**
Once I created an email and verified it then created a project, I couldn't see the get started button anymore. I created one test that will show generation of new email everytime, and a test that will login with the email I already verified.
It doesn't allow to use same verify your account link for a different user, and it requires to create a new mail account every time over.
I used the testNG framework with a POM and performed some assertion on the page level.
Pages -
src/test/java/com/tests/pages
Tests
src/test/java/com/tests/SignupPageTest.java
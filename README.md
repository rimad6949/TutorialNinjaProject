# Overview

This project is an automation framework for testing the Tutorial Ninja e-commerce application using Selenium with Java. It is designed to validate various functionalities of the website, including user registration, login, product search, add to cart, and checkout processes.

## Tech Stack

Programming Language: Java
Automation Tool: Selenium WebDriver

Build Tool: Maven

Testing Framework: TestNG

Design Pattern: Page Object Model (POM)

Data Handling: Apache POI (for Excel data-driven testing)

Logging: Log4j

Reporting: Extent Reports

## Project Structure
```bash
TutorialNinjaAutomation/
│-- src/
│   ├── main/java/com/tutorialninja/basepages/    # Base Page class
│   ├── main/java/com/tutorialninja/pages/        # Page classes
│   ├── main/java/com/tutorialninja/utilities/    # Utility classes
│   ├── test/java/com/tutorialninja/base/         # Test BasePage class
│   ├── test/java/com/tutorialninja/testcases/    # Test classes
│   ├── test/resources/logs/
│   ├── test/resources/manualtestcases/           # Manual test case excel sheet
│   ├── test/resources/properties/
│   ├── test/resources/runner/
│   ├── test/log4j2.xml
│-- test-output/                              # Test reports
│-- pom.xml                                   # Maven dependencies
│-- README.md                                 # Project documentation
```

## Features Automated

✅ User Registration        
✅ User Login        
✅ Product Search  (Pending)         
✅ Add to Cart Functionality    (Pending)          
✅ Checkout Process         (Pending)            
✅ Data-Driven Testing using Excel     (Pending)   
✅ Extent Reports for Test Execution Summary   (Pending)   

## Installation & Setup

### Prerequisites:

✅ Install Java JDK 8+
✅ Install Maven
✅ Install Eclipse
✅ Download Selenium WebDriver
✅ Add required dependencies in pom.xml

## Steps to Set Up:

1. Clone the repository:
```bash
git clone https://github.com/rimad6949/TutorialNinjaProject.git
```
2. Open the project in your preferred IDE.
3. Ensure all dependencies are installed using Maven:
```bash
mvn clean install
```
4. Update the config.properties file with browser settings and test URLs.
5. Execute test cases using TestNG Runner.

## Running Tests

### To run tests using TestNG, execute:
```bash
mvn test
```

### To generate an Extent Report, check the test-output folder after execution.

## Reporting

After test execution, an Extent Report is generated at:

target/Extent_(currentdatetime).html

Open this file in a browser to view detailed execution results.

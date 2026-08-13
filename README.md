# Data-Driven Testing Framework

A practice automation project I built while learning software testing.
It runs the same login test with different data taken from an Excel file, and creates a simple HTML report of the results.

## Tools Used
- Java
- Selenium WebDriver
- TestNG
- Apache POI (to read Excel files)
- ExtentReports (to create HTML reports)
- Maven

## What This Project Does
- Reads test data (usernames and passwords) from an Excel file
- Runs the login test once for each row of data
- Tests valid, invalid, and empty login attempts
- Generates an HTML report showing which tests passed or failed
- Takes a screenshot automatically when a test fails

## How to Run
1. Clone this repository
2. Open the folder in VS Code
3. In the terminal, run: `mvn clean test`
4. Open the report in the reports folder to see the results

## Author
Padmavathy Arumugam

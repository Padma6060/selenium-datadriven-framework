# Data-Driven Test Automation Framework with Reporting

A **data-driven** Selenium framework that runs the same test across many sets of input data
from an Excel file, and generates a professional **HTML report** with screenshots on failure.
Built with **Selenium, Java, TestNG, Apache POI and ExtentReports**.

![Java](https://img.shields.io/badge/Java-21-orange)
![Selenium](https://img.shields.io/badge/Selenium-4-green)
![TestNG](https://img.shields.io/badge/TestNG-7-red)
![Apache POI](https://img.shields.io/badge/Apache%20POI-Excel-yellow)
![ExtentReports](https://img.shields.io/badge/Reporting-ExtentReports-blueviolet)

## Overview

This framework tests a login form against multiple username/password combinations read from an
Excel sheet — so one test method automatically runs once per data row. It demonstrates
real-world testing practices: external test data, data-driven execution, HTML reporting, and
automatic failure screenshots.

## Tech Stack

| Tool | Purpose |
|------|---------|
| Java 21 | Programming language |
| Selenium WebDriver 4 | Browser automation |
| TestNG DataProvider | Feeds each Excel row into the test |
| Apache POI | Reads test data from Excel (.xlsx) |
| ExtentReports | Generates HTML execution reports |
| Maven | Build & dependency management |

## Features

- **Data-driven testing** — one test runs across many input sets from `testdata/logins.xlsx`
- **HTML reports** — clear pass/fail results with timestamps via ExtentReports
- **Screenshot on failure** — captures and attaches a screenshot whenever a test fails
- Positive and negative login scenarios (valid, invalid, locked-out, empty fields)

## Project Structure

```
selenium-datadriven-framework/
├── pom.xml
├── .gitignore
├── README.md
├── testdata/
│   └── logins.xlsx             # Test data (username, password, expectedResult)
└── src/
    ├── main/java/pages/        # Page Object classes
    ├── main/java/utils/        # BaseTest, ExcelReader, ScreenshotUtil
    └── test/java/tests/        # Data-driven TestNG tests
```

## Sample Test Data (logins.xlsx)

| username | password | expectedResult |
|----------|----------|----------------|
| standard_user | secret_sauce | success |
| locked_out_user | secret_sauce | error |
| invalid_user | wrong_pass | error |

## Prerequisites

- Java (JDK 21) installed
- Maven installed
- Google Chrome (Selenium 4 manages the driver automatically)

## How to Run

```bash
mvn clean test
```

After the run, open the generated HTML report (in the `/reports` or `/test-output` folder)
to view results and any failure screenshots.

## Key Concept — DataProvider

A TestNG `@DataProvider` reads every row from the Excel file and supplies it to the test
method. TestNG then runs the test once per row automatically, so adding a new scenario is as
simple as adding a new row to the spreadsheet.

## Author

**Padmavathy Arumugam** · [github.com/Padma6060](https://github.com/Padma6060)

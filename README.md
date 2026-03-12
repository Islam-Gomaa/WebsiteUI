# Wakeb Website Automation Framework

UI Automation Testing Framework built using **Java, Selenium WebDriver, TestNG, and Maven** following the **Page Object Model (POM)** design pattern and automation best practices.

This framework is designed to be **scalable, maintainable, and environment-driven**, suitable for real-world automation projects.

---

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Allure Reports
- Page Object Model (POM)

---

## Project Structure

```
src
├── main
│   ├── java
│   │   ├── pages
│   │   ├── reporting
│   │   ├── listeners
│   │   └── utilities
│   │          ├── ConfigReader
│   │          ├── DriverFactory
│   │          ├── ElementActions
│   │          ├── ScreenRecorderUtil
│   │          ├── TestReportUtil
│   │          ├── Waits
│   │
│   └── resources
│       ├── Configuration.properties
│       ├── stage.properties
│       ├── uat.properties
│       └── prod.properties
│
└── test
    ├── java
    │   ├── base
    │   ├── tests
    │   ├── dataReader
    │   ├── utils
    │   └── data
    │
    └── resources
        └── TestData
             ├── prod
             ├── stage
             └── uat
```

---

## Environment Configuration

The framework supports multiple environments:

- **stage**
- **uat**
- **prod**

Environment settings are controlled using property files inside:

```
src/main/resources
```

---

### Configuration.properties

Defines the default environment and general framework settings.

```
environment=stage
browser=chrome
timeout=10
polling=500
```

---

### Example: stage.properties

Each environment has its own configuration file.

```
baseUrl=https://dashboard-stg.wakeb.tech/
username=root@wakeb.com
password=123456
```

---

## Running Tests

### Run all tests

Runs tests using the default environment defined in `Configuration.properties`.

```
mvn test
```

---

### Run tests on a specific environment

You can override the default environment using Maven command line.

Run on **Stage**

```
mvn test -Denv=stage
```

Run on **UAT**

```
mvn test -Denv=uat
```

Run on **Production**

```
mvn test -Denv=prod
```

---

### Run a specific test suite

Run **Regression Suite**

```
mvn test -DsuiteXmlFile=regression.xml
```

Run **Smoke Suite**

```
mvn test -DsuiteXmlFile=smoke.xml
```

---

### Example Full Command

```
mvn test -Denv=uat -DsuiteXmlFile=regression.xml
```

This command will:

1. Load `uat.properties`
2. Start the configured browser
3. Execute the selected test suite
4. Generate test reports

---

## Test Execution Flow

1. `BaseTests` initializes WebDriver
2. Browser configuration is loaded from properties
3. Base URL is loaded based on the selected environment
4. Tests run using Page Objects
5. Reports are generated after execution

---

## Reporting

The framework supports **Allure Reporting**.

Generate the report using:

```
allure serve allure-results
```

---

## Best Practices Used

- Page Object Model (POM)
- Reusable Element Actions
- Centralized configuration
- Environment-based execution
- Clean and maintainable code structure
- Scalable automation framework

---

## Author

Islam Gomaa  
Senior QA Automation Engineer
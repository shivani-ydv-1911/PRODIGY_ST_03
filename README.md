# 🧪 PRODIGY_ST_03: Automated Login Test for Web Application (Java + Selenium + TestNG)

[![Java 17](https://img.shields.io/badge/Java-17-blue?logo=openjdk)](https://www.oracle.com/java/)
[![Selenium WebDriver](https://img.shields.io/badge/Selenium-4.27.0-green?logo=selenium)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.10.2-red)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven)](https://maven.apache.org/)
[![Tests](https://img.shields.io/badge/Tests-10%2F10%20Passed-brightgreen)](#-test-results-summary)
[![Internship Track](https://img.shields.io/badge/Prodigy%20InfoTech-Software%20Testing-blue)](https://prodigyinfotech.dev/)

This repository contains the completed **Task-03** for the **Software Testing Internship** at **Prodigy InfoTech**.

---

## 📌 Task Overview

- **Task ID:** Task-03
- **Title:** Automated Login Test for a Web Application
- **Target Web App:** [SauceDemo (Swag Labs)](https://www.saucedemo.com/)
- **Core Technology:** **Java 17, Selenium WebDriver, TestNG, Maven**
- **Core Goal:** Build an automated end-to-end test suite that verifies login functionality under both normal and edge-case conditions, including positive test cases (valid credentials) and negative test cases (invalid credentials, empty inputs, locked-out accounts).

---

## 🏗️ Architecture: Page Object Model (POM)

The test suite follows the industry-standard **Page Object Model (POM)** design pattern in Java:

```
PRODIGY_ST_03/
├── pom.xml                                           # Maven dependencies & plugins
├── src/
│   ├── main/java/com/prodigy/pages/
│   │   └── LoginPage.java                            # POM: Locators & actions for Login/Logout
│   └── test/
│       ├── java/com/prodigy/tests/
│       │   └── LoginTest.java                        # 10 TestNG Test Cases (Positive + Negative)
│       └── resources/
│           └── testng.xml                            # TestNG Suite Configuration
├── run_tests.bat                                     # 1-Click execution script for Windows
├── mvn.cmd                                           # Maven CLI wrapper
├── INSTRUCTIONS.md                                   # Complete Hindi + English guide for interns
└── README.md                                         # Project documentation
```

---

## 🧪 Test Cases Specification

Total **10 Automated Test Cases** covering all functional and boundary requirements:

### ✅ Positive Scenarios (Valid Credentials)
| Test ID | Scenario | Input Data | Expected Result |
| :--- | :--- | :--- | :--- |
| **TC-01** | Valid Standard User Login | `standard_user` / `secret_sauce` | Successfully redirected to `/inventory.html`, 'Products' header displayed. |
| **TC-02** | Performance Glitch User Login | `performance_glitch_user` / `secret_sauce` | Successfully logs in despite simulated response delay. |
| **TC-03** | User Logout Flow | `standard_user` / `secret_sauce` | Logs in, opens hamburger menu, clicks logout and returns to login page. |

### ❌ Negative Scenarios (Invalid Credentials & Empty Fields)
| Test ID | Scenario | Input Data | Expected Error Message |
| :--- | :--- | :--- | :--- |
| **TC-04** | Invalid Username | `invalid_user_123` / `secret_sauce` | `Username and password do not match any user in this service` |
| **TC-05** | Invalid Password | `standard_user` / `wrong_password_999` | `Username and password do not match any user in this service` |
| **TC-06** | Invalid Username & Password | `fake_user` / `fake_password` | `Username and password do not match any user in this service` |
| **TC-07** | Empty Username | *[Empty]* / `secret_sauce` | `Username is required` |
| **TC-08** | Empty Password | `standard_user` / *[Empty]* | `Password is required` |
| **TC-09** | Both Fields Empty | *[Empty]* / *[Empty]* | `Username is required` |
| **TC-10** | Locked-out User Account | `locked_out_user` / `secret_sauce` | `Sorry, this user has been locked out.` |

---

## 🚀 Quick Start Guide (How to Run in Java)

### Prerequisites
- **Java JDK 17+** installed (`java -version`)
- **Google Chrome** browser installed

### 1. Run Tests (One-Click)
Windows par project folder me `run_tests.bat` file par double click karein, ya terminal me run karein:
```bash
.\run_tests.bat
```
Ya direct Maven command chalayein:
```bash
.\mvn.cmd clean test
```

### 2. View TestNG HTML Report
Test complete hone ke baad detailed report yahan generate hoti hai:
```text
target/surefire-reports/index.html
```
Is file ko kisi bhi browser (Chrome/Edge) me open karke aap status, execution time, aur passed tests ka visual report dekh sakte hain.

---

## 📊 Test Results Summary

```text
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running TestSuite

[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 41.71 s -- in TestSuite
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

---

## 📄 License
This project is open-source under the MIT License. Created as part of the Prodigy InfoTech Software Testing Internship.

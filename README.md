# 🧪 PRODIGY_ST_03: Automated Login Test for Web Application

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
- **Repository:** [https://github.com/shivani-ydv-1911/PRODIGY_ST_03](https://github.com/shivani-ydv-1911/PRODIGY_ST_03)
- **Objective:** Build a robust automated end-to-end test suite that verifies user authentication flows under normal and boundary conditions, covering positive validation (standard user, delay user, logout flow) and negative validation (invalid credentials, missing fields, locked-out users).

---

## 🏗️ Architecture: Page Object Model (POM)

The test framework follows the industry-standard **Page Object Model (POM)** design pattern in Java:

```
PRODIGY_ST_03/
├── pom.xml                                           # Maven dependencies & surefire plugins
├── src/
│   ├── main/java/com/prodigy/pages/
│   │   └── LoginPage.java                            # POM: Locators & actions for Login/Logout
│   └── test/
│       ├── java/com/prodigy/tests/
│       │   └── LoginTest.java                        # 10 TestNG Test Cases (Positive + Negative)
│       └── resources/
│           └── testng.xml                            # TestNG Suite Configuration
├── run_task3.bat                                     # 1-Click execution script for Windows
├── INSTRUCTIONS.md                                   # Complete guide for internship submission
└── README.md                                         # Project documentation
```

---

## 🧪 Test Cases Specification

Total **10 Automated Test Cases** covering all functional, error handling, and session state requirements:

### ✅ Positive Scenarios (Valid Credentials)
| Test ID | Scenario | Input Data | Expected Result |
| :--- | :--- | :--- | :--- |
| **TC-01** | Valid Standard User Login | `standard_user` / `secret_sauce` | Successfully redirected to `/inventory.html`, 'Products' header displayed. |
| **TC-02** | Performance Glitch User Login | `performance_glitch_user` / `secret_sauce` | Successfully logs in despite simulated response delay. |
| **TC-03** | User Logout Flow | `standard_user` / `secret_sauce` | Logs in, opens sidebar menu, clicks logout, successfully returns to login page. |

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
- **Apache Maven** installed (or Maven wrapper)

### 1. Run Tests (One-Click)
Windows par `run_task3.bat` par double-click karein ya terminal me run karein:
```powershell
.\run_task3.bat
```
Ya direct Maven CLI se run karein:
```powershell
mvn clean test
```

### 2. View TestNG HTML Report
Execution complete hone ke baad detailed interactive report generate hoti hai:
```text
target/surefire-reports/index.html
```
Is file ko kisi bhi browser (Chrome/Edge) me open karke visual execution summary aur assertion status dekh sakte hain.

---

## 📊 Test Results Summary

```text
===============================================
Login Automation Test Suite
Total tests run: 10, Passes: 10, Failures: 0, Skips: 0
===============================================
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  28.520 s
[INFO] Finished at: 2026-10-25T18:06:21+05:30
[INFO] ------------------------------------------------------------------------
```

---

## 👩‍💻 Author
- **Shivani Yadav** - [shivani-ydv-1911](https://github.com/shivani-ydv-1911)
- Internship Track: **Software Testing at Prodigy InfoTech**

---

## 📄 License
This project is open-source under the MIT License.

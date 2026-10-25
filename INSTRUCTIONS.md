# 📋 Task 03 - Complete Guide & Step-by-Step Instructions (Java + Selenium + TestNG)

> **Yeh file special aapki friend ke liye banayi gayi hai**, taaki unhe poora Java test suite, Prodigy InfoTech ke rules, test cases, execution steps aur submission process bilkul clear samajh aa sake! 🎯

---

## 📌 Table of Contents (Index)
1. [Prodigy InfoTech Internship Rules & Guidelines](#1-prodigy-infotech-internship-rules--guidelines)
2. [Task-03 Overview & Requirements](#2-task-03-overview--requirements)
3. [Architecture: Page Object Model (POM) in Java](#3-architecture-page-object-model-pom-in-java)
4. [Detailed Test Cases Matrix (Positive & Negative)](#4-detailed-test-cases-matrix)
5. [How to Run the Tests in Java (Step-by-Step)](#5-how-to-run-the-tests-in-java-step-by-step)
6. [How to View the TestNG HTML Test Report](#6-how-to-view-the-testng-html-test-report)
7. [GitHub Repository Setup & Push Guide (`PRODIGY_ST_03`)](#7-github-repository-setup--push-guide)
8. [LinkedIn Post Template (Mandatory Step)](#8-linkedin-post-template-mandatory-step)
9. [Submission Form Checklist](#9-submission-form-checklist)

---

## 1. Prodigy InfoTech Internship Rules & Guidelines

Internship guidelines ke according yeh rules follow karna zaroori hai:

| Rule | Details |
| :--- | :--- |
| **Start Date** | Task sirf tab shuru karein jab aapki Offer Letter me di gayi **Internship Start Date** aa jaye. |
| **Certificate Rule** | **Completion Certificate** paane ke liye minimum **2 Tasks** complete karna zaroori hai. |
| **LoR (Letter of Recommendation)** | **LoR** paane ke liye **4 Tasks** complete karna zaroori hai. |
| **GitHub Repo Name** | Naming format compulsory hai: `PRODIGY_TrackCode_TaskNumber`<br>👉 Software Testing Track ke liye: **`PRODIGY_ST_03`** (ST = Software Testing). |
| **Public Repository** | GitHub repository **Public** honi chahiye taaki Prodigy team inspect kar sake. |
| **LinkedIn Post** | Har task complete karne ke baad **LinkedIn par post share karna MANDATORY hai** jisme task overview aur learning points mention ho. |
| **Submission Form** | Internship month ke beech me task submission form email par aata hai jisme GitHub repo link aur LinkedIn post link submit karni hoti hai. |

---

## 2. Task-03 Overview & Requirements

- **Task Name:** Automated Login Test for a Web Application
- **Target Application:** [SauceDemo (Swag Labs)](https://www.saucedemo.com/)
- **Core Technology:** **Java 17, Selenium WebDriver, TestNG, Maven**
- **Core Objective:** Ek robust automated test suite create karna jo web application ke login functionality ko thoroughly test kare.
- **Mandatory Requirements:**
  1. **Positive Test Cases:** Valid credentials ke saath successful login aur inventory page check karna.
  2. **Negative Test Cases:** 
     - Invalid username
     - Invalid password
     - Both credentials invalid
     - Empty username field
     - Empty password field
     - Both fields empty
     - Locked-out account handling
  3. Proper assertion of error messages and post-login UI states.

---

## 3. Architecture: Page Object Model (POM) in Java

Project ko standard **Page Object Model (POM)** design pattern par banaya gaya hai:

```
PRODIGY_ST_03/
├── pom.xml                                           # Maven dependencies (Selenium, TestNG, WebDriverManager)
├── src/
│   ├── main/java/com/prodigy/pages/
│   │   └── LoginPage.java                            # POM Class: Locators & actions for Login/Logout
│   └── test/
│       ├── java/com/prodigy/tests/
│       │   └── LoginTest.java                        # 10 Test Cases using TestNG Annotations
│       └── resources/
│           └── testng.xml                            # TestNG Suite Configuration
├── run_tests.bat                                     # 1-Click execution script for Windows
├── mvn.cmd                                           # Maven wrapper for easy execution
├── INSTRUCTIONS.md                                   # Complete Hindi + English guide
└── README.md                                         # Project documentation for GitHub
```

### Why Page Object Model (POM)?
- **Clean Separation:** `LoginPage.java` me sirf page ke locators (buttons, inputs) aur methods hote hain, jabki `LoginTest.java` me sirf test logic aur assertions hote hain.
- **Easy Maintenance:** Agar SauceDemo ka button ya text field change ho, toh sirf ek jagah change karna hota hai.
- **Industry Standard:** Har enterprise software company me automation testing POM pattern par hi likhi jaati hai.

---

## 4. Detailed Test Cases Matrix

Total **10 Automated Test Cases** include kiye gaye hain:

| Test ID | Test Category | Scenario Description | Inputs (Username / Password) | Expected Outcome |
| :--- | :--- | :--- | :--- | :--- |
| **TC-01** | Positive | Standard Valid Login | `standard_user` / `secret_sauce` | Redirects to `/inventory.html`, 'Products' header visible. |
| **TC-02** | Positive | Performance Glitch User Login | `performance_glitch_user` / `secret_sauce` | Successful login even with simulated server delay. |
| **TC-03** | Positive | User Logout Flow | `standard_user` / `secret_sauce` | Successfully logs out and redirects back to login page. |
| **TC-04** | Negative | Invalid Username | `invalid_user_123` / `secret_sauce` | Error: `Username and password do not match any user in this service` |
| **TC-05** | Negative | Invalid Password | `standard_user` / `wrong_password_999` | Error: `Username and password do not match any user in this service` |
| **TC-06** | Negative | Both Credentials Invalid | `fake_user` / `fake_password` | Error: `Username and password do not match any user in this service` |
| **TC-07** | Negative | Empty Username | *[Empty]* / `secret_sauce` | Error: `Username is required` |
| **TC-08** | Negative | Empty Password | `standard_user` / *[Empty]* | Error: `Password is required` |
| **TC-09** | Negative | Both Fields Empty | *[Empty]* / *[Empty]* | Error: `Username is required` |
| **TC-10** | Negative | Locked Out User Account | `locked_out_user` / `secret_sauce` | Error: `Sorry, this user has been locked out.` |

---

## 5. How to Run the Tests in Java (Step-by-Step)

### Option 1: 1-Click Batch File (Sabse Aasan)
Windows explorer me project folder kholein aur **`run_tests.bat`** file par double click karein.
Yeh automatically tests compile karke run kar dega aur result screen par show karega!

### Option 2: Terminal / Command Prompt se Run Karna
1. Project directory me terminal kholein (`Ctrl + ~` in VS Code).
2. Command run karein:
   ```bash
   .\mvn.cmd clean test
   ```
   *(Agar system me global Maven installed hai toh direct `mvn clean test` bhi likh sakte hain).*

---

## 6. How to View the TestNG HTML Test Report

Tests execute hone ke baad TestNG automatically report generate karta hai:
- Report Location: **`target/surefire-reports/index.html`**
- Is file ko Chrome ya kisi bhi browser me open karein.
- Aapko ek dashboard dikhega jisme **10 Passed, 0 Failed, 0 Skipped** aur execution time details hongi.

---

## 7. GitHub Repository Setup & Push Guide

Internship rule ke mutabiq repository ka naam **`PRODIGY_ST_03`** hona chahiye:

1. [GitHub](https://github.com/) par jayein aur **New Repository** banayein.
2. Name daalein: **`PRODIGY_ST_03`**
3. Visibility: **Public**
4. Terminal me yeh commands run karein:

```bash
git init
git add .
git commit -m "feat: completed task 3 automated login test suite in Java Selenium TestNG"
git branch -M main
git remote add origin https://github.com/<YOUR_GITHUB_USERNAME>/PRODIGY_ST_03.git
git push -u origin main
```
*(Note: `<YOUR_GITHUB_USERNAME>` ko apne actual GitHub username se replace karein).*

---

## 8. LinkedIn Post Template (Mandatory Step)

Prodigy InfoTech ke rules ke mutabiq LinkedIn par post share karna zaroori hai. Direct yeh template copy-paste kar sakti hain:

```markdown
🚀 Excited to share that I have completed Task-03 of my Software Testing Internship at Prodigy InfoTech!

📌 Task Title: Automated Login Test for a Web Application
🌐 Target Website: SauceDemo (https://www.saucedemo.com/)
🛠️ Tech Stack: Java 17, Selenium WebDriver, TestNG, Maven, Page Object Model (POM)

Key Highlights of this Project:
✅ Designed an enterprise-grade automated test framework using Page Object Model (POM) pattern for high maintainability.
✅ Developed 10 comprehensive test scenarios covering:
   - Positive Scenarios (standard user login, performance glitch user, session logout flow)
   - Negative Scenarios (invalid usernames/passwords, empty field validations, locked-out user account handling)
✅ Automated element locators, explicit waits, and dynamic error banner assertions.
✅ Configured TestNG suite execution and generated detailed HTML execution reports.

📂 GitHub Repository: https://github.com/<YOUR_GITHUB_USERNAME>/PRODIGY_ST_03

A big thank you to Prodigy InfoTech for providing this practical learning platform to strengthen my automation testing and QA engineering skills!

#ProdigyInfoTech #SoftwareTesting #Java #Selenium #TestNG #QualityAssurance #AutomationTesting #Internship #QAEngineering
```

---

## 9. Submission Form Checklist

Form submit karne se pehle verify kar lein:
- [x] Repository ka naam exact `PRODIGY_ST_03` hai.
- [x] Repository Public hai.
- [x] `README.md` aur Java test suite files maujood hain.
- [x] Saare 10 test cases successfully pass ho rahe hain (10/10).
- [x] LinkedIn post share kar diya gaya hai.

---
**All set! Task-03 in Java 100% complete! 🚀**

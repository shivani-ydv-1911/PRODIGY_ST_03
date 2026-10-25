@echo off
setlocal
set "SCRIPT_DIR=%~dp0"
echo ====================================================
echo  PRODIGY_ST_03: Automated Login Testing on SauceDemo
echo  Language: Java 17 + Selenium WebDriver + TestNG
echo ====================================================
echo.
echo Running automated login test suite...
call "%SCRIPT_DIR%..\mvn.cmd" -f "%SCRIPT_DIR%pom.xml" clean test
echo.
echo Test Execution Finished!
echo Report available at: %SCRIPT_DIR%target\surefire-reports\index.html
pause

# BakeryRobot for BAKERY

NoraUi, for NOn-Regression Automation for User Interfaces, is a Java framework based on Selenium, Cucumber and Gherkin stack to create GUI testing projects that can be included in the continuous integration chain of single/multi applications web solution builds.
It ensures applications non-regression throughout their life taking into account code evolutions and acceptance of defined business client criteria.

# Exploitation

* On "Goal" of Build part:  ```clean test javadoc:javadoc -Dcucumber.options="--tags '@loginLogout'" -Pjavadoc,preIC,scenarioInitiator,ci,unit-tests,postIC,analyze -Dmaven.test.failure.ignore=true sonar:sonar```
* More information on https://noraui.github.io

# LICENSE

* BakeryRobot generated free by NoraUi Organization https://github.com/NoraUi
* BakeryRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE

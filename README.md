# BakeryRobot for BAKERY

NoraUi, for NOn-Regression Automation for User Interfaces, is a Java framework based on Selenium, Cucumber and Gherkin stack to create GUI testing projects that can be included in the continuous integration chain of single/multi applications web solution builds.
It ensures applications non-regression throughout their life taking into account code evolutions and acceptance of defined business client criteria.

# Exploitation

* On "Goal" of Build part:  ```clean test javadoc:javadoc -Dcucumber.options="--tags '@loginLogout'" -Pjavadoc,preIC,scenarioInitiator,ci,unit-tests,postIC,analyze -Dmaven.test.failure.ignore=true sonar:sonar```
* More information on https://noraui.github.io

# Continuous Integration status
[![Build Status](https://travis-ci.org/NoraUi/bakery-robot.svg?branch=master)](https://travis-ci.org/NoraUi/NoraUi)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.github.noraui%3Abakery-robot&metric=alert_status)](https://sonarcloud.io/dashboard/index/com.github.noraui:bakery-robot)
[![SonarCloud Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.github.noraui%3Abakery-robot&metric=coverage)](https://sonarcloud.io/component_measures/metric/coverage/list?id=com.github.noraui:bakery-robot)
[![SonarCloud Bugs](https://sonarcloud.io/api/project_badges/measure?project=com.github.noraui%3Abakery-robot&metric=bugs)](https://sonarcloud.io/component_measures/metric/reliability_rating/list?id=com.github.noraui%3Abakery-robot)
[![SonarCloud Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=com.github.noraui%3Abakery-robot&metric=vulnerabilities)](https://sonarcloud.io/component_measures/metric/security_rating/list?id=com.github.noraui%3Abakery-robot)

# LICENSE

* BakeryRobot generated free by NoraUi Organization https://github.com/NoraUi
* BakeryRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE

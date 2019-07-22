@loginLogout
Feature: loginLogout (Scenario that 1st sample. Is it a login and logout on a JHipster sample.) 

  Scenario Outline:  Scenario that 1st sample. Is it a login and logout on a JHipster sample.

    Given I check that 'user' '<user>' is not empty
    Given I check that 'password' '<password>' is not empty

    Given 'BAKERY_HOME' is opened
    Then The BAKERY home page is displayed

    When I log in to BAKERY as '<user>' '<password>'
    Then The BAKERY portal is displayed

    When I log out of BAKERY
    Then The BAKERY logout page is displayed

    And I go back to 'BAKERY_HOME'
  Examples:
    #DATA
    |id|user|password|
    #END

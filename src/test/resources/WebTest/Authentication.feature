Feature: Heroku Website Authentication
  As a customer, login to heroku website with appropriate credentials

  #Scenario Outline: Successful login to Heroku with appropriate credentials
  #  Given I navigate to Web Application
  #  When I click on Login button
  #  And I enter <Username> and <Password> to login
  #  And I click log in button
  #  Then I see the Heroku home page
  #
  #  Examples:
  #    | Username              | Password     |
  #    | sumas@oxfam.org.au    | Oxfam@132    |

  Scenario Outline: Unsuccessful login to Heroku with appropriate credentials
    Given I navigate to Web Application
    When I click on Login button
    And I enter <Username> and <Password> to login
    And I click log in button
    Then I see incorrect credentials error message

    Examples:
      | Username              | Password     |
      | sumas@oxfam.org.au    | incorrect    |
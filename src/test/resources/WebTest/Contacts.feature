Feature: Set Supporter Level as High Value and verify the details
  As a Salesforce user, login to Salesforce and set Supporter Level as "High Value" and Verify
  the details

  #Scenario Outline: Login to Salesforce URL and Set Supporter level as High Value
  #  Given I login to Salesforce URLt
  #
  #  Examples:
  #    | First Name | Last Name | Salutation | Phone      |
  #    | Oxfam      | Australia | Mr         | 0453613708 |

  Scenario Outline: Update and view contact details
    Given I navigate to Web Application
    When I click on Login button
    And I enter username and password under sign in page
    And I click log in button
    When I navigate to Update Info & Contact
    And I update the <Title> <Mobile> <Home> <Work> <Street> <City> <Postcode> <State> <Country> and click on Update
    Then I see updated banner on the screen
    When I navigate to Home screen
    And I navigate to Update Info & Contact
    Then I see new updated <Title> <Mobile> <Home> <Work> <Street> <City> <Postcode> <State> <Country> on screen

    Examples:
      | Title | Mobile     | Home      | Work      | Street           | City      | Postcode | State | Country   |
      | Mr    | 678345123  | 012345678 | 045678900 | Leicester        | Melbourne | 3000     | VIC   | Australia |


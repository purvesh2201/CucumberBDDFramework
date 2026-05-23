Feature: Login feature for OrangeHRM application

  Scenario Outline: Successful login with valid credentials
    Given I am on the OrangeHRM login page
    When I enter valid "<username>" and "<password>"
    And I click on the login button
    Then I should be redirected to the Home page
    Examples:
      | username | password |
      | admin    | admin123 |


  Scenario Outline: Unsuccessful login with invalid credentials
    Given I am on the OrangeHRM login page
    When I enter invalid "<username>" and "<password>"
    And I click on the login button
    Then I should see an "<error_message>" indicating invalid credentials
    Examples:
      | username    | password    | error_message       |
      | invalidUser | invalidPass | Invalid credential  |
      | validUser   | invalidPass | Invalid credentials |
      | invalidUser | validPass   | Invalid credentials |


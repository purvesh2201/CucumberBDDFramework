Feature: Employee Page feature for OrangeHRM application

  Background:
    Given I am logged into OrangeHRM
    And I navigate to the Employee page

  Scenario Outline: Add a new employee
    When I click on the "Add Employee" button
    And I fill in the employee details with "<first_name>","<mid_name>", "<last_name>" and "<employee_id>"
    And I click on the "Save" button
    Then I should see a confirmation message indicating that the employee has been added successfully
    Examples:
      | first_name | mid_name | last_name | employee_id |
      | John       | joseph   | Doe       | 000034      |
      | Jane       | jeene    | Smith     | 000035       |

  Scenario Outline: Delete a employee
    When I search for the employee with "<employee_id>"
    And I click on the "Delete" button for that employee
    Then I should see a confirmation message indicating that the employee has been deleted successfully
    Examples:
      | employee_id |
      | 000034      |
      | 000035      |

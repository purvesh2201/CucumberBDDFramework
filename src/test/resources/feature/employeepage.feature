Feature: Employee Page feature for OrangeHRM application

 Scenario Outline: Add a new employee
    Given I am on the Employee page
    When I click on the "Add Employee" button
    And I fill in the employee details with "<first_name>", "<last_name>", and "<employee_id>"
    And I click on the "Save" button
    Then I should see a confirmation message indicating that the employee has been added successfully
    Examples:
      | first_name | last_name | employee_id |
      | John       | Doe       | 12345       |
      | Jane       | Smith     | 67890       |
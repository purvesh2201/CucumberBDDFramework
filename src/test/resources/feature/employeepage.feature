Feature: Employee Page feature for OrangeHRM application

  Background:
    Given I am logged into OrangeHRM
    And I navigate to the Employee page

  Scenario Outline: Add and delete employee
    When I click on the "Add Employee" button
    And I fill in the employee details with "<first_name>","<mid_name>", "<last_name>" and "<employee_id>"
    And I click on the "Save" button
    Then I should see a confirmation message indicating that the employee has been added successfully

    When I search for the employee with "<employee_id>"
    And I click on the delete button for that employee
    Then I should see a confirmation message indicating that the employee has been deleted successfully

    Examples:
      | first_name | mid_name | last_name | employee_id |
      | Test1      | Test2    | Test3     | Test002     |
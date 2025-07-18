Feature: ParaBank Registration and Login

  As a new user of ParaBank
  I want to create an account to register my credentials
  So that I can access the ParaBank services

  Background:
    Given the user opens the ParaBank home page

  Scenario: Successful registration and login
    When the user selects "Register" and submits valid data:
      | firstName | lastName   | address     | city  | state | zipCode | phone        | ssn     | username         | password       |
      | Rodrigo   | Castiblanco| Calle 132   | Bogota| Bogota| 123456  | 32123456789  | 123456  | auto-generated   | auto-generated |
    Then the user should see a successful registration message
    And selects "Log Out"
    When the user logs in with the generated credentials
    Then the user should see the account overview page

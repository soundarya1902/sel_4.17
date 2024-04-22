Feature: Login to HRM Application

  Background:
    Given User is on HRMLogin page

  @ValidCredentials
  Scenario: Login with valid credentials
    When User enters cred
    Then User should be able to login

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials

    When User enters cred invalid cred "<username>" and "<password>"
    Then User should be able to see error message

    Examples:
      | username | password  |
      | Admin    | admin12$$ |

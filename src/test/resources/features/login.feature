Feature: Login

  Background:
    Given user is on landingpage

  @ValidCredentials
  Scenario: valid login
    When User enters cred

  @InvalidCredentials
  Scenario Outline: invalid login

    When User enters cred invalid cred "<username>" and "<password>"
    Then User should be able to see error message

    Examples:
      | username      | password  |
      | sou@gmail.com | admin12$$ |
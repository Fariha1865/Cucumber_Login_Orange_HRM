Feature: User Login

  Scenario Outline: User can login with valid username and password
    Given User visited the portal
    When User inputs valid "<username>" and "<password>"
    Then User can see dashboard

    Examples:
      | username | password |
      | Admin    | admin123      |

  Scenario Outline: User can not login with invalid username and password
    Given User visited the portal
    When User inputs invalid "<username>" and "<password>"
    Then User can see error message

    Examples:
      | username | password |
      | admin    | 123      |


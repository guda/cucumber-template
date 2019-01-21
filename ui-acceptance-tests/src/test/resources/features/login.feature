Feature: Login

  Background:
    Given Product details page is displayed "https://app-framework-staging.expressfinanzierung.bawagpsk.com/at/bawaglogin"
    When The customer clicks on close button
    Then The login page is displayed


#  Scenario: Successfully login
#    When The customer inserts "9631570" as Verfugernummer
#    And The customer inserts "74123Pin" as PIN
#    And The customer clicks on login button
#    Then PreQualification page is displayed

#  Scenario Outline: Unsuccessful login with valid/invalid/invalid disposer number and invalid/valid/invalid PIN
#    When The customer inserts "<disposerNumber>" as Verfugernummer
#    And The customer inserts "<pin>" as PIN
#    And The customer clicks on login button
#    Then An error message is shown for invalid credentials "Verfügernummer oder PIN ungültig"
#    Examples:
#        |disposerNumber |pin |
#        |9631570        |11111Pin|
#        |1111112        |74123Pin|
#        |1111112        |11111Pin|

  Scenario: Unsuccessful login - valid disposer number and empty 'PIN' field
    When The customer inserts "9631570" as Verfugernummer
    And The customer inserts "" as PIN
    And The customer clicks on login button
    Then An error message is shown for required password "PIN erforderlich"

  Scenario: Unsuccessful login - empty 'Disposer Number' field and valid PIN
    When The customer inserts "" as Verfugernummer
    And The customer inserts "74123Pin" as PIN
    And The customer clicks on login button
    Then An error message is shown for required disposer number "Verfügernummer erforderlich"

  Scenario: Unsuccessful login - empty 'Disposer Number' and 'PIN' fields
    When The customer inserts "" as Verfugernummer
    And The customer inserts "" as PIN
    And The customer clicks on login button
    Then Error messages are shown for required disposer number "Verfügernummer erforderlich" and required password "PIN erforderlich"

  Scenario: Unsuccessful login - Locked account (when customer tries to login 5 times in a row with invalid PIN and valid disposer number)
    When The customer inserts "938706900" as Verfugernummer
    And The customer inserts "74123Pin" as PIN
    And The customer clicks on login button
    Then An error message is shown for invalid credentials "Verfügernummer oder PIN ungültig"
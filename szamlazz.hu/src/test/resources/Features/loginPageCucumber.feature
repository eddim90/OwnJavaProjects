Feature: Login Page tests

  Scenario: Validating the login page button
    Given I go to the home "http://szamlazz.hu" page
    When  I click on "Belépés" button
    Then it redirects me to "https://www.szamlazz.hu/szamla/login" page

  Scenario: Try to login with wrong username and password.
    Given I go to the home "https://www.szamlazz.hu/szamla/login" page
    When  When I insert the "IncorrectUser" and "IncorrectPassword" and click on the "belépés" button
    Then Then error message should be the following:"Sikertelen bejelentkezés."

  Scenario: Try to login with correct username and wrong password.
    Given I go to the home "https://www.szamlazz.hu/szamla/login" page
    When  When I insert the "demo" and "IncorrectPassword" and click on the "belépés" button
    Then Then error message should be the following:"Sikertelen bejelentkezés."

  Scenario: Try to login with incorrect username but correct  password.
    Given I go to the home "https://www.szamlazz.hu/szamla/login" page
    When  When I insert the "IncorrectUser" and "demo" and click on the "belépés" button
    Then Then error message should be the following:"Sikertelen bejelentkezés."

  Scenario: Login with google account.
    Given I go to the home "https://www.szamlazz.hu/szamla/login" page
    When I choose and click on the "Bejelentkezés Google fiókkal" button
    Then I should see the "https://accounts.google.com/" in a new window

  Scenario: Login with facebook account.
    Given I go to the home "https://www.szamlazz.hu/szamla/login" page
    When The user choose and click on the "Bejelentkezés Facebook fiókkal" button
    Then I should see the facebook page "https://www.facebook.com/login" in a new window

  Scenario: Try to login with correct username and correct password.
    Given I go to the home "https://www.szamlazz.hu/szamla/login" page
    When  When I insert the "demo" and "demo" and click on the "belépés" button
    Then The system should let the user in

  Scenario: Registration button validation
    Given I go to the home "https://www.szamlazz.hu/szamla/login" page
    When The user finds and click on "Registration" button
    Then The user should see the "https://www.szamlazz.hu/szamla/?page=regisztracio" after redirection
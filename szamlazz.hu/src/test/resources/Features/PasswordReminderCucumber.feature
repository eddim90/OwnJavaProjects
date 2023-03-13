Feature: Password reminder page test

  Scenario: Loading in the page
    Given I am on the "https://www.szamlazz.hu/szamla/login" site
    When I click on the "Elfelejtetted a jelszavad?" button
    Then It redirects to the "https://www.szamlazz.hu/szamla/?page=forgetpassword"

  Scenario: Testing the wrong type of e-mail format
    Given I am on the "https://www.szamlazz.hu/szamla/?page=forgetpassword" page
    When the e-mail address field is "emailaddr" and I click on the send button
    Then the page "Ez nem tűnik valós e-mail címnek." pops up

  Scenario: Testing empty field of e-mail
    Given I am on the "https://www.szamlazz.hu/szamla/?page=forgetpassword" page
    When the e-mail address field is "" and I click on the send button
    Then the page "Érvénytelen email-cím!" pops up

  Scenario: Testing return button
    Given I am on the "https://www.szamlazz.hu/szamla/?page=forgetpassword" page
    When I try to click on the 'Vissza a bejelentkezéshez' button
    Then the page redirects "https://www.szamlazz.hu/szamla/?page=login" site
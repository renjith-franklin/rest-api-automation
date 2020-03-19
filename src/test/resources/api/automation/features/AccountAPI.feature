#Author: ramach@email.franklin.edu
#Keywords Summary :
#Feature: Account API
@Account
Feature: Account API should allow to create,update,delete and get a user.

  @CreateAccount
  Scenario Outline: Verify that user account can be created using email,password,first name,last name and gender
    Given the account API as "http://localhost:8080/WeatherAppService/rest/account"
    When I create a user using user name  "<username>" , password  "<password>",first name "<firstname>",last name "<lastname>" and gender "<gender>"
    Then I should get "200" http response for http post

    Examples: 
      | username           | password | firstname | lastname | gender |
      | api_auto1@test.com | abcd123  | API       | Auto 1   | M      |
      | api_auto2@test.com | abcd123  | API       | Auto 2   | M      |
      | api_auto3@test.com | abcd123  | API       | Auto 3   | M      |

  @GetAccount
  Scenario Outline: Verify that user account can be retrieved using email
    Given the account API as "http://localhost:8080/WeatherAppService/rest/account"
    When I get a user using user name  "<username>"
    Then I should get "200" http response for http get

    Examples: 
      | username           |
      | api_auto1@test.com |
      | api_auto2@test.com |
      | api_auto3@test.com |

  @UpdateAccount
  Scenario Outline: Verify that user account can be updated using email,password,first name,last name and gender
    Given the account API as "http://localhost:8080/WeatherAppService/rest/account"
    When I update a user using user name  "<username>" ,first name "<firstname>",last name "<lastname>" and gender "<gender>"
    Then I should get "200" http response for http put

    Examples: 
      | username           | firstname | lastname | gender |
      | api_auto1@test.com | API_New   | Auto 1   | M      |
      | api_auto2@test.com | API_New   | Auto 2   | M      |
      | api_auto3@test.com | API_New   | Auto 3   | M      |

  @DeleteAccount
  Scenario Outline: Verify that user account can be deleted using email
    Given the account API as "http://localhost:8080/WeatherAppService/rest/account"
    When I delete a user using user name  "<username>"
    Then I should get "200" http response for http delete

    Examples: 
      | username           |
      | api_auto3@test.com |

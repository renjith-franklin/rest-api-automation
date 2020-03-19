#Author: ramach@email.franklin.edu
#Keywords Summary :
#Feature: Auth API
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
@tag
Feature: Login API should return http response 200 when valid user logs in and 401 for invalid users.Log out API should return 200 for any user id

  @Login
  Scenario Outline: Verify that user can invoke login API for valid users
    Given the login API as "http://localhost:8080/WeatherAppService/rest/auth/login"
    When I login using user name  "<username>" and password  "<password>"
    Then I should get "200" http response

    Examples: 
      | username          | password |
      | testg@test.com    | abcd123  |
      | tnkjnk@test.com   | abcd123  |
      | testclass@645.com | abcd123  |

  @Login
  Scenario Outline: Verify that api returns error when invoke login API for invalid users
    Given the login API as "http://localhost:8080/WeatherAppService/rest/auth/login"
    When I login using user name  "<username>" and password  "<password>"
    Then I should get error "401" http response

    Examples: 
      | username          | password |
      | invalid1@test.com | abc123   |
      | invalid2@test.com | abc123   |
      | invalid3@test.com | abc123   |

  @Logout
  Scenario Outline: Verify that api returns success when invoke logout API
    Given the logout API as "http://localhost:8080/WeatherAppService/rest/auth/logout"
    When I logout using user name  "<username>"
    Then I should get error "401" http response

    Examples: 
      | username          |
      | testg@test.com    |
      | testclass@645.com |

#Author: ramach@email.franklin.edu
#Keywords Summary :
#Feature: Weather Info
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
@tag
Feature: Verify that Weather Information is returned by the API
  I want to use this feature to test an open source Weather API by passing city name

  @Weather
  Scenario: Verify that Weather Information can be fetched
    Given I want to perform get operation for "https://www.metaweather.com/api/location/search/?query="
    And I query for city "Columbus"
    When I complete action
    Then I should get the "title" as "Columbus"

Feature: Testing a Countries REST API
  As a user
  I want to be able to see all countries in the world
  So that I can then choose which country to see further details about

  Background:

    Given the countries services is running


  Scenario: Data retrival from a webservice
    When users want to get information on the all the countries
    Then the status code is OK
    Then requested data is returned with 250 countries


  Scenario Outline: Data retrival for a specfic country
      When user wants to get information about "<Country>"
      Then the response contains the following attributes:
      |attribute|value|
      |name     |Afghanistan|
      |capital  |Kabul     |
      |region   |Asia      |
      |numericCode|004     |

  Examples:
    |Country|
    |Afghanistan|







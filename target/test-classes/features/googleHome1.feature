Feature: google home page validation

  Background: 
    Given open a chrome browser
    Then launch a site "https://www.google.com"
    And check page title

  Scenario Outline: validate google search box
    When Enter a required "<data>" data into search
    And click on search button
    Then back to the prevoius page

    Examples: 
      | data     |
      | facebook |
      | amazon   |
      | flipkart |
      | ebay     |
      | mynthra  |
      | youtube  |

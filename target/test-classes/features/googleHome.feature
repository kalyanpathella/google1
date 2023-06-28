Feature: google home page validation

  Background: 
    Given open a chrome browser
    Then launch a site "https://www.google.com"
    And check page title

  Scenario Outline: 
    When click on search box
    Then enter some text "<data>" on search box
    And check given suggessions "<data>" are correct or not

    Examples: 
      | data           |
      | abdul kalam    |
      | mahatma gandhi |
      | amazon         |
      | flipkart       |
      | ebay           |
      | redbus         |

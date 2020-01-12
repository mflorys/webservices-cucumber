Feature: Verify methods for Posts

  Scenario: Verify getting all posts
    Given I call GET method for posts
    Then I can see that response code is '200'
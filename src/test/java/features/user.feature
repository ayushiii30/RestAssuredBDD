Feature: User API CRUD Operations

  #POST /users
  Scenario Outline: Create multiple users
    Given the API base URL is set
    When I create a user with name "<name>", username "<username>" and email "<email>"
    Then the response status code should be 201
    And the response should contain name "<name>"

  Examples: 
    | name   | username  | email               |
    | Ayushi | ayushi01  | ayushi01@gmail.com  |
    | Raj    | raj123    | raj@example.com     |
    | Priya  | priya01   | priya@example.com   |

  # GET /users/{id} 
  Scenario Outline: Get user details
    Given the API base URL is set
    When I send a GET request to "/users/<id>"
    Then the response status code should be 200
    And the response should contain user with id <id>

  Examples:
    | id |
    | 2  |
    | 3  |
    | 4  |

  # PUT /users/{id} 
  Scenario Outline: Update user details
    Given the API base URL is set
    When I update user with id <id> with name "<name>"
    Then the response status code should be 200
    And the response should contain name "<name>"

  Examples:
    | id | name        |
    | 1  | Ayushi Goyal|
    | 2  | Raj Kumar   |

  # DELETE /users/{id}
  Scenario Outline: Delete user
    Given the API base URL is set
    When I delete user with id <id>
    Then the response status code should be 200

  Examples:
    | id |
    | 1  |
    | 2  |

    
  

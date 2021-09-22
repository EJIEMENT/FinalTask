Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check the total product price
    Given User opens '<homePage>' page
    And User click on button my account
    And User click on button sign in
    And User login to application with '<email>' and '<password>'
    And User click on button Shop The Trend
    And User clicks on first product in list
    And User choose product size in size selector '<size>'
    And User click on button add to bag
    And User click on asos logo
    And User click on button cart logo
    And User click on button checkout
    Then User checks the total product price
    Examples:
      | homePage                  | size         | email                | password   |
      | https://www.asos.com/men/ | S - Chest 38 | ejiement11@gmail.com | EJI1189567 |

  Scenario Outline: Check size error message
    Given User opens '<homePage>' page
    And User click on button Shop The Trend
    And User clicks on first product in list
    And User click on button add to bag
    Then User checks that error message is '<errorMessage>'
    Examples:
      | homePage                  | errorMessage                                             |
      | https://www.asos.com/men/ | Please select from the available colour and size options |

  Scenario Outline: Check the availability of the product in the wish list
    Given User opens '<homePage>' page
    And User click on button Shop The Trend
    And User clicks on first product in list
    And User click on button add to wish list
    And User click on button wish list in top menu
    Then User checks availability of the product in the wish list
    Examples:
      | homePage                  |
      | https://www.asos.com/men/ |

  Scenario Outline: Check the availability of the product in the wish list
    Given User opens '<homePage>' page
    And User click on button Shop The Trend
    And User click on button add to wish list from product list
    And User click on button wish list in top menu
    And User click on button delete product from wish list
    Then User checks wish list is empty
    Examples:
      | homePage                  |
      | https://www.asos.com/men/ |


  Scenario Outline: Check the login error message
    Given User opens '<homePage>' page
    And User click on button my account
    And User click on button sign in
    And User login to application with '<email>' and '<password>'
    Then User checks login error message '<message>'
    Examples:
      | homePage                  | email                | password  | message                                                                           |
      | https://www.asos.com/men/ | ejiement11@gmail.com | EJI118956 | Looks like either your email address or password were incorrect. Wanna try again? |

  Scenario Outline: Check successful sign in
    Given User opens '<homePage>' page
    And User click on button my account
    And User click on button sign in
    And User login to application with '<email>' and '<password>'
    Then User checks that user is at home page
    Examples:
      | homePage                  | email                | password   |
      | https://www.asos.com/men/ | ejiement11@gmail.com | EJI1189567 |

  Scenario Outline: Check error message at join new user
    Given User opens '<homePage>' page
    And User click on button my account
    And User click on button join
    And User fill user data without name
    Then User checks validation error '<message>' message
    Examples:
      | homePage                  | message                                       |
      | https://www.asos.com/men/ | We need your first name – it’s nicer that way |

  Scenario Outline: Check the product price
    Given User opens '<homePage>' page
    And User click on button Shop The Trend
    And User clicks on first product in list
    Then User checks correct product price
    Examples:
      | homePage                  |
      | https://www.asos.com/men/ |

  Scenario Outline: Check visibility woman and men tab on home page
    Given User opens '<homePage>' page
    And User click on button my account
    And User click on button sign in
    And User login to application with '<email>' and '<password>'
    Then User checks men and woman button tab is present
    Examples:
      | homePage                  | email                | password   |
      | https://www.asos.com/men/ | ejiement11@gmail.com | EJI1189567 |

  Scenario Outline: Check items tab in user drop down menu
    Given User opens '<homePage>' page
    And User click on button my account
    And User click on button sign in
    And User login to application with '<email>' and '<password>'
    And User click on button my account
    Then User checks items in user drop down menu
    Examples:
      | homePage                  | email                | password   |
      | https://www.asos.com/men/ | ejiement11@gmail.com | EJI1189567 |
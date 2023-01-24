Feature: Make a coffee with a complete coffee machine
  A user want a coffee
  Scenario: A user plug the coffee machine and make a coffee Arabica
    Given a coffee machine with 0.10 l of min capacity, 3.0 l of max capacity, 600.0 l per h of water flow for the pump
    And a "mug" with a capacity of 0.25
    When I plug the machine to electricity
    And I add 1 liter of water in the water tank
    And I add 0.5 liter of "ARABICA" in the bean tank
    And I made a coffee "ARABICA"
    Then the coffee machine return a coffee mug not empty
    And a coffee volume equals to 0.25
    And a coffee "mug" containing a coffee type "ARABICA"


  Scenario: A user plug the coffee machine and make a coffee
    Given a coffee machine with 0.10 l of min capacity, 3.0 l of max capacity, 600.0 l per h of water flow for the pump
    And a "cup" with a capacity of 0.15
    When I plug the machine to electricity
    And I add 1 liter of water in the water tank
    And I add 0.5 liter of "ROBUSTA" in the bean tank
    And I made a coffee "ROBUSTA"
    Then the coffee machine return a coffee mug not empty
    And a coffee volume equals to 0.15
    And a coffee "cup" containing a coffee type "ROBUSTA"

  Scenario: A user plug the coffee machine and make a coffee
    Given a coffee machine with 0.20 l of min capacity, 3.0 l of max capacity, 600.0 l per h of water flow for the pump
    And a "mug" with a capacity of 0.20
    When I plug the machine to electricity
    And I add 0.5 liter of water in the water tank
    And I add 0.3 liter of "BAHIA" in the bean tank
    And I made a coffee "BAHIA"
    Then the coffee machine return a coffee mug not empty
    And a coffee volume equals to 0.20
    And a coffee "mug" containing a coffee type "BAHIA"

  Scenario: A user plug the coffee machine
    Given a coffee machine with 0.20 l of min capacity, 3.0 l of max capacity, 600.0 l per h of water flow for the pump
    When I plug the machine to electricity
    Then the coffee machine is plugged to electricity


  Scenario: A user plug the expresso coffee machine and make a coffee
    Given a expresso coffee machine with 0.20 l of min capacity, 3.0 l of max capacity, 600.0 l per h of water flow for the pump and a bean tank of min 0.10 l capacity, 30 l max capacity
    And a "mug" with a capacity of 0.20 l
    When I plug the expresso machine to electricity
    And I add 0.5 l of water in the water tank
    And I add 0.3 l of "BAHIA" in the bean tank
    And I made a expresso coffee "BAHIA"
    Then the expresso coffee machine return a coffee mug not empty
    And a expresso coffee volume equals to 0.20
    And a coffee "mug" containing a expresso coffee type "BAHIA"
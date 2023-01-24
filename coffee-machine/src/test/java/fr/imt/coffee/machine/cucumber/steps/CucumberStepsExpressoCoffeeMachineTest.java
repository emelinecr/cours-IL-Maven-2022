package fr.imt.coffee.machine.cucumber.steps;

import fr.imt.coffee.machine.CoffeeMachine;
import fr.imt.coffee.machine.EspressoCoffeeMachine;
import fr.imt.coffee.machine.exception.CannotMakeCremaWithSimpleCoffeeMachine;
import fr.imt.coffee.machine.exception.CoffeeTypeCupDifferentOfCoffeeTypeTankException;
import fr.imt.coffee.machine.exception.LackOfWaterInTankException;
import fr.imt.coffee.machine.exception.MachineNotPluggedException;
import fr.imt.coffee.storage.cupboard.coffee.type.CoffeeType;
import fr.imt.coffee.storage.cupboard.container.*;
import fr.imt.coffee.storage.cupboard.exception.CupNotEmptyException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class CucumberStepsExpressoCoffeeMachineTest {
    public EspressoCoffeeMachine espressoCoffeeMachine;
    public Mug expressoMug;
    public Cup expressoCup;
    public CoffeeContainer containerWithCoffee;

    @Given("a expresso coffee machine with {double} l of min capacity, {double} l of max capacity, {double} l per h of water flow for the pump and a bean tank of min {double} l capacity, {double} l max capacity")
    public void givenAEspressoCoffeeMachine(double minimalWaterCapacity, double maximalWaterCapacity, double pumpWaterFlow, double minBeanTank, double maxBeanTank){
        espressoCoffeeMachine = new EspressoCoffeeMachine(minimalWaterCapacity, maximalWaterCapacity, minBeanTank, maxBeanTank, pumpWaterFlow);
    }

    @And("a {string} with a capacity of {double} l")
    public void aWithACapacityOf(String containerType, double containerCapacity) {
        if ("mug".equals(containerType))
            expressoMug = new Mug(containerCapacity);
        if ("cup".equals(containerType))
            expressoCup = new Cup(containerCapacity);
    }

    @When("I plug the expresso machine to electricity")
    public void iPlugTheEspressoMachineToElectricity() {
        espressoCoffeeMachine.plugToElectricalPlug();
    }

    @And("I add {double} l of water in the water tank")
    public void iAddLitersOfWater(double waterVolume) {
        espressoCoffeeMachine.addWaterInTank(waterVolume);
    }

    @And("I add {double} l of {string} in the bean tank")
    public void iAddLitersOfCoffeeBeans(double beanVolume, String coffeeType) {
        espressoCoffeeMachine.addCoffeeInBeanTank(beanVolume, CoffeeType.valueOf(coffeeType));
    }

    @And("I made a expresso coffee {string}")
    public void iMadeAEspressoCoffee(String coffeeType) throws InterruptedException, CupNotEmptyException, LackOfWaterInTankException, MachineNotPluggedException, CoffeeTypeCupDifferentOfCoffeeTypeTankException, CannotMakeCremaWithSimpleCoffeeMachine {
        //On créé un mock de l'objet random
        Random randomMock = Mockito.mock(Random.class, Mockito.withSettings().withoutAnnotations());
        //On vient ensuite stubber la méthode nextGaussian pour pouvoir controler la valeur retournée
        //ici on veut qu'elle retourne 0.6
        Mockito.when(randomMock.nextGaussian()).thenReturn(0.6);
        //On injecte ensuite le mock créé dans la machine à café
        espressoCoffeeMachine.setRandomGenerator(randomMock);

        if (expressoMug != null)
            containerWithCoffee = espressoCoffeeMachine.makeACoffee(expressoMug, CoffeeType.valueOf(coffeeType));
        if (expressoCup != null)
            containerWithCoffee = espressoCoffeeMachine.makeACoffee(expressoCup, CoffeeType.valueOf(coffeeType));

    }

    @Then("the expresso coffee machine return a coffee mug not empty")
    public void theEspressoCoffeeMachineReturnACoffeeMugNotEmpty() {
        Assertions.assertFalse(containerWithCoffee.isEmpty());
    }

    @And("a expresso coffee volume equals to {double}")
    public void aEspressoCoffeeVolumeEqualsTo(double coffeeVolume) {
        assertThat(coffeeVolume, is(containerWithCoffee.getCapacity()));
    }

    @And("a coffee {string} containing a expresso coffee type {string}")
    public void aEspressoCoffeeMugContainingACoffeeType(String containerType, String coffeeType) {
        if ("mug".equals(containerType))
            assertThat(containerWithCoffee, instanceOf(CoffeeMug.class));
        if ("cup".equals(containerType))
            assertThat(containerWithCoffee, instanceOf(CoffeeCup.class));

        assertThat(containerWithCoffee.getCoffeeType(), is(CoffeeType.valueOf(coffeeType)));
    }

    @Then("the expresso coffee machine is plugged to electricity")
    public void aEspressoCoffeeMachineIsPluggedToElectricity(){
        Assertions.assertTrue(espressoCoffeeMachine.isPlugged());
    }

}

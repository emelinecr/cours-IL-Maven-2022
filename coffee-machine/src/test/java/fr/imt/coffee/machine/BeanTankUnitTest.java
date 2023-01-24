package fr.imt.coffee.machine;

import fr.imt.coffee.machine.component.BeanTank;
import fr.imt.coffee.storage.cupboard.coffee.type.CoffeeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeanTankUnitTest {
    public BeanTank beanTankUnderTest;

    @BeforeEach
    public void beforeTest(){
        beanTankUnderTest = new BeanTank(0, 0, 10, CoffeeType.MOKA);
    }

    /**
     * On vient tester si le volume de café augmente bien du volume ajouté
     */
    @Test
    public void testIncreaseCoffeVolumeInTank(){
        //Volume initial de 0
        //On augmente le volume de café de 10
        this.beanTankUnderTest.increaseVolumeInTank(10);
        //On vérifie que le volume de café est bien de 10 après l'ajout
        assertEquals(10.0, this.beanTankUnderTest.getActualVolume());
    }
}

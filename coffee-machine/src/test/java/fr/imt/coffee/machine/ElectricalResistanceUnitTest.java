package fr.imt.coffee.machine;

import fr.imt.coffee.machine.component.BeanTank;
import fr.imt.coffee.machine.component.ElectricalResistance;
import fr.imt.coffee.storage.cupboard.coffee.type.CoffeeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectricalResistanceUnitTest {
    public ElectricalResistance electricalResistanceUnderTest;

    @BeforeEach
    public void beforeTest(){
        electricalResistanceUnderTest = new ElectricalResistance(10000);
    }

    /**
     * On vient tester si le temps de chauffe de l'eau correspond
     */
    @Test
    public void testWaterHeating() throws InterruptedException {
        //On prend un volume d'eau de 2l et pour une puissance de 10000
        //Le temps de chauffe devrait être de :
        double heatingTimeCalculated = ((2.0 * 4180 * (90 - 20)) / 10000) * 1000 / 10;

        //On vérifie que le temps de chauffe correspond à celui calculé ci-dessus
        assertEquals(heatingTimeCalculated, this.electricalResistanceUnderTest.waterHeating(2.0));
    }
}

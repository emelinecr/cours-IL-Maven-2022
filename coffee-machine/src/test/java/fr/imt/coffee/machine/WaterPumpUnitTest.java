package fr.imt.coffee.machine;

import fr.imt.coffee.machine.component.ElectricalResistance;
import fr.imt.coffee.machine.component.WaterPump;
import fr.imt.coffee.machine.component.WaterTank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaterPumpUnitTest {
    public WaterPump waterPumpUnderTest;

    @BeforeEach
    public void beforeTest(){
        waterPumpUnderTest = new WaterPump(10000);
    }

    /**
     * On vient tester si le temps de pompage de l'eau correspond
     */
    @Test
    public void testWaterPumping() throws InterruptedException {
        //On prend un volume d'eau de 2l et pour une capacité de 10000
        //Le temps de pompage devrait être de :
        double pumpingTimeCalculated = (2.0 / 10000) * 1000 * 2;

        //On vérifie que le temps de pompage correspond à celui calculé ci-dessus
        assertEquals(pumpingTimeCalculated, this.waterPumpUnderTest.pumpWater(2.0, new WaterTank(5, 0, 10)));
    }
}

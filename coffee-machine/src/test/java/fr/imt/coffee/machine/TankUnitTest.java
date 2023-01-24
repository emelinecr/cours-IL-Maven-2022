package fr.imt.coffee.machine;

import fr.imt.coffee.machine.component.BeanTank;
import fr.imt.coffee.machine.component.Tank;
import fr.imt.coffee.storage.cupboard.coffee.type.CoffeeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TankUnitTest {

    /**
     * On vient tester si le volume augmente bien du volume ajouté
     */
    @Test
    public void testIncreaseVolumeInTank(){
        //Volume initial de 2
        Tank tankUnderTest = new Tank(2, 0, 10);
        //On augmente le volume de 4
        tankUnderTest.increaseVolumeInTank(4);
        //On vérifie que le volume est bien de 6 après l'ajout
        assertEquals(6.0, tankUnderTest.getActualVolume());
    }

    /**
     * On vient tester si le volume décroit bien du volume retiré
     */
    @Test
    public void testDecreaseVolumeInTank(){
        //Volume initial de 2
        Tank tankUnderTest = new Tank(2, 0, 10);
        //On décroit le volume de 1
        tankUnderTest.decreaseVolumeInTank(1);
        //On vérifie que le volume de café est bien de 1 après le retrait
        assertEquals(1.0, tankUnderTest.getActualVolume());
    }
}

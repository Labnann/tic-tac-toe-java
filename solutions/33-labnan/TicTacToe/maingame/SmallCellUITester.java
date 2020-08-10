package maingame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class SmallCellUITester {
    SmallCellUI square = new SmallCellUI(0, 0);


    @BeforeClass
    public static void setup() throws InterruptedException {
        JavaFXInitializer.initialize();
    }

    @Test
    public void getSquareIsTriggeredTest() {

        square.triggerSquareAs(SmallCell.Type.CROSS);
        Assertions.assertFalse(square.isNotTriggered());
    }

    @Test
    public void getSquarePlaceValueTest() {
        Assertions.assertNull(square.getTurnType());
        square.triggerSquareAs(SmallCell.Type.CROSS);
        Assertions.assertEquals(SmallCell.Type.CROSS, square.getTurnType());
        square.triggerSquareAs(SmallCell.Type.ZERO);
        Assertions.assertEquals(SmallCell.Type.CROSS, square.getTurnType());
        square = new SmallCellUI(0, 0);
        square.triggerSquareAs(SmallCell.Type.ZERO);
        Assertions.assertEquals(SmallCell.Type.ZERO, square.getTurnType());
        square.triggerSquareAs(SmallCell.Type.CROSS);
        Assertions.assertEquals(SmallCell.Type.ZERO, square.getTurnType());
    }


}

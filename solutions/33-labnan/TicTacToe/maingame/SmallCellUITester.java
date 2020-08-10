package maingame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class SmallCellUITester {
    SmallCellUI smallCellUI = new SmallCellUI(0, 0);


    @BeforeClass
    public static void setup() throws InterruptedException {
        JavaFXInitializer.initialize();
    }

    @Test
    public void getSquareIsTriggeredTest() {

        smallCellUI.triggerSquareAs(SmallCell.Type.CROSS);
        Assertions.assertFalse(smallCellUI.isNotTriggered());
    }

    @Test
    public void getSquarePlaceValueTest() {
        Assertions.assertNull(smallCellUI.getTurnType());
        smallCellUI.triggerSquareAs(SmallCell.Type.CROSS);
        Assertions.assertEquals(SmallCell.Type.CROSS, smallCellUI.getTurnType());
        smallCellUI.triggerSquareAs(SmallCell.Type.ZERO);
        Assertions.assertEquals(SmallCell.Type.CROSS, smallCellUI.getTurnType());
        smallCellUI = new SmallCellUI(0, 0);
        smallCellUI.triggerSquareAs(SmallCell.Type.ZERO);
        Assertions.assertEquals(SmallCell.Type.ZERO, smallCellUI.getTurnType());
        smallCellUI.triggerSquareAs(SmallCell.Type.CROSS);
        Assertions.assertEquals(SmallCell.Type.ZERO, smallCellUI.getTurnType());
    }


}

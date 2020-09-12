package maingame;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SmallCellTester {
    SmallCell smallCell = new SmallCell();
    int updateValue = 0;

    @Test
    public void testBoxListening() {


        smallCell.addOnSmallCellTrigger(() -> {
            update();
            Assertions.assertEquals(1, updateValue);
        });
        smallCell.addOnSmallCellTrigger(() -> {
            update();
            update();
            Assertions.assertEquals(3, updateValue);
        });
        smallCell.setTurnType(PlayerMark.CROSS);
    }

    @Test
    public void testBoxGetTypeOnDoubleSet() {
        smallCell.setTurnType(PlayerMark.CROSS);
        smallCell.setTurnType(PlayerMark.ZERO);
        Assertions.assertEquals(PlayerMark.CROSS, smallCell.getTurnType());
    }


    private void update() {
        updateValue++;
    }


    @Test
    public void getSquareIsTriggeredTest() {

        smallCell.triggerSquareAs(PlayerMark.CROSS);
        Assertions.assertFalse(smallCell.isNotTriggered());
    }

    @Test
    public void getSquarePlaceValueTest() {
        Assertions.assertNull(smallCell.getTurnType());
        smallCell.triggerSquareAs(PlayerMark.CROSS);
        Assertions.assertEquals(PlayerMark.CROSS, smallCell.getTurnType());
        smallCell.triggerSquareAs(PlayerMark.ZERO);
        Assertions.assertEquals(PlayerMark.CROSS, smallCell.getTurnType());
        smallCell = new SmallCell();
        smallCell.triggerSquareAs(PlayerMark.ZERO);
        Assertions.assertEquals(PlayerMark.ZERO, smallCell.getTurnType());
        smallCell.triggerSquareAs(PlayerMark.CROSS);
        Assertions.assertEquals(PlayerMark.ZERO, smallCell.getTurnType());
    }


}

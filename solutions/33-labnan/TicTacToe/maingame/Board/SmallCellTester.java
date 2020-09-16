package maingame.Board;

import maingame.PlayerMarkEnum;
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
        smallCell.setMark(PlayerMarkEnum.HUMAN);
    }

    @Test
    public void testBoxGetTypeOnDoubleSet() {
        smallCell.setMark(PlayerMarkEnum.HUMAN);
        smallCell.setMark(PlayerMarkEnum.AI);
        Assertions.assertEquals(PlayerMarkEnum.HUMAN, smallCell.getMark());
    }


    private void update() {
        updateValue++;
    }


    @Test
    public void getSquareIsTriggeredTest() {

        smallCell.triggerSquareAs(PlayerMarkEnum.HUMAN);
        Assertions.assertFalse(smallCell.isNotTriggered());
    }

    @Test
    public void getSquarePlaceValueTest() {
        Assertions.assertNull(smallCell.getMark());
        smallCell.triggerSquareAs(PlayerMarkEnum.HUMAN);
        Assertions.assertEquals(PlayerMarkEnum.HUMAN, smallCell.getMark());
        smallCell.triggerSquareAs(PlayerMarkEnum.AI);
        Assertions.assertEquals(PlayerMarkEnum.HUMAN, smallCell.getMark());
        smallCell = new SmallCell();
        smallCell.triggerSquareAs(PlayerMarkEnum.AI);
        Assertions.assertEquals(PlayerMarkEnum.AI, smallCell.getMark());
        smallCell.triggerSquareAs(PlayerMarkEnum.HUMAN);
        Assertions.assertEquals(PlayerMarkEnum.AI, smallCell.getMark());
    }


}

package maingame.Board;

import maingame.Board.SmallCell;
import maingame.PlayerMark;
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
        smallCell.setTurnType(PlayerMark.HUMAN);
    }

    @Test
    public void testBoxGetTypeOnDoubleSet() {
        smallCell.setTurnType(PlayerMark.HUMAN);
        smallCell.setTurnType(PlayerMark.AI);
        Assertions.assertEquals(PlayerMark.HUMAN, smallCell.getTurnType());
    }


    private void update() {
        updateValue++;
    }


    @Test
    public void getSquareIsTriggeredTest() {

        smallCell.triggerSquareAs(PlayerMark.HUMAN);
        Assertions.assertFalse(smallCell.isNotTriggered());
    }

    @Test
    public void getSquarePlaceValueTest() {
        Assertions.assertNull(smallCell.getTurnType());
        smallCell.triggerSquareAs(PlayerMark.HUMAN);
        Assertions.assertEquals(PlayerMark.HUMAN, smallCell.getTurnType());
        smallCell.triggerSquareAs(PlayerMark.AI);
        Assertions.assertEquals(PlayerMark.HUMAN, smallCell.getTurnType());
        smallCell = new SmallCell();
        smallCell.triggerSquareAs(PlayerMark.AI);
        Assertions.assertEquals(PlayerMark.AI, smallCell.getTurnType());
        smallCell.triggerSquareAs(PlayerMark.HUMAN);
        Assertions.assertEquals(PlayerMark.AI, smallCell.getTurnType());
    }


}
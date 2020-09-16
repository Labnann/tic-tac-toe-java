package maingame.Board;

import maingame.PlayerMark.CrossMark;
import maingame.PlayerMark.ZeroMark;
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
        smallCell.setPlayerMark(new CrossMark());
    }

    @Test
    public void testBoxGetTypeOnDoubleSet() {
        smallCell.setPlayerMark(new CrossMark());
        smallCell.setPlayerMark(new ZeroMark());
        Assertions.assertTrue( smallCell.getPlayerMark() instanceof CrossMark);
    }


    private void update() {
        updateValue++;
    }


    @Test
    public void getSquareIsTriggeredTest() {

        smallCell.triggerSquareAs(new CrossMark());
        Assertions.assertFalse(smallCell.isNotTriggered());
    }

    @Test
    public void getSquarePlaceValueTest() {
        Assertions.assertNull(smallCell.getPlayerMark());
        smallCell.triggerSquareAs(new CrossMark());
        Assertions.assertTrue( smallCell.getPlayerMark() instanceof CrossMark);
        smallCell.triggerSquareAs(new ZeroMark());
        Assertions.assertTrue( smallCell.getPlayerMark() instanceof CrossMark);
        smallCell = new SmallCell();
        smallCell.triggerSquareAs(new ZeroMark());
        Assertions.assertTrue( smallCell.getPlayerMark() instanceof ZeroMark);
        smallCell.triggerSquareAs(new CrossMark());
        Assertions.assertTrue( smallCell.getPlayerMark() instanceof ZeroMark);
    }


}

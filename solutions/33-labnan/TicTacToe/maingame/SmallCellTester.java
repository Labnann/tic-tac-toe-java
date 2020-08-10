package maingame;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SmallCellTester {
    SmallCell smallCell = new SmallCell();
    int updateValue = 0;

    @Test
    public void testBoxListening() {


        smallCell.addOnBoxChange(() -> {
            update();
            Assertions.assertEquals(1, updateValue);
        });
        smallCell.addOnBoxChange(() -> {
            update();
            update();
            Assertions.assertEquals(3, updateValue);
        });
        smallCell.setTurnType(SmallCell.Type.CROSS);
    }

    @Test
    public void testBoxGetTypeOnDoubleSet() {
        smallCell.setTurnType(SmallCell.Type.CROSS);
        smallCell.setTurnType(SmallCell.Type.ZERO);
        Assertions.assertEquals(SmallCell.Type.CROSS, smallCell.getTurnType());
    }


    private void update() {
        updateValue++;
    }

}

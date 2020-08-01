package maingame;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LogicBasedBoxTester {
    LogicBasedBox logicBasedBox = new LogicBasedBox();
    int updateValue = 0;

    @Test
    public void testBoxListening() {


        logicBasedBox.addOnBoxChange(() -> {
            update();
            Assertions.assertEquals(1, updateValue);
        });
        logicBasedBox.addOnBoxChange(() -> {
            update();
            update();
            Assertions.assertEquals(3, updateValue);
        });
        logicBasedBox.setTurnType(LogicBasedBox.Type.CROSS);
    }

    @Test
    public void testBoxGetTypeOnDoubleSet() {
        logicBasedBox.setTurnType(LogicBasedBox.Type.CROSS);
        logicBasedBox.setTurnType(LogicBasedBox.Type.ZERO);
        Assertions.assertEquals(LogicBasedBox.Type.CROSS, logicBasedBox.getTurnType());
    }


    private void update() {
        updateValue++;
    }

}

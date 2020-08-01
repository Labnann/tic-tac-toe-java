package maingame;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LogicBasedBoxTester {
    LogicBasedBox logicBasedBox;
    int updateValue = 0;

    @Test
    public void testBoxListening() {

        logicBasedBox = new LogicBasedBox();

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

    private void update() {
        updateValue++;
    }


    //@Test
}

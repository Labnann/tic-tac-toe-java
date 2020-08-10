package maingame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class BoardSquareTester {
    BoardSquare square = new BoardSquare(0, 0);


    @BeforeClass
    public static void setup() throws InterruptedException {
        JavaFXInitializer.initialize();
    }

    @Test
    public void getSquareIsTriggeredTest() {

        square.triggerSquareAs(LogicBasedBox.Type.CROSS);
        Assertions.assertFalse(square.isNotTriggered());
    }

    @Test
    public void getSquarePlaceValueTest() {
        Assertions.assertNull(square.getTurnType());
        square.triggerSquareAs(LogicBasedBox.Type.CROSS);
        Assertions.assertEquals(LogicBasedBox.Type.CROSS, square.getTurnType());
        square.triggerSquareAs(LogicBasedBox.Type.ZERO);
        Assertions.assertEquals(LogicBasedBox.Type.CROSS, square.getTurnType());
        square = new BoardSquare(0, 0);
        square.triggerSquareAs(LogicBasedBox.Type.ZERO);
        Assertions.assertEquals(LogicBasedBox.Type.ZERO, square.getTurnType());
        square.triggerSquareAs(LogicBasedBox.Type.CROSS);
        Assertions.assertEquals(LogicBasedBox.Type.ZERO, square.getTurnType());
    }


}

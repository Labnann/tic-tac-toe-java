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

        square.triggerSquareAs(Turn.CROSS);
        Assertions.assertFalse(square.isNotTriggered());
    }

    @Test
    public void getSquarePlaceValueTest() {
        Assertions.assertNull(square.getTurn());
        square.triggerSquareAs(Turn.CROSS);
        Assertions.assertEquals(Turn.CROSS, square.getTurn());
        square.triggerSquareAs(Turn.ZERO);
        Assertions.assertEquals(Turn.CROSS, square.getTurn());
        square = new BoardSquare(0, 0);
        square.triggerSquareAs(Turn.ZERO);
        Assertions.assertEquals(Turn.ZERO, square.getTurn());
        square.triggerSquareAs(Turn.CROSS);
        Assertions.assertEquals(Turn.ZERO, square.getTurn());
    }


}

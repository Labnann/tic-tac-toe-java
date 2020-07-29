package maingame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestWinChecker {
    WinChecker winChecker = new WinChecker(new Board());
    BoardSquare[][] boardSquares = winChecker.getBoardSquare();

    @BeforeClass
    public static void setup() throws InterruptedException {
        JavaFXInitializer.initialize();
    }


    @Test
    public void testColumnChecker() {
        checkColumn(2);
        checkColumn(1);
        checkColumn(0);
        Assertions.assertTrue(winChecker.isGameEnded());
    }

    private void checkColumn(int i) {
        populateColumnWithCross(i);
        Assertions.assertEquals(BoardSquare.PlaceValue.CROSS, winChecker.checkWinAtColumn(i));
    }


    private void populateColumnWithCross(int column) {
        for (int i = 0; i < 3; i++) {
            boardSquares[column][i].triggerSquareAs(BoardSquare.PlaceValue.CROSS);
        }
    }


}

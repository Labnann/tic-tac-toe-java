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
    public void testFirstRowWinChecker() {
        populateFirstRowWithCross();
        Assertions.assertEquals(BoardSquare.PlaceValue.CROSS, winChecker.checkFirstRow());
        Assertions.assertTrue(winChecker.isGameEnded());
    }


    private void populateFirstRowWithCross() {
        for (int i = 0; i < 3; i++) {
            boardSquares[0][i].triggerSquareAs(BoardSquare.PlaceValue.CROSS);
        }
    }


}

package maingame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestWinChecker {
    WinChecker winChecker;
    BoardSquare[][] boardSquares;

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
        winChecker = new WinChecker(new Board());
        boardSquares = winChecker.getBoardSquare();
        populateColumnWithCross(i);
        winChecker.checkWinAtColumn(i);
        Assertions.assertEquals(BoardSquare.PlaceValue.CROSS, winChecker.getWinner());
    }


    private void populateColumnWithCross(int column) {
        for (int i = 0; i < 3; i++) {
            boardSquares[column][i].triggerSquareAs(BoardSquare.PlaceValue.CROSS);
        }
    }

    private void populateRowWithZero(int row) {
        for (int i = 0; i < 3; i++) {
            boardSquares[i][row].triggerSquareAs(BoardSquare.PlaceValue.ZERO);
        }
    }

    @Test
    public void testRowChecker() {
        checkRow(0);
        checkRow(1);
        checkRow(2);
        Assertions.assertTrue(winChecker.isGameEnded());
    }

    private void checkRow(int i) {
        winChecker = new WinChecker(new Board());
        boardSquares = winChecker.getBoardSquare();
        populateRowWithZero(i);
        winChecker.checkWinAtRow(i);
        Assertions.assertEquals(BoardSquare.PlaceValue.ZERO, winChecker.getWinner());
    }


}

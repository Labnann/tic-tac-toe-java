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
        checkColumnForWin(2);
        checkColumnForWin(1);
        checkColumnForWin(0);
        Assertions.assertTrue(winChecker.isGameEnded());
    }

    private void checkColumnForWin(int i) {
        winChecker = new WinChecker(new Board());
        boardSquares = winChecker.getBoardSquare();
        populateColumnWithCross(i);
        winChecker.checkWinAtColumns(i);
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
        checkRowForWin(0);
        checkRowForWin(1);
        checkRowForWin(2);
        Assertions.assertTrue(winChecker.isGameEnded());
    }

    private void checkRowForWin(int i) {
        winChecker = new WinChecker(new Board());
        boardSquares = winChecker.getBoardSquare();
        populateRowWithZero(i);
        winChecker.checkWinAtRow(i);
        Assertions.assertEquals(BoardSquare.PlaceValue.ZERO, winChecker.getWinner());
    }

    @Test
    public void notEquallyPopulatedTest() {
        winChecker = new WinChecker(new Board());
        boardSquares = winChecker.getBoardSquare();
        populateFirstRowUnequally();
        winChecker.checkWinAtRow(0);
        Assertions.assertFalse(winChecker.isGameEnded());

    }

    @Test
    public void columnUnequallyPopulatedTest() {
        winChecker = new WinChecker(new Board());
        boardSquares = winChecker.getBoardSquare();
        populateFirstColumnUnequally();
        winChecker.checkWinAtColumns(0);
        Assertions.assertFalse(winChecker.isGameEnded());
    }

    private void populateFirstRowUnequally() {
        boardSquares[0][0].triggerSquareAs(BoardSquare.PlaceValue.CROSS);
        boardSquares[1][0].triggerSquareAs(BoardSquare.PlaceValue.CROSS);
        boardSquares[2][0].triggerSquareAs(BoardSquare.PlaceValue.ZERO);
    }

    private void populateFirstColumnUnequally() {
        boardSquares[0][0].triggerSquareAs(BoardSquare.PlaceValue.CROSS);
        boardSquares[0][1].triggerSquareAs(BoardSquare.PlaceValue.CROSS);
        boardSquares[0][2].triggerSquareAs(BoardSquare.PlaceValue.ZERO);
    }


}

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
        winChecker.checkWin();
        Assertions.assertEquals(BoardSquare.PlaceValue.CROSS, winChecker.getWinner());
    }


    private void populateColumnWithCross(int column) {
        for (int i = 0; i < 3; i++) {
            boardSquares[column][i].triggerSquareAs(BoardSquare.PlaceValue.CROSS);
        }
    }

    private void populateColumn(int column, BoardSquare.PlaceValue placeValue) {
        for (int i = 0; i < 3; i++) {
            boardSquares[column][i].triggerSquareAs(placeValue);
        }
    }

    private void populateRowWithZero(int row) {
        for (int i = 0; i < 3; i++) {
            boardSquares[i][row].triggerSquareAs(BoardSquare.PlaceValue.ZERO);
        }
    }


    private void populateRowWith(int row, BoardSquare.PlaceValue placeValue) {
        for (int i = 0; i < 3; i++) {
            boardSquares[i][row].triggerSquareAs(placeValue);
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
        winChecker.checkWin();
        Assertions.assertEquals(BoardSquare.PlaceValue.ZERO, winChecker.getWinner());
    }

    @Test
    public void notEquallyPopulatedTest() {
        winChecker = new WinChecker(new Board());
        boardSquares = winChecker.getBoardSquare();
        populateFirstRowUnequally();
        winChecker.checkWin();
        Assertions.assertFalse(winChecker.isGameEnded());

    }

    @Test
    public void columnUnequallyPopulatedTest() {
        winChecker = new WinChecker(new Board());
        boardSquares = winChecker.getBoardSquare();
        populateFirstColumnUnequally();
        winChecker.checkWin();
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

    private void populateAntiDiagonals(BoardSquare.PlaceValue placeValue) {
        boardSquares[0][2].triggerSquareAs(placeValue);
        boardSquares[1][1].triggerSquareAs(placeValue);
        boardSquares[2][0].triggerSquareAs(placeValue);
    }

    @Test
    public void doubleWinPreventionTest() {

        winChecker = new WinChecker(new Board());
        boardSquares = winChecker.getBoardSquare();
        populateRowWith(0, BoardSquare.PlaceValue.CROSS);
        populateRowWith(1, BoardSquare.PlaceValue.ZERO);
        winChecker.checkWin();
        Assertions.assertEquals(BoardSquare.PlaceValue.CROSS, winChecker.getWinner());

    }



}

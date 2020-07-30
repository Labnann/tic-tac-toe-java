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
        initializeWinCheckerAndBoardSquares();
        populateColumnWithCross(i);
        winChecker.checkWin();
        Assertions.assertEquals(Turn.CROSS, winChecker.getWinner());
    }


    private void populateColumnWithCross(int column) {
        for (int i = 0; i < 3; i++) {
            boardSquares[column][i].triggerSquareAs(Turn.CROSS);
        }
    }

    private void populateColumn(int column, Turn turn) {
        for (int i = 0; i < 3; i++) {
            boardSquares[column][i].triggerSquareAs(turn);
        }
    }

    private void populateRowWithZero(int row) {
        for (int i = 0; i < 3; i++) {
            boardSquares[i][row].triggerSquareAs(Turn.ZERO);
        }
    }


    private void populateRowWith(int row, Turn turn) {
        for (int i = 0; i < 3; i++) {
            boardSquares[i][row].triggerSquareAs(turn);
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
        initializeWinCheckerAndBoardSquares();
        populateRowWithZero(i);
        winChecker.checkWin();
        Assertions.assertEquals(Turn.ZERO, winChecker.getWinner());
    }

    @Test
    public void notEquallyPopulatedTest() {
        initializeWinCheckerAndBoardSquares();
        populateFirstRowUnequally();
        winChecker.checkWin();
        Assertions.assertFalse(winChecker.isGameEnded());

    }

    @Test
    public void columnUnequallyPopulatedTest() {
        initializeWinCheckerAndBoardSquares();
        populateFirstColumnUnequally();
        winChecker.checkWin();
        Assertions.assertFalse(winChecker.isGameEnded());
    }

    private void populateFirstRowUnequally() {
        boardSquares[0][0].triggerSquareAs(Turn.CROSS);
        boardSquares[1][0].triggerSquareAs(Turn.CROSS);
        boardSquares[2][0].triggerSquareAs(Turn.ZERO);
    }

    private void populateFirstColumnUnequally() {
        boardSquares[0][0].triggerSquareAs(Turn.CROSS);
        boardSquares[0][1].triggerSquareAs(Turn.CROSS);
        boardSquares[0][2].triggerSquareAs(Turn.ZERO);
    }

    private void populateAntiDiagonals(Turn turn) {
        boardSquares[0][2].triggerSquareAs(turn);
        boardSquares[1][1].triggerSquareAs(turn);
        boardSquares[2][0].triggerSquareAs(turn);
    }

    @Test
    public void doubleWinPreventionTest() {

        initializeWinCheckerAndBoardSquares();
        populateRowWith(0, Turn.CROSS);
        populateRowWith(1, Turn.ZERO);
        winChecker.checkWin();
        Assertions.assertEquals(Turn.CROSS, winChecker.getWinner());

    }

    @Test
    public void antiDiagonalWinTest() {
        initializeWinCheckerAndBoardSquares();
        boardSquares[0][2].triggerSquareAs(Turn.CROSS);
        boardSquares[1][1].triggerSquareAs(Turn.CROSS);
        boardSquares[2][0].triggerSquareAs(Turn.CROSS);
        winChecker.checkWin();
        Assertions.assertEquals(Turn.CROSS, winChecker.getWinner());

    }

    private void initializeWinCheckerAndBoardSquares() {
        winChecker = new WinChecker(new Board());
        boardSquares = winChecker.getBoardSquare();
    }


}

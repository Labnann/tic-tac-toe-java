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
        Assertions.assertEquals(LogicBasedBox.Type.CROSS, winChecker.getWinner());
    }


    private void populateColumnWithCross(int column) {
        for (int i = 0; i < 3; i++) {
            boardSquares[column][i].triggerSquareAs(LogicBasedBox.Type.CROSS);
        }
    }

    private void populateColumn(int column, LogicBasedBox.Type turnType) {
        for (int i = 0; i < 3; i++) {
            boardSquares[column][i].triggerSquareAs(turnType);
        }
    }

    private void populateRowWithZero(int row) {
        for (int i = 0; i < 3; i++) {
            boardSquares[i][row].triggerSquareAs(LogicBasedBox.Type.ZERO);
        }
    }


    private void populateRowWith(int row, LogicBasedBox.Type turnType) {
        for (int i = 0; i < 3; i++) {
            boardSquares[i][row].triggerSquareAs(turnType);
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
        Assertions.assertEquals(LogicBasedBox.Type.ZERO, winChecker.getWinner());
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
        boardSquares[0][0].triggerSquareAs(LogicBasedBox.Type.CROSS);
        boardSquares[1][0].triggerSquareAs(LogicBasedBox.Type.CROSS);
        boardSquares[2][0].triggerSquareAs(LogicBasedBox.Type.ZERO);
    }

    private void populateFirstColumnUnequally() {
        boardSquares[0][0].triggerSquareAs(LogicBasedBox.Type.CROSS);
        boardSquares[0][1].triggerSquareAs(LogicBasedBox.Type.CROSS);
        boardSquares[0][2].triggerSquareAs(LogicBasedBox.Type.ZERO);
    }

    private void populateAntiDiagonals(LogicBasedBox.Type turnType) {
        boardSquares[0][2].triggerSquareAs(turnType);
        boardSquares[1][1].triggerSquareAs(turnType);
        boardSquares[2][0].triggerSquareAs(turnType);
    }

    @Test
    public void doubleWinPreventionTest() {

        initializeWinCheckerAndBoardSquares();
        populateRowWith(0, LogicBasedBox.Type.CROSS);
        populateRowWith(1, LogicBasedBox.Type.ZERO);
        winChecker.checkWin();
        Assertions.assertEquals(LogicBasedBox.Type.CROSS, winChecker.getWinner());

    }

    @Test
    public void antiDiagonalWinTest() {
        initializeWinCheckerAndBoardSquares();
        boardSquares[0][2].triggerSquareAs(LogicBasedBox.Type.CROSS);
        boardSquares[1][1].triggerSquareAs(LogicBasedBox.Type.CROSS);
        boardSquares[2][0].triggerSquareAs(LogicBasedBox.Type.CROSS);
        winChecker.checkWin();
        Assertions.assertEquals(LogicBasedBox.Type.CROSS, winChecker.getWinner());

    }

    private void initializeWinCheckerAndBoardSquares() {
        Board board = new Board();
        boardSquares = board.getBoardSquares();
        winChecker = new WinChecker(board);
    }


}

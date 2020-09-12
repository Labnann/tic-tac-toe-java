package maingame;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestSimpleWinChecker {
    WinChecker winChecker;
    SmallCell[][] smallCellUIS;


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
        //winChecker.checkWin();
        Assertions.assertEquals(SmallCell.Type.CROSS, winChecker.getWinner());
    }


    private void populateColumnWithCross(int column) {
        for (int i = 0; i < 3; i++) {
            smallCellUIS[column][i].triggerSquareAs(SmallCell.Type.CROSS);
        }
    }

    private void populateColumn(int column, SmallCell.Type turnType) {
        for (int i = 0; i < 3; i++) {
            smallCellUIS[column][i].triggerSquareAs(turnType);
        }
    }

    private void populateRowWithZero(int row) {
        for (int i = 0; i < 3; i++) {
            smallCellUIS[i][row].triggerSquareAs(SmallCell.Type.ZERO);
        }
    }


    private void populateRowWith(int row, SmallCell.Type turnType) {
        for (int i = 0; i < 3; i++) {
            smallCellUIS[i][row].triggerSquareAs(turnType);
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
        //winChecker.checkWin();
        Assertions.assertEquals(SmallCell.Type.ZERO, winChecker.getWinner());
    }

    @Test
    public void notEquallyPopulatedTest() {
        initializeWinCheckerAndBoardSquares();
        populateFirstRowUnequally();
       // winChecker.checkWin();
        Assertions.assertFalse(winChecker.isGameEnded());

    }

    @Test
    public void columnUnequallyPopulatedTest() {
        initializeWinCheckerAndBoardSquares();
        populateFirstColumnUnequally();
      //  winChecker.checkWin();
        Assertions.assertFalse(winChecker.isGameEnded());
    }

    private void populateFirstRowUnequally() {
        smallCellUIS[0][0].triggerSquareAs(SmallCell.Type.CROSS);
        smallCellUIS[1][0].triggerSquareAs(SmallCell.Type.CROSS);
        smallCellUIS[2][0].triggerSquareAs(SmallCell.Type.ZERO);
    }

    private void populateFirstColumnUnequally() {
        smallCellUIS[0][0].triggerSquareAs(SmallCell.Type.CROSS);
        smallCellUIS[0][1].triggerSquareAs(SmallCell.Type.CROSS);
        smallCellUIS[0][2].triggerSquareAs(SmallCell.Type.ZERO);
    }

    private void populateAntiDiagonals(SmallCell.Type turnType) {
        smallCellUIS[0][2].triggerSquareAs(turnType);
        smallCellUIS[1][1].triggerSquareAs(turnType);
        smallCellUIS[2][0].triggerSquareAs(turnType);
    }

    @Test
    public void doubleWinPreventionTest() {

        initializeWinCheckerAndBoardSquares();
        populateRowWith(0, SmallCell.Type.CROSS);
        populateRowWith(1, SmallCell.Type.ZERO);
       // winChecker.checkWin();
        Assertions.assertEquals(SmallCell.Type.CROSS, winChecker.getWinner());

    }

    @Test
    public void antiDiagonalWinTest() {
        initializeWinCheckerAndBoardSquares();
        smallCellUIS[0][2].triggerSquareAs(SmallCell.Type.CROSS);
        smallCellUIS[1][1].triggerSquareAs(SmallCell.Type.CROSS);
        smallCellUIS[2][0].triggerSquareAs(SmallCell.Type.CROSS);
        //winChecker.checkWin();
        Assertions.assertEquals(SmallCell.Type.CROSS, winChecker.getWinner());

    }

    private void initializeWinCheckerAndBoardSquares() {
        Board board = new Board();
        smallCellUIS = board.getSmallCells();
        winChecker = new AdvancedWinChecker(new GameStatus(board.getSmallCells()));
    }


}

package maingame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestWinChecker {
    WinChecker winChecker;
    SmallCell[][] smallCellUIS;
    SmallCell[][] smallCells = new SmallCell[3][3];


    @Test
    public void testColumnChecker() {
        initializeSmallCells();
        checkColumnForWin(2);
        checkColumnForWin(1);
        checkColumnForWin(0);
        Assertions.assertTrue(winChecker.isGameEnded());
    }

    private void checkColumnForWin(int i) {
        initializeWinCheckerAndBoardSquares();
        populateColumnWithCross(i);
        winChecker.checkWin();
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
        initializeSmallCells();
        checkRowForWin(0);
        checkRowForWin(1);
        checkRowForWin(2);
        Assertions.assertTrue(winChecker.isGameEnded());
    }

    private void checkRowForWin(int i) {
        initializeWinCheckerAndBoardSquares();
        populateRowWithZero(i);
        winChecker.checkWin();
        Assertions.assertEquals(SmallCell.Type.ZERO, winChecker.getWinner());
    }

    @Test
    public void notEquallyPopulatedTest() {
        initializeSmallCells();
        initializeWinCheckerAndBoardSquares();
        populateFirstRowUnequally();
        winChecker.checkWin();
        Assertions.assertFalse(winChecker.isGameEnded());

    }

    @Test
    public void columnUnequallyPopulatedTest() {
        initializeSmallCells();
        initializeWinCheckerAndBoardSquares();
        populateFirstColumnUnequally();
        winChecker.checkWin();
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
        initializeSmallCells();
        initializeWinCheckerAndBoardSquares();
        populateRowWith(0, SmallCell.Type.CROSS);
        populateRowWith(1, SmallCell.Type.ZERO);
        winChecker.checkWin();
        Assertions.assertEquals(SmallCell.Type.CROSS, winChecker.getWinner());

    }

    @Test
    public void antiDiagonalWinTest() {
        initializeSmallCells();
        initializeWinCheckerAndBoardSquares();
        smallCellUIS[0][2].triggerSquareAs(SmallCell.Type.CROSS);
        smallCellUIS[1][1].triggerSquareAs(SmallCell.Type.CROSS);
        smallCellUIS[2][0].triggerSquareAs(SmallCell.Type.CROSS);
        winChecker.checkWin();
        Assertions.assertEquals(SmallCell.Type.CROSS, winChecker.getWinner());

    }

    private void initializeWinCheckerAndBoardSquares() {

        Board board = new Board(smallCells);
        smallCellUIS = board.getSmallCells();
        winChecker = new WinChecker(board);
    }

    private void initializeSmallCells() {
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                smallCells[i][j] = new SmallCell();
            }
        }
    }




}

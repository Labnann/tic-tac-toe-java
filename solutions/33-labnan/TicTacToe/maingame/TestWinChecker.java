package maingame;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestWinChecker {
    WinChecker winChecker;
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
            smallCells[column][i].triggerSquareAs(SmallCell.Type.CROSS);
        }
    }

    private void populateColumn(int column, SmallCell.Type turnType) {
        for (int i = 0; i < 3; i++) {
            smallCells[column][i].triggerSquareAs(turnType);
        }
    }

    private void populateRowWithZero(int row) {
        for (int i = 0; i < 3; i++) {
            smallCells[i][row].triggerSquareAs(SmallCell.Type.ZERO);
        }
    }


    private void populateRowWith(int row, SmallCell.Type turnType) {
        for (int i = 0; i < 3; i++) {
            smallCells[i][row].triggerSquareAs(turnType);
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
        smallCells[0][0].triggerSquareAs(SmallCell.Type.CROSS);
        smallCells[1][0].triggerSquareAs(SmallCell.Type.CROSS);
        smallCells[2][0].triggerSquareAs(SmallCell.Type.ZERO);
    }

    private void populateFirstColumnUnequally() {
        smallCells[0][0].triggerSquareAs(SmallCell.Type.CROSS);
        smallCells[0][1].triggerSquareAs(SmallCell.Type.CROSS);
        smallCells[0][2].triggerSquareAs(SmallCell.Type.ZERO);
    }

    private void populateAntiDiagonals(SmallCell.Type turnType) {
        smallCells[0][2].triggerSquareAs(turnType);
        smallCells[1][1].triggerSquareAs(turnType);
        smallCells[2][0].triggerSquareAs(turnType);
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
        smallCells[0][2].triggerSquareAs(SmallCell.Type.CROSS);
        smallCells[1][1].triggerSquareAs(SmallCell.Type.CROSS);
        smallCells[2][0].triggerSquareAs(SmallCell.Type.CROSS);
        winChecker.checkWin();
        Assertions.assertEquals(SmallCell.Type.CROSS, winChecker.getWinner());

    }

    private void initializeWinCheckerAndBoardSquares() {

        Board board = new Board(smallCells);
        smallCells = board.getSmallCells();
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

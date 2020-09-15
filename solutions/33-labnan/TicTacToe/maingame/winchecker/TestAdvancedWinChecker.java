package maingame.winchecker;

import maingame.Board;
import maingame.PlayerMark;
import maingame.Position;
import maingame.SmallCell;
import maingame.gamestatus.GamePlayStatus;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestAdvancedWinChecker {
    WinChecker winChecker;
    Board board;


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
        Assertions.assertEquals(PlayerMark.HUMAN, winChecker.getWinner());
    }


    private void populateColumnWithCross(int column) {
        for (int i = 0; i < 3; i++) {
            board.triggerSquareAt(new Position(column,i),PlayerMark.HUMAN);
        }
    }

    private void populateRowWithZero(int row) {
        for (int i = 0; i < 3; i++) {
            board.triggerSquareAt(new Position(row,i),PlayerMark.AI);
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
        Assertions.assertEquals(PlayerMark.AI, winChecker.getWinner());
    }

    @Test
    public void notEquallyPopulatedTest() {
        initializeWinCheckerAndBoardSquares();
        populateFirstColumnUnequally();
        Assertions.assertFalse(winChecker.isGameEnded());

    }

    @Test
    public void columnUnequallyPopulatedTest() {
        initializeWinCheckerAndBoardSquares();
        populateRowCUnequally();
        Assertions.assertFalse(winChecker.isGameEnded());
    }

    private void populateFirstColumnUnequally() {
        board.triggerSquareAt(new Position(0,0),PlayerMark.HUMAN);
        board.triggerSquareAt(new Position(1,0),PlayerMark.HUMAN);
        board.triggerSquareAt(new Position(2,0),PlayerMark.AI);
    }

    private void populateRowCUnequally() {
        board.triggerSquareAt(new Position(0,0),PlayerMark.HUMAN);
        board.triggerSquareAt(new Position(0,1),PlayerMark.HUMAN);
        board.triggerSquareAt(new Position(0,2),PlayerMark.AI);
    }

    private void populateDiagonals(PlayerMark turnType) {
        board.triggerSquareAt(new Position(0,0),turnType);
        board.triggerSquareAt(new Position(1,1),turnType);
        board.triggerSquareAt(new Position(2,2),turnType);
    }

    @Test
    public void diagonalWinTest(){
        initializeWinCheckerAndBoardSquares();
        populateDiagonals(PlayerMark.HUMAN);
        System.out.println(winChecker.getWinner());
        Assertions.assertEquals(PlayerMark.HUMAN,winChecker.getWinResult().getWinner());
    }


    @Test
    public void antiDiagonalWinTest() {
        initializeWinCheckerAndBoardSquares();
        board.triggerSquareAt(new Position(0,2),PlayerMark.HUMAN);
        board.triggerSquareAt(new Position(1,1),PlayerMark.HUMAN);
        board.triggerSquareAt(new Position(2,0),PlayerMark.HUMAN);
        Assertions.assertEquals(PlayerMark.HUMAN, winChecker.getWinner());

    }

    private void initializeWinCheckerAndBoardSquares() {
        board = new Board();
        winChecker = new AdvancedWinChecker(new GamePlayStatus(board));
        winChecker.startChecking();
    }


}

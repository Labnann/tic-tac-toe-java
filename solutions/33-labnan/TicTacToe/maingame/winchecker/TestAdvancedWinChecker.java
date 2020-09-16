package maingame.winchecker;

import maingame.Board.Board;
import maingame.PlayerMarkEnum;
import maingame.Position;
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
        Assertions.assertEquals(PlayerMarkEnum.HUMAN, winChecker.getWinner());
    }


    private void populateColumnWithCross(int column) {
        for (int i = 0; i < 3; i++) {
            board.triggerSquareAt(new Position(column,i), PlayerMarkEnum.HUMAN);
        }
    }

    private void populateRowWithZero(int row) {
        for (int i = 0; i < 3; i++) {
            board.triggerSquareAt(new Position(row,i), PlayerMarkEnum.AI);
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
        Assertions.assertEquals(PlayerMarkEnum.AI, winChecker.getWinner());
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
        board.triggerSquareAt(new Position(0,0), PlayerMarkEnum.HUMAN);
        board.triggerSquareAt(new Position(1,0), PlayerMarkEnum.HUMAN);
        board.triggerSquareAt(new Position(2,0), PlayerMarkEnum.AI);
    }

    private void populateRowCUnequally() {
        board.triggerSquareAt(new Position(0,0), PlayerMarkEnum.HUMAN);
        board.triggerSquareAt(new Position(0,1), PlayerMarkEnum.HUMAN);
        board.triggerSquareAt(new Position(0,2), PlayerMarkEnum.AI);
    }

    private void populateDiagonals(PlayerMarkEnum turnType) {
        board.triggerSquareAt(new Position(0,0),turnType);
        board.triggerSquareAt(new Position(1,1),turnType);
        board.triggerSquareAt(new Position(2,2),turnType);
    }

    @Test
    public void diagonalWinTest(){
        initializeWinCheckerAndBoardSquares();
        populateDiagonals(PlayerMarkEnum.HUMAN);
        Assertions.assertEquals(PlayerMarkEnum.HUMAN,winChecker.getWinResult().getWinner());
    }


    @Test
    public void antiDiagonalWinTest() {
        initializeWinCheckerAndBoardSquares();
        board.triggerSquareAt(new Position(0,2), PlayerMarkEnum.HUMAN);
        board.triggerSquareAt(new Position(1,1), PlayerMarkEnum.HUMAN);
        board.triggerSquareAt(new Position(2,0), PlayerMarkEnum.HUMAN);
        Assertions.assertEquals(PlayerMarkEnum.HUMAN, winChecker.getWinner());

    }

    private void initializeWinCheckerAndBoardSquares() {
        board = new Board();
        winChecker = new AdvancedWinChecker(new GamePlayStatus(board));
        winChecker.startChecking();
    }


}

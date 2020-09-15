package maingame.gamestatus;

import maingame.Board.Board;
import maingame.PlayerMark;
import maingame.Board.SmallCell;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GameStatusTester {
    Board board = new Board();
    SmallCell[][] smallCells = board.getSmallCells();
    GameStatus status = new GamePlayStatus(board);



    @Test
    public void leadingDiagonalWinCase_GettingCountOfEveryParameters() {
        smallCells[0][0].setTurnType(PlayerMark.HUMAN);
        smallCells[1][1].setTurnType(PlayerMark.HUMAN);
        smallCells[2][2].setTurnType(PlayerMark.HUMAN);

        Assertions.assertEquals(1, status.getRowChecker()[0].getCount());
        Assertions.assertEquals(1, status.getRowChecker()[1].getCount());
        Assertions.assertEquals(1, status.getRowChecker()[2].getCount());
        Assertions.assertEquals(3, status.getDiagonalChecker().getCount());
        Assertions.assertEquals(1, status.getAntiDiagonalChecker().getCount());
        Assertions.assertEquals(1, status.getColumnChecker()[0].getCount());
        Assertions.assertEquals(1, status.getColumnChecker()[1].getCount());
        Assertions.assertEquals(1, status.getColumnChecker()[2].getCount());
       // Assertions.assertFalse(gameWatcher.isDraw());

    }

    @Test
    public void testCheckGameDraw() {
        smallCells[0][0].setTurnType(PlayerMark.HUMAN);
        smallCells[0][1].setTurnType(PlayerMark.AI);
        smallCells[1][0].setTurnType(PlayerMark.AI);
        smallCells[1][1].setTurnType(PlayerMark.HUMAN);
        smallCells[1][2].setTurnType(PlayerMark.HUMAN);
        smallCells[2][0].setTurnType(PlayerMark.AI);
        smallCells[2][1].setTurnType(PlayerMark.HUMAN);
        smallCells[2][2].setTurnType(PlayerMark.AI);
      //  Assertions.assertTrue(gameWatcher.isDraw());


    }
}

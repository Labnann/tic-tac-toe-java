package maingame.gamestatus;

import maingame.Board.Board;
import maingame.PlayerMark.CrossMark;
import maingame.Position;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GameStatusTester {
    Board board = new Board();
    GameStatus status = new GamePlayStatus(board);



    @Test
    public void leadingDiagonalWinCase_GettingCountOfEveryParameters() {
        board.triggerSquareAt(new Position(0,0), new CrossMark());
        board.triggerSquareAt(new Position(1,1), new CrossMark());
        board.triggerSquareAt(new Position(2,2), new CrossMark());

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
    public void testCount() {
        board.triggerSquareAt(new Position(0,0), new CrossMark());
        board.triggerSquareAt(new Position(0,1), new CrossMark());
        board.triggerSquareAt(new Position(1,0), new CrossMark());
        board.triggerSquareAt(new Position(1,1), new CrossMark());
        board.triggerSquareAt(new Position(1,2), new CrossMark());
        board.triggerSquareAt(new Position(2,0), new CrossMark());
        board.triggerSquareAt(new Position(2,1), new CrossMark());
        board.triggerSquareAt(new Position(2,2), new CrossMark());
        Assertions.assertEquals(status.getTurnCount(),8);
    }
}

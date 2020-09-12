package maingame;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GameStatusTester {
    Board board = new Board();
    SmallCell[][] smallCells = board.getSmallCells();
    GameStatus status = new GameStatus(smallCells);



    @Test
    public void leadingDiagonalWinCase_GettingCountOfEveryParameters() {
        smallCells[0][0].setTurnType(SmallCell.Type.CROSS);
        smallCells[1][1].setTurnType(SmallCell.Type.CROSS);
        smallCells[2][2].setTurnType(SmallCell.Type.CROSS);

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
        smallCells[0][0].setTurnType(SmallCell.Type.CROSS);
        smallCells[0][1].setTurnType(SmallCell.Type.ZERO);
        smallCells[1][0].setTurnType(SmallCell.Type.ZERO);
        smallCells[1][1].setTurnType(SmallCell.Type.CROSS);
        smallCells[1][2].setTurnType(SmallCell.Type.CROSS);
        smallCells[2][0].setTurnType(SmallCell.Type.ZERO);
        smallCells[2][1].setTurnType(SmallCell.Type.CROSS);
        smallCells[2][2].setTurnType(SmallCell.Type.ZERO);
      //  Assertions.assertTrue(gameWatcher.isDraw());


    }
}

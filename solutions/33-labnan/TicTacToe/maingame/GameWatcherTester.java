package maingame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GameWatcherTester {

    SmallCell[][] smallCells = new SmallCell[3][3];
    Board board = new Board(smallCells);
    GameWatcher gameWatcher;

    private void initializeSmallCells() {
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                smallCells[i][j] = new SmallCell();
            }
        }
    }

    @Test
    public void leadingDiagonalWinCase_GettingCountOfEveryParameters() {
        initializeSmallCells();
        board.getSmallCells();
        smallCells = board.getSmallCells();
        gameWatcher = new GameWatcher(smallCells);
        smallCells[0][0].setTurnType(SmallCell.Type.CROSS);
        smallCells[1][1].setTurnType(SmallCell.Type.CROSS);
        smallCells[2][2].setTurnType(SmallCell.Type.CROSS);

        Assertions.assertEquals(1, gameWatcher.getColumnLine()[0].getCount());
        Assertions.assertEquals(1, gameWatcher.getColumnLine()[1].getCount());
        Assertions.assertEquals(1, gameWatcher.getColumnLine()[2].getCount());
        Assertions.assertEquals(3, gameWatcher.getLeadingDiagonalLine().getCount());
        Assertions.assertEquals(1, gameWatcher.getAntiDiagonalLine().getCount());
        Assertions.assertEquals(1, gameWatcher.getRowLine()[0].getCount());
        Assertions.assertEquals(1, gameWatcher.getRowLine()[1].getCount());
        Assertions.assertEquals(1, gameWatcher.getRowLine()[2].getCount());
        Assertions.assertFalse(gameWatcher.isDraw());

    }

    @Test
    public void testCheckGameDraw() {
        initializeSmallCells();
        board.getSmallCells();
        smallCells = board.getSmallCells();
        gameWatcher = new GameWatcher(smallCells);
        smallCells[0][0].setTurnType(SmallCell.Type.CROSS);
        smallCells[0][1].setTurnType(SmallCell.Type.ZERO);
        smallCells[1][0].setTurnType(SmallCell.Type.ZERO);
        smallCells[1][1].setTurnType(SmallCell.Type.CROSS);
        smallCells[1][2].setTurnType(SmallCell.Type.CROSS);
        smallCells[2][0].setTurnType(SmallCell.Type.ZERO);
        smallCells[2][1].setTurnType(SmallCell.Type.CROSS);
        smallCells[2][2].setTurnType(SmallCell.Type.ZERO);
        Assertions.assertTrue(gameWatcher.isDraw());


    }
}

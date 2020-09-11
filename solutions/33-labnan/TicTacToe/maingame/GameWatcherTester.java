package maingame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GameWatcherTester {
    Board board = new Board();
    SmallCell[][] smallCells;
    GameWatcher gameWatcher;


    @BeforeClass
    public static void setup() throws InterruptedException {
        JavaFXInitializer.initialize();
    }

    @Test
    public void leadingDiagonalWinCase_GettingCountOfEveryParameters() {
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

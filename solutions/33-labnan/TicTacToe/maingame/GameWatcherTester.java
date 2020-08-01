package maingame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GameWatcherTester {
    Board board = new Board();
    LogicBasedBox[][] logicBasedBoxes;
    GameWatcher gameWatcher;


    @BeforeClass
    public static void setup() throws InterruptedException {
        JavaFXInitializer.initialize();
    }

    @Test
    public void leadingDiagonalWinCase_GettingCountOfEveryParameters() {
        board.getLogicBasedBoxes();
        logicBasedBoxes = board.getLogicBasedBoxes();
        gameWatcher = new GameWatcher(logicBasedBoxes);
        logicBasedBoxes[0][0].setTurnType(LogicBasedBox.Type.CROSS);
        logicBasedBoxes[1][1].setTurnType(LogicBasedBox.Type.CROSS);
        logicBasedBoxes[2][2].setTurnType(LogicBasedBox.Type.CROSS);

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
}

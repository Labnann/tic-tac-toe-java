package maingame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BoardUITest {
    BoardUI boardUi = new BoardUI();
    SmallCell[][] smallCells = boardUi.getSmallCells();

    @BeforeClass
    public static void setup() throws InterruptedException {
        JavaFXInitializer.initialize();
    }

    @Test
    public void testBoardSquareDoubleTrigger() {

        simultaneouslyTrigger(0, 0);
        Assertions.assertEquals(SmallCell.Type.CROSS, smallCells[0][0].getTurnType());
    }

    private void simultaneouslyTrigger(int i, int j) {
        boardUi.triggerSquare(smallCells[0][i]);
        boardUi.triggerSquare(smallCells[0][j]);
    }

    @Test
    public void testBoardSquareSecondTrigger() {

        simultaneouslyTrigger(0, 1);
        Assertions.assertEquals(SmallCell.Type.ZERO, smallCells[0][1].getTurnType());
    }

    @Test
    public void testSetStartingTurn() {
        boardUi.setStartingTurn(SmallCell.Type.ZERO);
        simultaneouslyTrigger(0, 1);
        Assertions.assertEquals(SmallCell.Type.ZERO, smallCells[0][0].getTurnType());
        Assertions.assertEquals(SmallCell.Type.CROSS, smallCells[0][1].getTurnType());
    }


}

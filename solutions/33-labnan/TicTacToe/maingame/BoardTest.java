package maingame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BoardTest {
    Board board = new Board();
    SmallCellUI[][] smallCellUIS = board.getSmallCellUIS();

    @BeforeClass
    public static void setup() throws InterruptedException {
        JavaFXInitializer.initialize();
    }

    @Test
    public void testBoardSquareDoubleTrigger() {

        simultaneouslyTrigger(0, 0);
        Assertions.assertEquals(SmallCell.Type.CROSS, smallCellUIS[0][0].getTurnType());
    }

    private void simultaneouslyTrigger(int i, int j) {
        board.triggerSquare(smallCellUIS[0][i]);
        board.triggerSquare(smallCellUIS[0][j]);
    }

    @Test
    public void testBoardSquareSecondTrigger() {

        simultaneouslyTrigger(0, 1);
        Assertions.assertEquals(SmallCell.Type.ZERO, smallCellUIS[0][1].getTurnType());
    }

    @Test
    public void testSetStartingTurn() {
        board.setStartingTurn(SmallCell.Type.ZERO);
        simultaneouslyTrigger(0, 1);
        Assertions.assertEquals(SmallCell.Type.ZERO, smallCellUIS[0][0].getTurnType());
        Assertions.assertEquals(SmallCell.Type.CROSS, smallCellUIS[0][1].getTurnType());
    }


}

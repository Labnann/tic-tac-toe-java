package maingame;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BoardTest {
    SmallCell[][] smallCells;
    Board board = new Board();


    private void initializeSmallCells() {
        smallCells = board.getSmallCells();
    }



    @Test
    public void testBoardSquareDoubleTrigger() {
        initializeSmallCells();
        simultaneouslyTrigger(0, 0);
        Assertions.assertEquals(PlayerMark.HUMAN, smallCells[0][0].getTurnType());
    }

    private void simultaneouslyTrigger(int i, int j) {
        board.triggerSquare(smallCells[0][i]);
        board.triggerSquare(smallCells[0][j]);
    }

    @Test
    public void testBoardSquareSecondTrigger() {
        initializeSmallCells();
        simultaneouslyTrigger(0, 1);
        Assertions.assertEquals(PlayerMark.AI, smallCells[0][1].getTurnType());
    }

    @Test
    public void testSetStartingTurn() {
        initializeSmallCells();
        board.setStartingTurn(PlayerMark.AI);
        simultaneouslyTrigger(0, 1);
        Assertions.assertEquals(PlayerMark.AI, smallCells[0][0].getTurnType());
        Assertions.assertEquals(PlayerMark.HUMAN, smallCells[0][1].getTurnType());
    }


}

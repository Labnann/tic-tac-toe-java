package maingame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BoardTest {
    SmallCell[][] smallCells = new SmallCell[3][3];
    Board board = new Board(smallCells);


    private void initializeSmallCells() {
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                smallCells[i][j] = new SmallCell();
            }
        }
    }



    @Test
    public void testBoardSquareDoubleTrigger() {
        initializeSmallCells();
        simultaneouslyTrigger(0, 0);
        Assertions.assertEquals(SmallCell.Type.CROSS, smallCells[0][0].getTurnType());
    }

    private void simultaneouslyTrigger(int i, int j) {
        board.triggerSquare(smallCells[0][i]);
        board.triggerSquare(smallCells[0][j]);
    }

    @Test
    public void testBoardSquareSecondTrigger() {
        initializeSmallCells();
        simultaneouslyTrigger(0, 1);
        Assertions.assertEquals(SmallCell.Type.ZERO, smallCells[0][1].getTurnType());
    }

    @Test
    public void testSetStartingTurn() {
        initializeSmallCells();
        board.setStartingTurn(SmallCell.Type.ZERO);
        simultaneouslyTrigger(0, 1);
        Assertions.assertEquals(SmallCell.Type.ZERO, smallCells[0][0].getTurnType());
        Assertions.assertEquals(SmallCell.Type.CROSS, smallCells[0][1].getTurnType());
    }


}

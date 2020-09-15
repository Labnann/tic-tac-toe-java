package maingame;

import maingame.player.Human;
import maingame.player.Player;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BoardTest {
    SmallCell[][] smallCells;
    Board board = new Board();


    private void initializeSmallCells() {
        smallCells = board.getSmallCells();
    }




    private void simultaneouslyTrigger(int i, int j, PlayerMark playerMark) {
        board.triggerSquare(new Position(0,i),playerMark);
        board.triggerSquare(new Position(0,j), playerMark);
    }

    @Test
    public void testBoardChangeListener(){
        initializeSmallCells();
        final int[] count = {0};
        board.addOnChangeListener(() -> count[0]++);
        board.triggerSquare(new Position(0,0),PlayerMark.AI);
        Assertions.assertEquals(1,count[0]);
    }

    @Test
    public void testAITrigger() {
        initializeSmallCells();
        simultaneouslyTrigger(0, 1,PlayerMark.AI);
        Assertions.assertEquals(PlayerMark.AI, board.getMarkAtPosition(new Position(0,1)));
    }

    @Test
    public void testHumanTrigger() {
        initializeSmallCells();
        simultaneouslyTrigger(0, 1,PlayerMark.HUMAN);
        Assertions.assertEquals(PlayerMark.HUMAN,board.getMarkAtPosition(new Position(0,1)));
        Assertions.assertNull(board.getMarkAtPosition(new Position(2, 2)));
    }


}

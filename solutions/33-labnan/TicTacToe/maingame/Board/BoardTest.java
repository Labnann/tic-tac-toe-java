package maingame.Board;

import maingame.PlayerMark.CrossMark;
import maingame.PlayerMark.PlayerMark;
import maingame.PlayerMark.ZeroMark;
import maingame.Position;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BoardTest {

    Board board = new Board();

    private void simultaneouslyTrigger(int i, int j, PlayerMark playerMark) {
        board.triggerSquareAt(new Position(0,i), playerMark);
        board.triggerSquareAt(new Position(0,j), playerMark);
    }

    @Test
    public void testBoardChangeListener(){
        final int[] count = {0};
        board.addOnChangeListener(() -> count[0]++);
        board.triggerSquareAt(new Position(0,0), new ZeroMark());
        Assertions.assertEquals(1,count[0]);
    }

    @Test
    public void testAITrigger() {
        simultaneouslyTrigger(0, 1, new ZeroMark());
        Assertions.assertTrue(board.getMarkAtPosition(new Position(0,1)) instanceof ZeroMark);
    }

    @Test
    public void testHumanTrigger() {
        simultaneouslyTrigger(0, 1, new CrossMark());
        Assertions.assertTrue(board.getMarkAtPosition(new Position(0,1)) instanceof CrossMark);
        Assertions.assertNull(board.getMarkAtPosition(new Position(2, 2)));
    }


}

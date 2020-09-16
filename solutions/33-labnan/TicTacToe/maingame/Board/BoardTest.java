package maingame.Board;

import maingame.PlayerMarkEnum;
import maingame.Position;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BoardTest {

    Board board = new Board();

    private void simultaneouslyTrigger(int i, int j, PlayerMarkEnum playerMarkEnum) {
        board.triggerSquareAt(new Position(0,i), playerMarkEnum);
        board.triggerSquareAt(new Position(0,j), playerMarkEnum);
    }

    @Test
    public void testBoardChangeListener(){
        final int[] count = {0};
        board.addOnChangeListener(() -> count[0]++);
        board.triggerSquareAt(new Position(0,0), PlayerMarkEnum.AI);
        Assertions.assertEquals(1,count[0]);
    }

    @Test
    public void testAITrigger() {
        simultaneouslyTrigger(0, 1, PlayerMarkEnum.AI);
        Assertions.assertEquals(PlayerMarkEnum.AI, board.getMarkAtPosition(new Position(0,1)));
    }

    @Test
    public void testHumanTrigger() {
        simultaneouslyTrigger(0, 1, PlayerMarkEnum.HUMAN);
        Assertions.assertEquals(PlayerMarkEnum.HUMAN,board.getMarkAtPosition(new Position(0,1)));
        Assertions.assertNull(board.getMarkAtPosition(new Position(2, 2)));
    }


}

package maingame.player;

import maingame.Board;
import maingame.gamestatus.GamePlayStatus;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerTester {
    Board board = new Board();
    Human human = new HumanPlayer(board.getSmallCells());
    AI ai = new RandomAI(human,board.getSmallCells(),new GamePlayStatus(board.getSmallCells()));
    int triggerCount = 0;
    @Test
    public void testRandomAI(){
        ai.start();
        board.addOnChangeListener(() -> triggerCount++);
        human.placeMark(1,2);
        Assertions.assertEquals(2,triggerCount);

    }
}

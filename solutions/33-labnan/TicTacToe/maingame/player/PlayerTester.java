package maingame.player;

import maingame.Board;
import maingame.gamestatus.GamePlayStatus;
import maingame.gamestatus.GameStatus;
import maingame.winchecker.AdvancedWinChecker;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerTester {
    Board board = new Board();
    GameStatus gamestatus = new GamePlayStatus(board.getSmallCells());
    Human human = new HumanPlayer(board.getSmallCells(),new AdvancedWinChecker(gamestatus));
    AI ai = new RandomAI(human,board.getSmallCells(),gamestatus);
    int triggerCount = 0;
    @Test
    public void testRandomAI(){
        ai.start();
        board.addOnChangeListener(() -> triggerCount++);
        human.placeMark(1,2);
        Assertions.assertEquals(2,triggerCount);

    }
}

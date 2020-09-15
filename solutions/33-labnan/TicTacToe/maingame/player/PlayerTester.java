package maingame.player;

import maingame.Board.Board;
import maingame.Position;
import maingame.gamestatus.GamePlayStatus;
import maingame.gamestatus.GameStatus;
import maingame.winchecker.AdvancedWinChecker;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerTester {
    Board board = new Board();
    GameStatus gamestatus = new GamePlayStatus(board);
    Human human = new HumanPlayer(board,new AdvancedWinChecker(gamestatus));
    AI ai = new RandomAI(human,board,gamestatus);
    int triggerCount = 0;
    @Test
    public void testRandomAI(){
        ai.start();
        board.addOnChangeListener(() -> triggerCount++);
        human.placeMark(new Position(1,2));
        Assertions.assertEquals(2,triggerCount);

    }
}

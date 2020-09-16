package maingame.player;

import maingame.Board.Board;
import maingame.PlayerMarkEnum;
import maingame.Position;
import maingame.gamestatus.GamePlayStatus;
import maingame.gamestatus.GameStatus;
import maingame.winchecker.AdvancedWinChecker;
import maingame.winchecker.WinChecker;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DefensiveAITest {
    Board board;
    Human human;
    DefensiveAI defensiveAI;

    @Test
    public void defensiveAIatDiagonalTest(){
        initialize();
        defensiveAI.start();
        board.triggerSquareAt(new Position(0,0), PlayerMarkEnum.HUMAN);
        human.placeMark(new Position(1,1));
        Assertions.assertEquals(board.getMarkAtPosition(new Position(2,2)), PlayerMarkEnum.AI);

        initialize();
        defensiveAI.start();
        board.triggerSquareAt(new Position(1,1), PlayerMarkEnum.HUMAN);
        human.placeMark(new Position(2,2));
        Assertions.assertEquals(board.getMarkAtPosition(new Position(0,0)), PlayerMarkEnum.AI);

        initialize();
        defensiveAI.start();
        board.triggerSquareAt(new Position(0,0), PlayerMarkEnum.HUMAN);
        human.placeMark(new Position(2,2));
        Assertions.assertEquals(getMarkAtPosition(1,1), PlayerMarkEnum.AI);
    }

    PlayerMarkEnum getMarkAtPosition(int row, int col){
        return board.getMarkAtPosition(new Position(row,col));
    }

    @Test
    public void testColumn(){
        initialize();
        int i = 0;
        defensiveAI.start();

        board.triggerSquareAt(new Position(0,i), PlayerMarkEnum.HUMAN);
        human.placeMark(new Position(2,i));
        Assertions.assertEquals(getMarkAtPosition(1,i), PlayerMarkEnum.AI);


        initialize();
        i++;
        defensiveAI.start();
        board.triggerSquareAt(new Position(0,i), PlayerMarkEnum.HUMAN);
        human.placeMark(new Position(2,i));
        Assertions.assertEquals(getMarkAtPosition(1,i), PlayerMarkEnum.AI);



        initialize();
        i++;
        defensiveAI.start();
        board.triggerSquareAt(new Position(0,i), PlayerMarkEnum.HUMAN);
        human.placeMark(new Position(2,i));
        Assertions.assertEquals(getMarkAtPosition(1,i), PlayerMarkEnum.AI);



    }
    @Test
    public void testRow(){
        initialize();
        int i = 0;
        defensiveAI.start();
        board.triggerSquareAt( new Position(i,0), PlayerMarkEnum.HUMAN);
        human.placeMark(new Position(i,2));
        Assertions.assertEquals(getMarkAtPosition(i,1), PlayerMarkEnum.AI);


        initialize();
        i++;
        defensiveAI.start();
        board.triggerSquareAt( new Position(i,0), PlayerMarkEnum.HUMAN);
        human.placeMark(new Position(i,2));
        Assertions.assertEquals(getMarkAtPosition(i,1), PlayerMarkEnum.AI);

        initialize();
        i++;
        defensiveAI.start();

        board.triggerSquareAt( new Position(i,0), PlayerMarkEnum.HUMAN);
        human.placeMark(new Position(i,2));
        Assertions.assertEquals(getMarkAtPosition(i,1), PlayerMarkEnum.AI);
    }

    @Test
    public void antiDiagonalTest(){
        initialize();
        defensiveAI.start();
        board.triggerSquareAt(new Position(2,0), PlayerMarkEnum.HUMAN);
        human.placeMark(new Position(0,2));
        Assertions.assertEquals(PlayerMarkEnum.AI,getMarkAtPosition(1,1));

        initialize();
        defensiveAI.start();
        board.triggerSquareAt(new Position(2,0), PlayerMarkEnum.HUMAN);
        human.placeMark(new Position(0,2));
        Assertions.assertEquals(PlayerMarkEnum.AI,getMarkAtPosition(1,1));

    }

    @Test
    public void randomWorksTest(){
        board = new Board();
        GameStatus gameStatus = new GamePlayStatus(board);
        human = new HumanPlayer(board, new AdvancedWinChecker(gameStatus));
        defensiveAI = new DefensiveAI(human,board,gameStatus);
        defensiveAI.start();
        final int[] triggered = {0};
        board.addOnChangeListener(() -> triggered[0]++);
        human.placeMark(new Position(0,0));
        Assertions.assertEquals(2,triggered[0]);
    }


    void initialize(){
        board = new Board();
        GameStatus gameStatus = new GamePlayStatus(board);
        WinChecker winChecker = new AdvancedWinChecker(gameStatus);
        human = new HumanPlayer(board,winChecker);
        defensiveAI = new DefensiveAI(human,board,gameStatus);
    }
}

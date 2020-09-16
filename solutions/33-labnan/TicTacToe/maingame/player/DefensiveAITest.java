package maingame.player;

import maingame.Board.Board;
import maingame.PlayerMark.CrossMark;
import maingame.PlayerMark.PlayerMark;
import maingame.PlayerMark.ZeroMark;
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
    public void defensiveAIatDiagonalTest() {
        initialize();
        defensiveAI.start();
        board.triggerSquareAt(new Position(0, 0), new CrossMark());
        human.placeMark(new Position(1, 1));
        Assertions.assertEquals(board.getMarkAtPosition(new Position(2, 2)).getType(), new ZeroMark().getType());

        initialize();
        defensiveAI.start();
        board.triggerSquareAt(new Position(1, 1), new CrossMark());
        human.placeMark(new Position(2, 2));
        Assertions.assertEquals(board.getMarkAtPosition(new Position(0, 0)).getType(), new ZeroMark().getType());

        initialize();
        defensiveAI.start();
        board.triggerSquareAt(new Position(0, 0), new CrossMark());
        human.placeMark(new Position(2, 2));
        Assertions.assertEquals(getMarkAtPosition(1, 1).getType(), new ZeroMark().getType());
    }

    PlayerMark getMarkAtPosition(int row, int col){
        return board.getMarkAtPosition(new Position(row,col));
    }

    @Test
    public void testColumn() {
        initialize();
        int i = 0;
        defensiveAI.start();

        board.triggerSquareAt(new Position(0, i), new CrossMark());
        human.placeMark(new Position(2, i));
        Assertions.assertEquals(getMarkAtPosition(1, i).getType(), new ZeroMark().getType());


        initialize();
        i++;
        defensiveAI.start();
        board.triggerSquareAt(new Position(0, i), new CrossMark());
        human.placeMark(new Position(2, i));
        Assertions.assertEquals(getMarkAtPosition(1, i).getType(), new ZeroMark().getType());


        initialize();
        i++;
        defensiveAI.start();
        board.triggerSquareAt(new Position(0, i), new CrossMark());
        human.placeMark(new Position(2, i));
        Assertions.assertEquals(getMarkAtPosition(1, i).getType(), new ZeroMark().getType());


    }
    @Test
    public void testRow() {
        initialize();
        int i = 0;
        defensiveAI.start();
        board.triggerSquareAt(new Position(i, 0), new CrossMark());
        human.placeMark(new Position(i, 2));
        Assertions.assertEquals(getMarkAtPosition(i, 1).getType(), new ZeroMark().getType());


        initialize();
        i++;
        defensiveAI.start();
        board.triggerSquareAt(new Position(i, 0), new CrossMark());
        human.placeMark(new Position(i, 2));
        Assertions.assertEquals(getMarkAtPosition(i, 1).getType(), new ZeroMark().getType());

        initialize();
        i++;
        defensiveAI.start();

        board.triggerSquareAt(new Position(i, 0), new CrossMark());
        human.placeMark(new Position(i, 2));
        Assertions.assertEquals(getMarkAtPosition(i, 1).getType(), new ZeroMark().getType());
    }

    @Test
    public void antiDiagonalTest() {
        initialize();
        defensiveAI.start();
        board.triggerSquareAt(new Position(2, 0), new CrossMark());
        human.placeMark(new Position(0, 2));
        Assertions.assertEquals(new ZeroMark().getType(), getMarkAtPosition(1, 1).getType());

        initialize();
        defensiveAI.start();
        board.triggerSquareAt(new Position(2, 0), new CrossMark());
        human.placeMark(new Position(0, 2));
        Assertions.assertEquals(new ZeroMark().getType(), getMarkAtPosition(1, 1).getType());

    }

    @Test
    public void randomWorksTest() {
        board = new Board();
        GameStatus gameStatus = new GamePlayStatus(board);
        human = new Human(board, new AdvancedWinChecker(gameStatus));
        defensiveAI = new DefensiveAI(human, board, gameStatus);
        defensiveAI.start();
        final int[] triggered = {0};
        board.addOnChangeListener(() -> triggered[0]++);
        human.placeMark(new Position(0, 0));
        Assertions.assertEquals(2, triggered[0]);
    }


    void initialize() {
        board = new Board();
        GameStatus gameStatus = new GamePlayStatus(board);
        WinChecker winChecker = new AdvancedWinChecker(gameStatus);
        human = new Human(board, winChecker);
        defensiveAI = new DefensiveAI(human, board, gameStatus);
    }
}

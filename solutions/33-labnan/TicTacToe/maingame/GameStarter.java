package maingame;

import maingame.gamestatus.GamePlayStatus;
import maingame.gamestatus.GameStatus;
import maingame.player.*;
import maingame.winchecker.AdvancedWinChecker;
import maingame.winchecker.WinChecker;

public class GameStarter{
    AI randomAI, defensiveAI;
    private Human humanPlayer;
    private Board board;
    private GameStatus gameStatus;
    WinChecker winChecker;

    GameStarter(){
        start();
    }



    public Human getHumanPlayer() {
        return humanPlayer;
    }




    public Board getBoard() {
        return board;
    }


    void start() {
        board = new Board();
        gameStatus = new GamePlayStatus(board.getSmallCells());
        humanPlayer = new HumanPlayer(board.getSmallCells());
        winChecker = new AdvancedWinChecker(gameStatus);
        winChecker.startChecking();
        randomAI = new RandomAI(humanPlayer,board.getSmallCells(),gameStatus);
        randomAI.start();
    }

    public WinChecker getWinChecker() {
        return winChecker;
    }

    void useDefensiveAI(){
        randomAI.stop();
        defensiveAI = new DefensiveAI(humanPlayer,board.getSmallCells(),gameStatus);
        defensiveAI.start();
     }



}



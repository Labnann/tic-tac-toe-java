package maingame;

import maingame.Board.Board;
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
        gameStatus = new GamePlayStatus(board);
        winChecker = new AdvancedWinChecker(gameStatus);
        humanPlayer = new HumanPlayer(board,winChecker);

        winChecker.startChecking();
        randomAI = new RandomAI(humanPlayer,board,gameStatus);
        defensiveAI = new DefensiveAI(humanPlayer,board,gameStatus);
        randomAI.start();
    }

    public WinChecker getWinChecker() {
        return winChecker;
    }

    void useDefensiveAI(){
        randomAI.stop();
        defensiveAI.start();
     }

     void stopAI(){
        randomAI.stop();
        defensiveAI.stop();
     }



}




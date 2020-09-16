package maingame;

import maingame.Board.Board;
import maingame.gamestatus.GamePlayStatus;
import maingame.gamestatus.GameStatus;
import maingame.player.*;
import maingame.winchecker.AdvancedWinChecker;
import maingame.winchecker.WinChecker;

public class GameStarter{
    AI randomAI, defensiveAI;
    private ListenablePlayer listenablePlayerPlayer;
    private Board board;
    private GameStatus gameStatus;
    WinChecker winChecker;

    GameStarter(){
        start();
    }



    public ListenablePlayer getListenablePlayerPlayer() {
        return listenablePlayerPlayer;
    }




    public Board getBoard() {
        return board;
    }


    void start() {
        board = new Board();
        gameStatus = new GamePlayStatus(board);
        winChecker = new AdvancedWinChecker(gameStatus);
        listenablePlayerPlayer = new ListenablePlayerPlayer(board,winChecker);

        winChecker.startChecking();
        randomAI = new RandomAI(listenablePlayerPlayer,board,gameStatus);
        defensiveAI = new DefensiveAI(listenablePlayerPlayer,board,gameStatus);
        randomAI.start();
    }

    public WinChecker getWinChecker() {
        return winChecker;
    }

    void useDefensiveAI(){
        randomAI.stop();
        defensiveAI.start();
     }

     public void stopAI(){
        randomAI.stop();
        defensiveAI.stop();
     }



}




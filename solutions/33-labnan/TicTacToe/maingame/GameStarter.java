package maingame;

import maingame.Board.Board;
import maingame.gamestatus.GamePlayStatus;
import maingame.gamestatus.GameStatus;
import maingame.player.*;
import maingame.winchecker.AdvancedWinChecker;
import maingame.winchecker.WinChecker;

public class GameStarter{
    AI randomAI, defensiveAI;
    private ListenablePlayer player;
    private Board board;
    WinChecker winChecker;

    GameStarter() {
        start();
    }


    public InterfaceUserPlayer getInerfaceUser() {
        InterfaceUserPlayer interfaceUserPlayer = null;
        try {
            interfaceUserPlayer = (InterfaceUserPlayer) player;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Wrong Player!");
        }
        return interfaceUserPlayer;
    }


    public Board getBoard() {
        return board;
    }


    void start() {
        board = new Board();
        GameStatus gameStatus = new GamePlayStatus(board);
        winChecker = new AdvancedWinChecker(gameStatus);
        player = new Human(board, winChecker);
        winChecker.startChecking();
        randomAI = new RandomAI(player, board, gameStatus);
        defensiveAI = new DefensiveAI(player, board, gameStatus);
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




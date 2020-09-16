package maingame.winchecker;

import maingame.PlayerMark.PlayerMark;

public interface WinChecker {
    boolean isGameEnded();


    PlayerMark getWinner();

    void addOnGameEnd(GameEndListener gameEndListener);
    void startChecking();
    WinResult getWinResult();

    interface GameEndListener {
        void doOnGameEnd();
    }
}


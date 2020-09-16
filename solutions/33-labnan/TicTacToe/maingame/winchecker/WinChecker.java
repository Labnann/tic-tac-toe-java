package maingame.winchecker;

import maingame.PlayerMarkEnum;

public interface WinChecker {
    boolean isGameEnded();


    PlayerMarkEnum getWinner();

    void addOnGameEnd(GameEndListener gameEndListener);
    void startChecking();
    WinResult getWinResult();

    interface GameEndListener {
        void doOnGameEnd();
    }
}


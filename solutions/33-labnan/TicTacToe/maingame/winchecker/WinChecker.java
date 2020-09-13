package maingame.winchecker;

import maingame.PlayerMark;

public interface WinChecker {
    boolean isGameEnded();


    PlayerMark getWinner();

    void addOnGameEnd(GameEndListener gameEndListener);
    void startChecking();

    interface GameEndListener {
        void doOnGameEnd();
    }
}


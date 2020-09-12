package winchecker;

import maingame.PlayerMark;

public interface WinChecker {
    boolean isGameEnded();


    PlayerMark getWinner();

    void addOnGameEnd(GameEndListener gameEndListener);

    interface GameEndListener {
        void doOnGameEnd();
    }
}


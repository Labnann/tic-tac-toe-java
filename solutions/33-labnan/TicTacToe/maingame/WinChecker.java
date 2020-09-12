package maingame;

public interface WinChecker {
    boolean isGameEnded();


    SmallCell.Type getWinner();

    void addOnGameEnd(GameEndListener gameEndListener);

    interface GameEndListener {
        void doOnGameEnd();
    }
}


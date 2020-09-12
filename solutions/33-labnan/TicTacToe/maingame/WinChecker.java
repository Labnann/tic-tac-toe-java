package maingame;

public interface WinChecker {
    boolean isGameEnded();

    void checkWin();

    SmallCell.Type getWinner();

    void setOnGameEnd(GameEndListener gameEndListener);

    interface GameEndListener {
        void doOnGameEnd();
    }
}

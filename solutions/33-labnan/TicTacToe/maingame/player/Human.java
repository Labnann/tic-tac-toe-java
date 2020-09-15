package maingame.player;

import maingame.PlayerMark;

public interface Human extends Player{
    PlayerMark playermark = PlayerMark.HUMAN;
    void placeMark(int x, int y);
    void addOnMakeMoveListener(OnMakeMoveListener onMakeMoveListener);

    void removeListener(OnMakeMoveListener onMakeMoveListener);

    interface OnMakeMoveListener {
        void doOnMove();
    }
}

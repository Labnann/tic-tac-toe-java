package maingame.player;

import maingame.PlayerMark;
import maingame.Position;

public interface Human extends Player{
    PlayerMark playermark = PlayerMark.HUMAN;
    void placeMark(Position position);
    void addOnMakeMoveListener(OnMakeMoveListener onMakeMoveListener);

    void removeListener(OnMakeMoveListener onMakeMoveListener);

    interface OnMakeMoveListener {
        void doOnMove();
    }
}

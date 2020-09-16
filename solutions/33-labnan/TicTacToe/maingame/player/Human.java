package maingame.player;

import maingame.PlayerMark.PlayerMarkEnum;
import maingame.Position;

public interface Human extends Player{
    PlayerMarkEnum PLAYERMARK = PlayerMarkEnum.CROSS;
    void placeMark(Position position);
    void addOnMakeMoveListener(OnMakeMoveListener onMakeMoveListener);

    void removeListener(OnMakeMoveListener onMakeMoveListener);

    interface OnMakeMoveListener {
        void doOnMove();
    }
}

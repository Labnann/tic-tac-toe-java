package maingame.player;

import maingame.PlayerMark.PlayerMarkEnum;

public interface AI extends Player{
    PlayerMarkEnum PLAYER_MARK_ENUM = PlayerMarkEnum.ZERO;
    void start();
    void stop();
}

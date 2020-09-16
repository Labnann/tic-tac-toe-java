package maingame.player;

import maingame.PlayerMarkEnum;

public interface AI extends Player{
    PlayerMarkEnum PLAYER_MARK_ENUM = PlayerMarkEnum.AI;
    void start();
    void stop();
}

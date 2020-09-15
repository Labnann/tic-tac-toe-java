package maingame.player;

import maingame.PlayerMark;

public interface AI extends Player{
    PlayerMark playerMark = PlayerMark.AI;
    void start();
    void stop();
}

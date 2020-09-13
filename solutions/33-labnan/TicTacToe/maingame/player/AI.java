package maingame.player;

import maingame.PlayerMark;

public interface AI extends Player{
    PlayerMark PLAYER_MARK = PlayerMark.AI;
    void start();
}

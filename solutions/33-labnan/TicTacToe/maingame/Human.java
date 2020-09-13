package maingame;

public interface Human extends Player{
    PlayerMark PLAYER_MARK = PlayerMark.HUMAN;
    void addOnMakeMoveListener(OnMakeMoveListener onMakeMoveListener);
    interface OnMakeMoveListener {
        void doOnMove();
    }
}

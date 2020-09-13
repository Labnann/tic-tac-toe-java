package maingame;

public interface Human extends Player{
    PlayerMark PLAYER_MARK = PlayerMark.HUMAN;
    void placeMark(int x, int y);
    void addOnMakeMoveListener(OnMakeMoveListener onMakeMoveListener);

    void removeListener(OnMakeMoveListener onMakeMoveListener);

    interface OnMakeMoveListener {
        void doOnMove();
    }
}

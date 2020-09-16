package maingame.player;

public interface ListenablePlayer extends Player{

    void addOnMakeMoveListener(OnMakeMoveListener onMakeMoveListener);

    void removeListener(OnMakeMoveListener onMakeMoveListener);

    interface OnMakeMoveListener {
        void doOnMove();
    }
}

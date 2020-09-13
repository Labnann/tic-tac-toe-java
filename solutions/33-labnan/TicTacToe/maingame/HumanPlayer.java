package maingame;

import java.util.ArrayList;

public class HumanPlayer implements Human{

    ArrayList<OnMakeMoveListener> onMakeMoveListeners = new ArrayList<>();

    SmallCell[][] smallCells;
    public HumanPlayer(SmallCell[][] smallCells){
        this.smallCells = smallCells;
    }

    @Override
    public void placeMark(int x, int y) {
        smallCells[x][y].triggerSquareAs(PlayerMark.HUMAN);
        doOnMove();
    }

    private void doOnMove() {
        for(OnMakeMoveListener onMakeMoveListener : onMakeMoveListeners){
            if (onMakeMoveListener == null) {
                return;
            }
            onMakeMoveListener.doOnMove();
        }
    }

    @Override
    public void addOnMakeMoveListener(OnMakeMoveListener onMakeMoveListener) {
        onMakeMoveListeners.add(onMakeMoveListener);
    }


}

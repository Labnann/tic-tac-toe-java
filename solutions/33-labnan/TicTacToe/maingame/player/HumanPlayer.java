package maingame.player;

import maingame.PlayerMark;
import maingame.SmallCell;

import java.util.ArrayList;

public class HumanPlayer implements Human{

    ArrayList<OnMakeMoveListener> onMakeMoveListeners = new ArrayList<>();

    SmallCell[][] smallCells;
    public HumanPlayer(SmallCell[][] smallCells){
        this.smallCells = smallCells;
    }

    @Override
    public void placeMark(int x, int y) {
      if  (!smallCells[x][y].triggerSquareAs(PlayerMark.HUMAN)){
          return;
      }
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

    @Override
    public void removeListener(OnMakeMoveListener onMakeMoveListener) {
        onMakeMoveListeners.remove(onMakeMoveListener);
    }


    public void celebrateWinning() {
        System.out.println("\"A mare machine can't defeat me. Muhahahahaha\", says the mortal.");
    }
}

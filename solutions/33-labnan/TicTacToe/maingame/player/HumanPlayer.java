package maingame.player;

import maingame.Board;
import maingame.PlayerMark;
import maingame.SmallCell;
import maingame.winchecker.WinChecker;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class HumanPlayer implements Human{

    ArrayList<OnMakeMoveListener> onMakeMoveListeners = new ArrayList<>();

    SmallCell[][] smallCells;
    WinChecker winChecker;
    public HumanPlayer(Board board, WinChecker winChecker){
        this.smallCells = board.getSmallCells();
        this.winChecker = winChecker;
    }

    @Override
    public void placeMark(int x, int y) {
        if(winChecker.isGameEnded()){ return;}
      if  (!smallCells[x][y].triggerSquareAs(PlayerMark.HUMAN)){
          return;
      }
      try {
          doOnMove();
      }
      catch (ConcurrentModificationException exception){
          System.out.println("Let's just forget it >.>");
      }

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
        if(onMakeMoveListener!=null)
        onMakeMoveListeners.remove(onMakeMoveListener);
    }

}

package maingame.player;

import maingame.Board;
import maingame.Position;
import maingame.winchecker.WinChecker;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class HumanPlayer implements Human{

    ArrayList<OnMakeMoveListener> onMakeMoveListeners = new ArrayList<>();


    Board board;
    WinChecker winChecker;
    public HumanPlayer(Board board, WinChecker winChecker){
        this.winChecker = winChecker;
        this.board = board;
    }

    @Override
    public void placeMark(Position position) {
        if(winChecker.isGameEnded()){ return;}
        if(board.getMarkAtPosition(position)!=null) return;
        board.triggerSquareAt(position,playermark);
      try { doOnMove();}
      catch (ConcurrentModificationException exception){ System.out.println("Let's just forget it >.>"); }
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

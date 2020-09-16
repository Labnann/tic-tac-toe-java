package maingame.player;

import maingame.Board.Board;
import maingame.PlayerMark.CrossMark;
import maingame.PlayerMark.PlayerMark;
import maingame.Position;
import maingame.winchecker.WinChecker;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class ListenablePlayerPlayer implements ListenablePlayer {

    ArrayList<OnMakeMoveListener> onMakeMoveListeners = new ArrayList<>();


    Board board;
    WinChecker winChecker;
    PlayerMark playerMark = new CrossMark();
    public ListenablePlayerPlayer(Board board, WinChecker winChecker){
        this.winChecker = winChecker;
        this.board = board;
    }


    @Override
    public void setPlayerMark(PlayerMark playerMark) {
        this.playerMark = playerMark;
    }

    @Override
    public void placeMark(Position position) {
        if(winChecker.isGameEnded()){ return;}
        if(board.getMarkAtPosition(position)!=null) return;
        board.triggerSquareAt(position, playerMark);
      try { doOnMove();}
      catch (ConcurrentModificationException exception){ System.out.println("Let's just forget it >.>"); }
    }

    private void doOnMove() {
        for(OnMakeMoveListener onMakeMoveListener : onMakeMoveListeners){
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

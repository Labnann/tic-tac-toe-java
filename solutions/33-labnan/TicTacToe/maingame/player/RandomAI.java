package maingame.player;

import maingame.Board.Board;
import maingame.PlayerMark.PlayerMark;
import maingame.PlayerMark.ZeroMark;
import maingame.Position;
import maingame.gamestatus.GameStatus;

public class RandomAI implements AI{
    private ListenablePlayer listenablePlayerPlayer;
    private ListenablePlayer.OnMakeMoveListener onMakeMoveListener;
    private GameStatus gameStatus;
    private Board board;
    private PlayerMark playerMark = new ZeroMark();

    public RandomAI(ListenablePlayer listenablePlayerPlayer, Board board, GameStatus gameStatus){
        this.listenablePlayerPlayer = listenablePlayerPlayer;
        this.gameStatus = gameStatus;
        this.board = board;

    }

    @Override
    public void setPlayerMark(PlayerMark playerMark) {
        this.playerMark = playerMark;
    }

    public void start(){
        listenToHuman();
    }

    private void listenToHuman() {
        onMakeMoveListener = () -> {
            if(gameStatus.getTurnCount()!=9)
            move();
        };
        listenablePlayerPlayer.addOnMakeMoveListener(onMakeMoveListener);
    }

    private void move(){
        Position position = findMove();
        board.triggerSquareAt(position, playerMark);
    }

    Position findMove() {
       int r1 = makeRandomNumberIn1To3();
       int r2 = makeRandomNumberIn1To3();
       Position checkingPosition = new Position(r1,r2);
       if(board.getMarkAtPosition(checkingPosition)==null){
           return checkingPosition;
       }
       return findMove();
    }

    private int makeRandomNumberIn1To3(){
        return (int) ((Math.random()*10)%3);
    }

    public void stop(){
        listenablePlayerPlayer.removeListener(onMakeMoveListener);
    }

}

package maingame.player;

import maingame.Board.Board;
import maingame.Position;
import maingame.gamestatus.GameStatus;

public class RandomAI implements AI{
    Human humanPlayer;
    Human.OnMakeMoveListener onMakeMoveListener;
    GameStatus gameStatus;
    Board board;

    public RandomAI(Human humanPlayer, Board board, GameStatus gameStatus){
        this.humanPlayer = humanPlayer;
        this.gameStatus = gameStatus;
        this.board = board;

    }

    public void start(){
        listenToHuman();
    }

    private void listenToHuman() {
        onMakeMoveListener = () -> {
            if(gameStatus.getTurnCount()!=9)
            move();
        };
        humanPlayer.addOnMakeMoveListener(onMakeMoveListener);
    }

    private void move(){
        Position position = findMove();
        board.triggerSquareAt(position, PLAYER_MARK_ENUM);
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
        humanPlayer.removeListener(onMakeMoveListener);
    }

}

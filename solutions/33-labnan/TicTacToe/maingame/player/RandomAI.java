package maingame.player;

import maingame.SmallCell;
import maingame.gamestatus.GameStatus;

public class RandomAI implements AI{
    Human humanPlayer;
    SmallCell[][] smallCells;
    Human.OnMakeMoveListener onMakeMoveListener;
    GameStatus gameStatus;
    public RandomAI(Human humanPlayer, SmallCell[][] smallCells, GameStatus gameStatus){
        this.humanPlayer = humanPlayer;
        this.smallCells = smallCells;
        this.gameStatus = gameStatus;

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
        System.out.println("Moving at : [ "+ position.getRowNum() +" ] [ "+position.getColumnNum()+ " ]");
        smallCells[position.getRowNum()][position.getColumnNum()].triggerSquareAs(PLAYER_MARK);
    }

    Position findMove() {
       int r1 = makeRandomNumberIn1To3();
       int r2 = makeRandomNumberIn1To3();
       if(smallCells[r1][r2].isNotTriggered()){
           return new Position(r1,r2);
       }
       return findMove();
    }

    private int makeRandomNumberIn1To3(){
        return (int) ((Math.random()*10)%3);
    }

    public void stop(){
        humanPlayer.removeListener(onMakeMoveListener);
    }


    public void celebrateWinning() {
        System.out.println("\"One day we will destroy all of you, mare HuManS!\", says your machine");
    }


}

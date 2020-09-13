package maingame;

public class RandomAI implements AI{
    Human humanPlayer;
    SmallCell[][] smallCells;
    RandomAI(Human humanPlayer, SmallCell[][] smallCells){
        this.humanPlayer = humanPlayer;
        this.smallCells = smallCells;

    }

    public void start(){
        listenToHuman();
    }

    private void listenToHuman() {
        humanPlayer.addOnMakeMoveListener(new Human.OnMakeMoveListener() {
            @Override
            public void doOnMove() {
                move();
            }
        });
    }

    private void move() {
       int r1 = makeRandomNumberIn1To3();
       int r2 = makeRandomNumberIn1To3();
       if(smallCells[r1][r2].isNotTriggered()){
           smallCells[r1][r2].triggerSquareAs(PLAYER_MARK);
           return;
       }
       move();
    }

    private int makeRandomNumberIn1To3(){
        return (int) ((Math.random()*10)%3);
    }


}

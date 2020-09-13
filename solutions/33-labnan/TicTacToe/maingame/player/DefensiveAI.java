package maingame.player;

import maingame.PlayerMark;
import maingame.SmallCell;
import maingame.gamestatus.CheckerLine;
import maingame.gamestatus.GameStatus;

public class DefensiveAI implements AI {
    RandomAI randomAI;
    Position position;
    Human humanPlayer;
    SmallCell[][] smallCells;
    GameStatus gameStatus;
    Human.OnMakeMoveListener onMakeMoveListener;
    public DefensiveAI(Human humanPlayer, SmallCell[][] smallCells, GameStatus gameStatus){
        randomAI = new RandomAI(humanPlayer,smallCells,gameStatus);
        this.humanPlayer = humanPlayer;
        this.gameStatus = gameStatus;
        this.smallCells = smallCells;
    }

    private void listenToHuman() {
        onMakeMoveListener = () -> {
            if(gameStatus.getTurnCount()!=9)
                move();
        };
        humanPlayer.addOnMakeMoveListener(onMakeMoveListener);
    }

    private void move(){

        position = findMove();
        smallCells[position.getRowNum()][position.getColumnNum()].triggerSquareAs(PLAYER_MARK);
    }

    private Position findMove() {
        CheckerLine checkerLine;
        for(int i = 0; i<3; i++){
            checkerLine = gameStatus.getRowChecker()[i];
            if(checkerLine.getPlayerMark()==PlayerMark.HUMAN)
            if(checkerLine.getCount()==2&&checkerLine.isWinnable()){
               return winAtRow(i);
            }
        }

        for(int i = 0; i<3; i++){
            checkerLine = gameStatus.getColumnChecker()[i];
            if(checkerLine.getPlayerMark()==PlayerMark.HUMAN)
            if(checkerLine.getCount()==2&&checkerLine.isWinnable()){
                return winAtColumn(i);
            }
        }

        checkerLine = gameStatus.getDiagonalChecker();
        if(checkerLine.getPlayerMark()==PlayerMark.HUMAN)
        if(checkerLine.isWinnable() && checkerLine.getCount()==2){
            return winAtDiagonal();
        }

        checkerLine = gameStatus.getAntiDiagonalChecker();
        if(checkerLine.getPlayerMark()==PlayerMark.HUMAN)
        if(checkerLine.isWinnable() && checkerLine.getCount()==2){
            return winAtAntiDiagonal();
        }
    return randomAI.findMove();

    }

    /*
    (0,2)   (1,1)   (2,0)
     c=2
              (2-0)
     m =     -------
              (0-2)
    m =  -1
    y = -x + 2
    y = 2 - x
     */

    private Position winAtAntiDiagonal() {
        for(int i = 0; i<3; i++){
            if(smallCells[i][2-i].isNotTriggered()){
                return new Position(i,2-i);
            }
        }
        return null;
    }

    private Position winAtDiagonal() {
        for(int i = 0; i<3; i++){
            if(smallCells[i][i].isNotTriggered()){
                return new Position(i,i);
            }
        }
        return null;

    }


    private Position winAtRow(int columnNum) {
        for(int rowNum = 0; rowNum<3; rowNum++){
            if(smallCells[rowNum][columnNum].isNotTriggered()){
                return new Position(rowNum,columnNum);
            }
        }
        return null;

    }

    private Position winAtColumn(int rowNum) {
        for(int columnNum = 0; columnNum<3; columnNum++){
            if(smallCells[rowNum][columnNum].isNotTriggered()){
                return new Position(rowNum,columnNum);
            }
        }
        return null;

    }


    @Override
    public void start() {
            listenToHuman();
    }

}

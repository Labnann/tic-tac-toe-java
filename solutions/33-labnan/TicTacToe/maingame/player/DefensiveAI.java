package maingame.player;

import maingame.Board.Board;
import maingame.PlayerMarkEnum;
import maingame.Position;
import maingame.gamestatus.CheckerLine;
import maingame.gamestatus.GameStatus;

public class DefensiveAI implements AI {
    RandomAI randomAI;
    Position position;
    Human humanPlayer;
    GameStatus gameStatus;
    Human.OnMakeMoveListener onMakeMoveListener;
    Board board;
    public DefensiveAI(Human humanPlayer, Board board, GameStatus gameStatus){
        randomAI = new RandomAI(humanPlayer,board,gameStatus);
        this.humanPlayer = humanPlayer;
        this.gameStatus = gameStatus;
        this.board = board;
    }

    private void listenToHuman() {
        onMakeMoveListener = () -> {
            if(gameStatus.getTurnCount()!=9)
                move();
        };
        humanPlayer.addOnMakeMoveListener(onMakeMoveListener);
    }

    private void move(){
        findMove();
        board.triggerSquareAt(position, PLAYER_MARK_ENUM);
    }

    private void findMove() {
        position = null;
        checkRows();
        checkColumns();
        checkDiagonal();
        checkAntiDiagonal();
        if(position==null)
            position = randomAI.findMove();
    }

    private void checkAntiDiagonal() {
        CheckerLine checkerLine;
        checkerLine = gameStatus.getAntiDiagonalChecker();
        if(checkerLineHasWinner(checkerLine)){
             winAtAntiDiagonal();
        }
    }

    private void checkDiagonal() {
        CheckerLine checkerLine;
        checkerLine = gameStatus.getDiagonalChecker();
        if(checkerLineHasWinner(checkerLine)){
            winAtDiagonal();
        }
    }

    private void checkColumns() {
        CheckerLine checkerLine;
        for(int i = 0; i<3; i++){
            checkerLine = gameStatus.getColumnChecker()[i];
            if(checkerLineHasWinner(checkerLine)){
                 winAtColumn(i);
            }
        }
    }

    private void checkRows() {
        CheckerLine checkerLine;
        for(int i = 0; i<3; i++){
            checkerLine = gameStatus.getRowChecker()[i];
            if(checkerLineHasWinner(checkerLine)){
                winAtRow(i);
            }}
    }

    private boolean checkerLineHasWinner(CheckerLine checkerLine) {
        return checkerLine.getPlayerMarkEnum() == PlayerMarkEnum.HUMAN && checkerLine.getCount() == 2 && checkerLine.isWinnable();
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

    private void winAtAntiDiagonal() {
        for(int i = 0; i<3; i++){
            findUntriggeredPosition(i, 2-i);
        }
    }

    private void winAtDiagonal() {
        for(int i = 0; i<3; i++){
            findUntriggeredPosition(i, i);
        }
    }


    private void winAtRow(int columnNum) {
        for(int rowNum = 0; rowNum<3; rowNum++){
            findUntriggeredPosition(rowNum, columnNum);
        }
    }

    private void winAtColumn(int rowNum) {
        for(int columnNum = 0; columnNum<3; columnNum++){
            findUntriggeredPosition(rowNum, columnNum);
        }

    }

    private void findUntriggeredPosition(int rowNum, int columnNum) {
        Position checkingPosition = new Position(rowNum,columnNum);
        if (board.getMarkAtPosition(checkingPosition)==null) {
            position = checkingPosition;
        }
    }


    @Override
    public void start() {
            listenToHuman();
    }

    @Override
    public void stop(){
        humanPlayer.removeListener(onMakeMoveListener);
    }

}

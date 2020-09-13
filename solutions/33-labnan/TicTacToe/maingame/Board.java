package maingame;

import java.util.ArrayList;


public class Board {
    private PlayerMark currentTurnType = PlayerMark.HUMAN;
    private SmallCell[][] smallCells = new SmallCell[3][3];

    ArrayList<BoardListener>  boardChangeListeners = new ArrayList<>();

    public Board(){
        initializeSmallCells();
    }

    private void initializeSmallCells() {
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                smallCells[i][j] = new SmallCell();
                smallCells[i][j].addOnSmallCellTrigger(this::doOnChange);
            }
        }
    }
    public void addOnChangeListener(BoardListener boardChangeListener) {
        boardChangeListeners.add(boardChangeListener);
    }


    public void setStartingTurn(PlayerMark startingTurnType) {
        this.currentTurnType = startingTurnType;
    }



    public void triggerSquare(SmallCell smallCell) {
        if (smallCell.isNotTriggered()) {
            smallCell.triggerSquareAs(currentTurnType);
            changeTurn();

        }
    }

    private void doOnChange() {
        for(BoardListener boardChangeListener: boardChangeListeners){
        if (boardChangeListener != null) {
            boardChangeListener.performOnChange();
            continue;
        }
        return;
    }
    }

    public SmallCell[][] getSmallCells() {
        return smallCells;
    }



    public interface BoardListener {
        void performOnChange();
    }

    private void changeTurn() {
        if (currentTurnType == PlayerMark.HUMAN)
            currentTurnType = PlayerMark.AI;
        else currentTurnType = PlayerMark.HUMAN;
    }

}






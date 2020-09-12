package maingame;

import javafx.scene.layout.Pane;
import theme.Theme;

import java.util.ArrayList;


public class Board {
    private SmallCell.Type currentTurnType = SmallCell.Type.CROSS;
    private SmallCell[][] smallCells = new SmallCell[3][3];

    ArrayList<BoardListener>  boardChangeListeners = new ArrayList<>();

    Board(){
        initializeSmallCells();
    }

    private void initializeSmallCells() {
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                smallCells[i][j] = new SmallCell();
            }
        }
    }
    public void addOnChangeListener(BoardListener boardChangeListener) {
        boardChangeListeners.add(boardChangeListener);
    }


    public void setStartingTurn(SmallCell.Type startingTurnType) {
        this.currentTurnType = startingTurnType;
    }



    public void triggerSquare(SmallCell smallCell) {
        if (smallCell.isNotTriggered()) {
            smallCell.triggerSquareAs(currentTurnType);
            changeTurn();
            doOnChange();
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



    interface BoardListener {
        void performOnChange();
    }

    private void changeTurn() {
        if (currentTurnType == SmallCell.Type.CROSS)
            currentTurnType = SmallCell.Type.ZERO;
        else currentTurnType = SmallCell.Type.CROSS;
    }

}






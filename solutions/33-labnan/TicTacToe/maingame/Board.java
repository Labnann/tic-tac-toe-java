package maingame;

import javafx.scene.layout.Pane;
import theme.Theme;


public class Board {
    private SmallCell.Type currentTurnType = SmallCell.Type.CROSS;
    private SmallCell[][] smallCells = new SmallCell[3][3];
    private BoardListener boardChangeListener;

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
    public void onChange(BoardListener boardChangeListener) {
        this.boardChangeListener = boardChangeListener;
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
        if (boardChangeListener != null) {
            boardChangeListener.performOnChange();
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






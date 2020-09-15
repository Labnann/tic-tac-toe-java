package maingame;

import java.util.ArrayList;


public class Board {
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

    public PlayerMark getMarkAtPosition(Position position){
        return smallCells[position.getRowNum()][position.getColumnNum()].getTurnType();
    }




    public void triggerSquare(Position position, PlayerMark playerMark) {
        SmallCell smallCell = smallCells[position.getRowNum()][position.getColumnNum()];
        if (smallCell.isNotTriggered()) {
            smallCell.triggerSquareAs(playerMark);
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

}






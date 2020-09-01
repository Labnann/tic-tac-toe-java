package maingame;

import javafx.scene.layout.Pane;
import theme.Theme;


public class BoardUI {

    Theme theme;// = new ForestTheme();
    private Pane boardPane = new Pane();
    private SmallCellUI[][] smallCellUIs;
    private SmallCell.Type currentTurnType = SmallCell.Type.CROSS;
    private SmallCell[][] smallCells = new SmallCell[3][3];
    private BoardListener boardChangeListener;



    BoardUI() {
        initializeSmallCells();
        createBoard();
    }

    private void initializeSmallCells() {
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                smallCells[i][j] = new SmallCell();
            }
        }
    }

    private void adjustWithTheme() {
        theme.setBoardPane(boardPane);
        for (SmallCellUI[] i : smallCellUIs) {
            for (SmallCellUI j : i) {
                j.setTheme(theme);
            }
        }
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
        adjustWithTheme();

    }

    public void setStartingTurn(SmallCell.Type startingTurnType) {
        this.currentTurnType = startingTurnType;
    }

    public void onChange(BoardListener boardChangeListener) {
        this.boardChangeListener = boardChangeListener;
    }

    public Pane getBoardPane() {
        return boardPane;
    }

    private void createBoard() {
        smallCellUIs = new SmallCellUI[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                smallCellUIs[i][j] = createBoardSquare(i, j);
            }
        boardPane.relocate(70, 70);
    }

    private SmallCellUI createBoardSquare(int i, int j) {
        SmallCellUI smallCellUI = new SmallCellUI(i, j,smallCells[i][j]);
        boardPane.getChildren().add(smallCellUI.getSquarePane());
        smallCellUI.getSquarePane().setOnMouseClicked(event -> triggerSquare(smallCells[i][j]));
        return smallCellUI;
    }

    public SmallCell[][] getSmallCells() {
        return smallCells;
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


    private void changeTurn() {
        if (currentTurnType == SmallCell.Type.CROSS)
            currentTurnType = SmallCell.Type.ZERO;
        else currentTurnType = SmallCell.Type.CROSS;
    }

    interface BoardListener {
        void performOnChange();
    }


}






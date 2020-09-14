package maingame;

import javafx.event.EventType;
import javafx.scene.layout.Pane;
import maingame.player.Human;
import maingame.theme.Theme;

import java.awt.event.MouseEvent;

public class BoardUI {

Theme theme;
private Pane boardPane;
private SmallCellUI[][] smallCellUIs;
private SmallCell[][] smallCells;
private Board board;
private Human player;



BoardUI( Board board, Theme theme, Human player) {
    this.board=board;
    this.boardPane = new Pane();
    smallCells = board.getSmallCells();
    this.smallCellUIs = createBoardUI();

    this.theme = theme;
    this.player = player;

}

    public void setBoard(Board board) {
        this.board = board;
        adjustWithTheme();
    }

    private void adjustWithTheme() {
    theme.setBoardPane(boardPane);
    for (SmallCellUI[] i : smallCellUIs) {
        for (SmallCellUI j : i) {
            j.setTheme(theme);
        }
    }
}


    private SmallCellUI[][] createBoardUI() {
        SmallCellUI[][] smallCellUIs = new SmallCellUI[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                smallCellUIs[i][j] = createBoardSquare(i, j);
            }
        boardPane.relocate(70, 70);
        return smallCellUIs;
    }


    private SmallCellUI createBoardSquare(int i, int j) {
        SmallCellUI smallCellUI = new SmallCellUI(i, j,smallCells[i][j]);
        boardPane.getChildren().add(smallCellUI.getSquarePane());
        smallCellUI.getSquarePane().setOnMouseClicked(event -> player.placeMark(i,j));
        return smallCellUI;
    }



public void setTheme(Theme theme) {
    this.theme = theme;
    adjustWithTheme();
}




public Pane getBoardPane() {
    return boardPane;
}





}

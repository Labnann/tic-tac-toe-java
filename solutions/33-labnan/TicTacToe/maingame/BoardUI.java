package maingame;

import javafx.scene.layout.Pane;
import theme.Theme;

public class BoardUI {

Theme theme;
private Pane boardPane;
private SmallCellUI[][] smallCellUIs;
private SmallCell[][] smallCells;
private Board board;



BoardUI(Board board, SmallCellUI[][] smallCellUIS, Pane boardPane, Theme theme) {
    smallCells = board.getSmallCells();
    this.board=board;
    this.smallCellUIs = smallCellUIS;
    this.boardPane = boardPane;
    this.theme = theme;
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

public void setTheme(Theme theme) {
    this.theme = theme;
    adjustWithTheme();
}




public Pane getBoardPane() {
    return boardPane;
}





}

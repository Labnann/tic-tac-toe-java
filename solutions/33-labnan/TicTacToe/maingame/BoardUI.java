package maingame;

import javafx.scene.layout.Pane;
import theme.Theme;

public class BoardUI {

Theme theme;
private Pane boardPane = new Pane();
private SmallCellUI[][] smallCellUIs;
private SmallCell[][] smallCells;
private Board board;



BoardUI(Board board) {
    smallCells = board.getSmallCells();
    this.board=board;
    createBoardUI();
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

private void createBoardUI() {
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
    smallCellUI.getSquarePane().setOnMouseClicked(event -> board.triggerSquare(smallCells[i][j]));
    return smallCellUI;
}

}

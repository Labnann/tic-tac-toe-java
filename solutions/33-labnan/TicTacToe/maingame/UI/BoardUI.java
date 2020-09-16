package maingame.UI;

import javafx.scene.layout.Pane;
import maingame.Board.Board;
import maingame.Position;
import maingame.player.InterfaceUserPlayer;
import maingame.theme.Theme;

public class BoardUI {

    Theme theme;
    private Pane boardPane;
    private SmallCellUI[][] smallCellUIs;
    private Board board;
    private InterfaceUserPlayer player;


    public BoardUI(Board board, Theme theme, InterfaceUserPlayer player) {
        this.player = player;
        this.board = board;
        this.boardPane = new Pane();
        this.smallCellUIs = createBoardUI();
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


    private SmallCellUI[][] createBoardUI() {
        SmallCellUI[][] smallCellUIs = new SmallCellUI[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                smallCellUIs[i][j] = createBoardSquare(new Position(i,j));
            }
        boardPane.relocate(70, 70);
        return smallCellUIs;
    }


    private SmallCellUI createBoardSquare(Position position) {
        SmallCellUI smallCellUI = new SmallCellUI(position, board.getSmallCellAt(position));
        boardPane.getChildren().add(smallCellUI.getSquarePane());
        if (player != null) {
            smallCellUI.getSquarePane().setOnMouseClicked(event -> player.placeMark(position));
        }
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
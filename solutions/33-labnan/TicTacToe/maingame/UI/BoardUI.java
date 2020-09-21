package maingame.UI;

import javafx.scene.layout.Pane;
import maingame.Board.Board;
import maingame.Position;
import maingame.ThemeSetter;
import maingame.player.InterfaceUserPlayer;
import maingame.theme.Theme;

public class BoardUI implements Themeable {

    Theme theme;
    private Pane boardPane;
    private Board board;
    private InterfaceUserPlayer player;
    ThemeSetter themeSetter;


    public BoardUI(Board board, InterfaceUserPlayer player, ThemeSetter themeSetter) {
        this.themeSetter = themeSetter;
        themeSetter.add(this);
        this.theme = themeSetter.getTheme();
        this.player = player;
        this.board = board;
        this.boardPane = new Pane();
        createBoardUI();

    }


    public void setBoard(Board board) {
        this.board = board;
        adjustWithTheme();
    }

    private void adjustWithTheme() {
    theme.setBoardPane(boardPane);
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

        themeSetter.add(smallCellUI);
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

package maingame;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class Board {
    private Pane boardPane = new Pane();
    private BoardSquare[][] boardSquares;
    private LogicBasedBox.Type currentTurnType = LogicBasedBox.Type.CROSS;
    private BoardListener boardChangeListener;


    Board() {
        createBoard();
        boardPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
    }

    public void setStartingTurn(LogicBasedBox.Type startingTurnType) {
        this.currentTurnType = startingTurnType;
    }

    public void onChange(BoardListener boardChangeListener) {
        this.boardChangeListener = boardChangeListener;
    }

    public Pane getBoardPane() {
        return boardPane;
    }

    public BoardSquare[][] getBoardSquares() {
        return this.boardSquares;
    }

    private void createBoard() {
        boardSquares = new BoardSquare[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                boardSquares[i][j] = createBoardSquare(i, j);
            }
        boardPane.relocate(70, 70);
    }

    private BoardSquare createBoardSquare(int i, int j) {
        BoardSquare boardSquare = new BoardSquare(i, j);
        boardPane.getChildren().add(boardSquare.getSquarePane());
        boardSquare.getSquarePane().setOnMouseClicked(event -> triggerSquare(boardSquare));
        return boardSquare;
    }

    public void triggerSquare(BoardSquare boardSquare) {
        if (boardSquare.isNotTriggered()) {
            boardSquare.triggerSquareAs(currentTurnType);
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
        if (currentTurnType == LogicBasedBox.Type.CROSS)
            currentTurnType = LogicBasedBox.Type.ZERO;
        else currentTurnType = LogicBasedBox.Type.CROSS;
    }

    interface BoardListener {
        void performOnChange();
    }
}



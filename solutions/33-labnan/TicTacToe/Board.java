import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

interface BoardSquareListener {
    void performOnChange();
}

public class Board {
    private Pane boardPane = new Pane();
    private BoardSquare[][] boardSquares;
    private BoardSquare.PlaceValue currentTurn;
    private BoardSquareListener boardChangeListener;

    Board(BoardSquare.PlaceValue startTurn) {
        createBoard();
        boardPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        this.currentTurn = startTurn;

    }

    public void setBoardChangeListener(BoardSquareListener boardChangeListener) {
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
        boardSquare.getSquarePane().setOnMouseClicked(event -> {
            boardSquare.markAs(currentTurn);
            changeTurn();
            doOnChange();
        });
        return boardSquare;
    }

    void doOnChange() {
        if (boardChangeListener != null) {
            boardChangeListener.performOnChange();
        }
    }


    void changeTurn() {
        if (currentTurn == BoardSquare.PlaceValue.CROSS)
            currentTurn = BoardSquare.PlaceValue.ZERO;
        else currentTurn = BoardSquare.PlaceValue.CROSS;
    }


}

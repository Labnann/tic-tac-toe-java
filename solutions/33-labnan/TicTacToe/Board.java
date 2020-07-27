import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Board {
    private Pane boardPane = new Pane();
    private BoardSquare[][] boardSquares;

    Board() {
        createBoard();

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

    }

    private BoardSquare createBoardSquare(int i, int j) {
        BoardSquare boardSquare = new BoardSquare(i, j);
        if ((i + j) % 2 == 0) {
            boardSquare.getRectangle().setFill(Color.BLUE);
        } else boardSquare.getRectangle().setFill(Color.VIOLET);
        boardPane.getChildren().add(boardSquare.getRectangle());
        return boardSquare;
    }
}


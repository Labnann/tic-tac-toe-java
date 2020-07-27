import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameLauncher {
    private Stage gameRootStage;
    Pane rootPane = new Pane();
    BoardSquare[][] boardSquares;
    private Board board;
    private Scene rootScene;


    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;
    }

    void startGame() {
        createUI();
        boardSquares = board.getBoardSquares();
        board.setBoardChangeListener(new BoardSquareListener() {
            @Override
            public void performOnChange() {
                calculateWin();
            }
        });
        gameRootStage.show();
    }

    private boolean calculateWin() {
        return false;
    }


    private void createUI() {
        rootScene = new Scene(rootPane, 500, 500);
        board = new Board(BoardSquare.PlaceValue.CROSS);
        rootPane.getChildren().add(board.getBoardPane());
        gameRootStage.setScene(this.rootScene);
    }


}




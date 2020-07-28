import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameLauncher {
    private Stage gameRootStage;
    Pane rootPane = new Pane();
    private Board board;
    WinChecker winChecker = new WinChecker(board);


    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;
    }

    void startGame() {
        createUI();
        //winChecker.start();
        board.setBoardChangeListener(new BoardSquareListener() {
            @Override
            public void performOnChange() {
                System.out.println("Check");
            }
        });
        gameRootStage.show();
    }




    private void createUI() {
        Scene rootScene = new Scene(rootPane, 500, 500);
        board = new Board(BoardSquare.PlaceValue.CROSS);
        rootPane.getChildren().add(board.getBoardPane());
        gameRootStage.setScene(rootScene);
    }


}




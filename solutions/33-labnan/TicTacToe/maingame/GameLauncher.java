package maingame;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameLauncher {
    private Stage gameRootStage;
    Pane rootPane = new Pane();
    private Board board;
    WinChecker winChecker;


    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;
    }

    void startGame() {
        UICreator uiCreator = new UICreator(gameRootStage);
        uiCreator.createUI();
        board = uiCreator.getBoard();
        new WinChecker(board).startChecking();
        gameRootStage.show();
    }
    

}

class UICreator {
    Board board = new Board();
    Pane rootPane = new Pane();
    private Stage gameRootStage;


    UICreator(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;

    }

    public Board getBoard() {
        return board;
    }

    public void createUI() {
        Scene rootScene = new Scene(rootPane, 500, 500);
        rootPane.getChildren().add(board.getBoardPane());
        gameRootStage.setScene(rootScene);
    }
}




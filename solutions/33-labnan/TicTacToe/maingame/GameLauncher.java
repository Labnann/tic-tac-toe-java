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
        createUI();
        new WinChecker(board).startChecking();
        gameRootStage.show();
    }


    private void createUI() {
        Scene rootScene = new Scene(rootPane, 500, 500);
        board = new Board();
        rootPane.getChildren().add(board.getBoardPane());
        gameRootStage.setScene(rootScene);
    }


}




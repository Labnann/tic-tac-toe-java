package maingame;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
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
    }


}

class UICreator {
    Board board = new Board();
    Pane rootPane = new Pane();

    Line line = new Line();

    private Stage gameRootStage;


    UICreator(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;

    }

    public Board getBoard() {
        return board;
    }

    public void createUI() {
        Scene rootScene = new Scene(rootPane, 700, 500);
        createLine();
        rootPane.getChildren().addAll(board.getBoardPane(), line);
        gameRootStage.setScene(rootScene);
        gameRootStage.show();
    }

    void createLine() {
        line.setStartX(430);
        line.setStartY(30);
        line.setEndX(430);
        line.setEndY(430);
        line.autosize();
        line.setStrokeWidth(7);
        line.setFill(Color.BLACK);
    }

}




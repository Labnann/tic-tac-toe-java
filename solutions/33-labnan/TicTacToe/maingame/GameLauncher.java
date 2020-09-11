package maingame;

import javafx.stage.Stage;


public class GameLauncher {
    private Stage gameRootStage;
    UICreator uiCreator;



    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;
    }

    void startGame() {

        Board board = new Board();
        BoardUI boardUI = new BoardUI(board);
        uiCreator = new UICreator(gameRootStage,boardUI);
        uiCreator.createUI();
        addButtonFunctions();
        new WinChecker(board).startChecking();
    }

    void addButtonFunctions() {
        uiCreator.getStartButton().setOnMouseClicked(event -> startGame());
    }

}




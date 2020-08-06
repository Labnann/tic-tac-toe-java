package maingame;

import javafx.stage.Stage;


public class GameLauncher {
    private Stage gameRootStage;
    UICreator uiCreator;



    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;
    }

    void startGame() {
        uiCreator = new UICreator(gameRootStage);
        uiCreator.createUI();
        addButtonFunctions();
        Board board = uiCreator.getBoard();
        new WinChecker(board).startChecking();
    }

    void addButtonFunctions() {

        uiCreator.getStartButton().setOnMouseClicked(event -> startGame());
    }

}




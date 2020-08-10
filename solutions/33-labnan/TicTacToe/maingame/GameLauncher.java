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
        BoardUI boardUi = new BoardUI();
        uiCreator.setBoardUi(boardUi);
        uiCreator.createUI();
        addButtonFunctions();
        new WinChecker(boardUi).startChecking();
    }

    void addButtonFunctions() {
        uiCreator.getStartButton().setOnMouseClicked(event -> startGame());
    }

}




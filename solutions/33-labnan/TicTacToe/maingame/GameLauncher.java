package maingame;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class GameLauncher {
    private Stage gameRootStage;
    Pane rootPane = new Pane();
    private Board board;
    WinChecker winChecker;
    UICreator uiCreator;



    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;
    }

    void startGame() {
        uiCreator = new UICreator(gameRootStage);
        uiCreator.createUI();
        addButtonFunctions();
        board = uiCreator.getBoard();
        new WinChecker(board).startChecking();
    }

    void addButtonFunctions() {

        uiCreator.getStartButton().setOnMouseClicked(event -> startGame());
        uiCreator.getChangeThemeButton().setOnMouseClicked(event -> changeTheme());


    }

    private void changeTheme() {

    }

}




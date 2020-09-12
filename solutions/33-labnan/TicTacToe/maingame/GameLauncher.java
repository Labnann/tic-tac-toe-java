package maingame;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import theme.ClassicTheme;
import theme.Theme;


public class GameLauncher {
    private Stage gameRootStage;
    UICreator uiCreator;
    Pane boardPane  = new Pane();

    Theme theme = new ClassicTheme();

    Board board;
    BoardUI boardUI;


    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;

    }

    void startGame() {

        board = new Board();
        boardUI = new BoardUI(board,theme);
        if(uiCreator!=null)
        theme = uiCreator.getTheme();
        uiCreator = new UICreator(gameRootStage,boardUI,theme);
        uiCreator.createUI();
        addButtonFunctions();
        GameStatus gameStatus = new GameStatus(board.getSmallCells());
        AdvancedWinChecker advancedWinChecker = new AdvancedWinChecker(gameStatus);
    }





    void addButtonFunctions() {
        uiCreator.getStartButton().setOnMouseClicked(event -> startGame());
    }

}




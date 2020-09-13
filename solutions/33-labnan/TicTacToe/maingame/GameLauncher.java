package maingame;

import javafx.stage.Stage;
import maingame.gamestatus.GamePlayStatus;
import maingame.gamestatus.GameStatus;
import maingame.winchecker.WinChecker;
import theme.ClassicTheme;
import theme.Theme;
import maingame.winchecker.AdvancedWinChecker;


public class GameLauncher {
    private Stage gameRootStage;
    UICreator uiCreator;


    Theme theme = new ClassicTheme();

    Board board;
    BoardUI boardUI;


    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;

    }

    void startGame() {

        board = new Board();
        GameStatus gameStatus = new GamePlayStatus(board.getSmallCells());
        AdvancedWinChecker advancedWinChecker = new AdvancedWinChecker(gameStatus);
        HumanPlayer humanPlayer = new HumanPlayer(board.getSmallCells());
        AI ai = new RandomAI(humanPlayer,board.getSmallCells(),gameStatus);
        ai.start();
        boardUI = new BoardUI(board,theme,humanPlayer);
        if(uiCreator!=null)
        theme = uiCreator.getTheme();
        uiCreator = new UICreator(gameRootStage,boardUI,theme);
        uiCreator.createUI();
        addButtonFunctions();



    }





    void addButtonFunctions() {
        uiCreator.getStartButton().setOnMouseClicked(event -> startGame());
    }

}




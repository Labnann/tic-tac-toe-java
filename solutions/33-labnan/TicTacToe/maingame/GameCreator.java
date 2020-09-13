package maingame;

import javafx.stage.Stage;
import maingame.gamestatus.GamePlayStatus;
import maingame.gamestatus.GameStatus;
import maingame.player.*;
import theme.ClassicTheme;
import theme.Theme;
import maingame.winchecker.AdvancedWinChecker;


public class GameCreator {
    private Stage gameRootStage;
    UICreator uiCreator;
    Theme theme = new ClassicTheme();
    Board board;
    BoardUI boardUI;
    Human humanPlayer;
    GameStatus gameStatus;
    AI ai;
    GameStarter gameStarter;


    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;

    }

    void createGame() {
        gameStarter = new GameStarter();
        gameStarter.start();
        configureUI();
    }

    private void configureUI() {
        boardUI = new BoardUI(gameStarter.getBoard(),theme,gameStarter.getHumanPlayer());
        if(uiCreator!=null)
        theme = uiCreator.getTheme();
        uiCreator = new UICreator(gameRootStage,boardUI,theme);
        uiCreator.createUI();
        addButtonFunctions();
    }




    void addButtonFunctions() {
        uiCreator.getStartButton().setOnMouseClicked(event -> createGame());
    }

}

class GameStarter{
    AI ai;
    private Human humanPlayer;
    private Board board;

    GameStarter(){
        start();
    }



    public Human getHumanPlayer() {
        return humanPlayer;
    }




    public Board getBoard() {
        return board;
    }

    public void setAi(AI ai) {
        this.ai = ai;
    }

    void start() {
        board = new Board();
        GameStatus gameStatus = new GamePlayStatus(board.getSmallCells());
        humanPlayer = new HumanPlayer(board.getSmallCells());
        AdvancedWinChecker advancedWinChecker = new AdvancedWinChecker(gameStatus);
        advancedWinChecker.startChecking();
        ai = new DefensiveAI(humanPlayer,board.getSmallCells(),gameStatus);
        ai.start();
    }


}




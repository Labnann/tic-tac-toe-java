package maingame;

import javafx.stage.Stage;
import maingame.UI.BoardUI;
import maingame.UI.UICreator;
import maingame.theme.ClassicTheme;
import maingame.theme.Theme;


public class GameCreator {
    private Stage gameRootStage;
    UICreator uiCreator;
    Theme theme = new ClassicTheme();
    BoardUI boardUI;
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
        boardUI = new BoardUI(gameStarter.getBoard(),theme,gameStarter.getListenablePlayerPlayer());
        if(uiCreator!=null)
        theme = uiCreator.getTheme();
        uiCreator = new UICreator(gameRootStage,boardUI,theme,gameStarter);
        uiCreator.createUI();
        addButtonFunctions();
    }




    void addButtonFunctions() {
        uiCreator.getRandomAIStartButton().setOnMouseClicked(event -> createGame());
        uiCreator.getDefensiveAIStartButton().setOnMouseClicked(event -> {
            createGame();
            gameStarter.useDefensiveAI();
        });
    }

}

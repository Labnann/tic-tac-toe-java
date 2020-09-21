package maingame;

import javafx.stage.Stage;
import maingame.UI.BoardUI;
import maingame.UI.UICreator;
import maingame.theme.Theme;


public class GameCreator {
    private Stage gameRootStage;
    private UICreator uiCreator;
    ThemeSetter themeSetter = new ThemeSetter();
    private Theme theme = themeSetter.getTheme();
    private BoardUI boardUI;
    private GameStarter gameStarter;


    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;

    }

    void createGame() {
        gameStarter = new GameStarter();
        gameStarter.start();
        configureUI();
    }

    private void configureUI() {
        boardUI = new BoardUI(gameStarter.getBoard(), theme, gameStarter.getInterfaceUser(), themeSetter);
        if (uiCreator != null)
            theme = themeSetter.getTheme();
        uiCreator = new UICreator(gameRootStage, boardUI, gameStarter, themeSetter);
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

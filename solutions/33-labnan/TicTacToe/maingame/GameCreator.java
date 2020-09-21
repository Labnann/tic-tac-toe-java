package maingame;

import javafx.stage.Stage;
import maingame.UI.BoardUI;
import maingame.UI.UICreator;


public class GameCreator {
    private Stage gameRootStage;
    private UICreator uiCreator;
    ThemeSetter themeSetter = new ThemeSetter();
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
        BoardUI boardUI = new BoardUI(gameStarter.getBoard(), gameStarter.getInterfaceUser(), themeSetter);
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

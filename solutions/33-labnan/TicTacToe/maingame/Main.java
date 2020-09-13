package maingame;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GameCreator gameCreator = new GameCreator();
        gameCreator.setGameRootStage(primaryStage);
        gameCreator.createGame();
    }
}


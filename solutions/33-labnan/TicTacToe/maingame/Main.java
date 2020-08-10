package maingame;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GameLauncher gameLauncher = new GameLauncher();
        gameLauncher.setGameRootStage(primaryStage);
        gameLauncher.startGame();
    }
}

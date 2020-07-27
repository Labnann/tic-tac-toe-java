import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameLauncher {
    private Stage gameRootStage;
    Pane rootPane = new Pane();
    private Board board;
    private Scene rootScene;


    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;
    }

    void startGame() {
        createUI();
        gameRootStage.show();
    }

    private void createUI() {
        rootScene = new Scene(rootPane, 500, 500);
        
        gameRootStage.setScene(this.rootScene);
    }


}


import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameLauncher {
    private Stage gameRootStage;
    Pane rootPane = new Pane();
    private Board board;
    private Scene rootScene;
  //  private Group rootGroup;


    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;
    }

    void startGame() {
        createUI();
        gameRootStage.show();
    }

    private void createUI() {
        rootScene = new Scene(rootPane, 500, 500);
        board = new Board();
        rootPane.getChildren().add(board.getBoardPane());
        gameRootStage.setScene(this.rootScene);
    }


}


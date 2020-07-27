import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class GameLauncher{
    private Stage gameRootStage;

    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;
    }
    void startGame(){
        gameRootStage.setScene(new Scene(new TextArea("Hello World")));
        gameRootStage.show();
    }
}

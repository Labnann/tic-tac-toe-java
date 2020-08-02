package maingame;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GameLauncher {
    private Stage gameRootStage;
    Pane rootPane = new Pane();
    private Board board;
    WinChecker winChecker;


    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;
    }

    void startGame() {
        UICreator uiCreator = new UICreator(gameRootStage);
        uiCreator.createUI();
        board = uiCreator.getBoard();
        new WinChecker(board).startChecking();
    }


}

class UICreator {
    Board board = new Board();
    Pane rootPane = new Pane();

    Line line = new Line();

    private Stage gameRootStage;


    UICreator(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;

    }

    public Board getBoard() {
        return board;
    }

    public void createUI() {
        Scene rootScene = new Scene(rootPane, 700, 500);
        createLine();
        addButtons();
        rootPane.getChildren().addAll(board.getBoardPane(), line);
        gameRootStage.setScene(rootScene);
        gameRootStage.show();
    }

    void addButtons() {
        Pane startButton = createButton("Start");
        startButton.relocate(500, 200);
        rootPane.getChildren().addAll(startButton);

    }

    void createLine() {
        line.setStartX(430);
        line.setStartY(30);
        line.setEndX(430);
        line.setEndY(430);
        line.setStrokeWidth(7);
        line.setFill(Color.BLACK);
    }

    Pane createButton(String buttonText) {
        return new Button("Start").getPane();
    }

}

class Button {
    Pane pane = new Pane();
    Text text = new Text();
    Rectangle rectangle = new Rectangle(50, 30);

    Button(String buttonText) {
        text.setFont(new Font("Arial", 15));
        text.setText(buttonText);
        text.setFill(Color.WHITE);
        pane.getChildren().addAll(rectangle, text);
    }

    public Pane getPane() {
        return pane;
    }
}




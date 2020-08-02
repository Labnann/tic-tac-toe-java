package maingame;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class GameLauncher {
    private Stage gameRootStage;
    Pane rootPane = new Pane();
    private Board board;
    WinChecker winChecker;
    UICreator uiCreator;


    public void setGameRootStage(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;
    }

    void startGame() {
        uiCreator = new UICreator(gameRootStage);
        uiCreator.createUI();
        addButtonFunctions();
        board = uiCreator.getBoard();
        new WinChecker(board).startChecking();
    }

    void addButtonFunctions() {

        uiCreator.getStartButton().setOnMouseClicked(event -> startGame());
    }


}

class UICreator {
    Board board = new Board();
    Pane rootPane = new Pane();
    Pane startButton;
    Pane buttonPane = new Pane();
    Pane changeThemeButton;

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
        buttonPane.relocate(450, 0);
        startButton = createButton("Start");
        startButton.relocate(50, 200);
        buttonPane.getChildren().addAll(startButton);
        rootPane.getChildren().addAll(buttonPane);

    }

    void createLine() {
        line.setStartX(430);
        line.setStartY(30);
        line.setEndX(430);
        line.setEndY(430);
        line.setStrokeWidth(7);
        line.setFill(Color.BLACK);
    }

    public Pane getStartButton() {
        return startButton;
    }

    private Pane createButton(String buttonText) {
        return new Button("Start").getPane();
    }

}




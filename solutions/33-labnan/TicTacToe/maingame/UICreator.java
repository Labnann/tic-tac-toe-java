package maingame;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import theme.ClassicTheme;
import theme.ForestTheme;
import theme.Theme;


public class UICreator {
    private Theme theme = new ClassicTheme();
    private Line line = new Line();
    private BoardUI boardUi = new BoardUI();
    private Pane rootPane = new Pane();
    private Pane startButton;
    private Pane buttonPane = new Pane();
    private Stage gameRootStage;


    UICreator(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;
    }


    public void setBoardUi(BoardUI boardUi) {
        this.boardUi = boardUi;
    }

    public void createUI() {
        Scene rootScene = new Scene(rootPane, 750, 500);
        createLine();
        addButtons();
        rootPane.getChildren().addAll(boardUi.getBoardPane(), line, buttonPane);
        gameRootStage.setScene(rootScene);
        gameRootStage.show();
        boardUi.setTheme(theme);
        boardUi.setTheme(theme);
    }

    void addButtons() {
        buttonPane.relocate(450, 0);
        configureStartButton();
        configureForestThemeButton();
        configureClassicThemeButton();
        buttonPane.getChildren().addAll(startButton);

    }

    private void configureStartButton() {
        startButton = createButton("Start");
        startButton.relocate(50, 200);
    }

    private void configureClassicThemeButton() {
        Pane classicThemeButton = createButton("Theme: Classic");
        classicThemeButton.relocate(50, 250);
        buttonPane.getChildren().add(classicThemeButton);
        classicThemeButton.setOnMouseClicked(event -> {
            theme = new ClassicTheme();
            boardUi.setTheme(theme);
        });
    }

    private void configureForestThemeButton() {
        Pane forestThemeButton = createButton("Theme: Forest");
        forestThemeButton.relocate(50, 300);
        buttonPane.getChildren().add(forestThemeButton);

        forestThemeButton.setOnMouseClicked(event -> {
            theme = new ForestTheme();
            boardUi.setTheme(theme);
        });
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
        return new Button(buttonText).getPane();
    }

}


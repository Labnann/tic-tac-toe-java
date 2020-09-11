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
    private Theme theme;
    private Line line = new Line();
    private BoardUI boardUI;
    private Pane rootPane = new Pane();
    private Pane startButton;
    private Pane buttonPane = new Pane();
    private Stage gameRootStage;


    UICreator(Stage gameRootStage, BoardUI boardUI, Theme theme) {
        this.boardUI = boardUI;
        this.gameRootStage = gameRootStage;
        this.theme = theme;
    }

    public void createUI() {
        Scene rootScene = new Scene(rootPane, 750, 500);
        createLine();
        addButtons();
        rootPane.getChildren().addAll(boardUI.getBoardPane(), line, buttonPane);
        gameRootStage.setScene(rootScene);
        gameRootStage.show();
        boardUI.setTheme(theme);
        boardUI.setTheme(theme);
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
            boardUI.setTheme(theme);
        });
    }

    private void configureForestThemeButton() {
        Pane forestThemeButton = createButton("Theme: Forest");
        forestThemeButton.relocate(50, 300);
        buttonPane.getChildren().add(forestThemeButton);

        forestThemeButton.setOnMouseClicked(event -> {
            theme = new ForestTheme();
            boardUI.setTheme(theme);
        });
    }

    public Theme getTheme() {
        return theme;
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


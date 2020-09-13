package maingame;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import maingame.theme.ClassicTheme;
import maingame.theme.ForestTheme;
import maingame.theme.HighContrastTheme;
import maingame.theme.Theme;


public class UICreator {
    private Theme theme;
    private Line line = new Line();
    private BoardUI boardUI;
    private Pane rootPane = new Pane();
    private Pane randomAIStartButton;
    private Pane defensiveAIStartButton;
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
        theme.setRootPane(rootPane);

    }

    void addButtons() {
        buttonPane.relocate(450, 0);
        configureRandomAIStartButton();
        configureDefensiveAIStartButton();
        configureForestThemeButton();
        configureClassicThemeButton();
        configureHighContrastThemeButton();


    }


    private void configureRandomAIStartButton() {
        randomAIStartButton = createButton("Start with Random AI");
        randomAIStartButton.relocate(50, 100);
        buttonPane.getChildren().addAll(randomAIStartButton);
    }

    private void configureDefensiveAIStartButton() {
        defensiveAIStartButton = createButton("Start with Defensive AI");
        defensiveAIStartButton.relocate(50, 150);
        buttonPane.getChildren().addAll(defensiveAIStartButton);
    }

    public Pane getDefensiveAIStartButton() {
        return defensiveAIStartButton;
    }

    private void configureClassicThemeButton() {
        Pane classicThemeButton = createButton("Theme: Classic");
        classicThemeButton.relocate(50, 250);
        buttonPane.getChildren().add(classicThemeButton);
        classicThemeButton.setOnMouseClicked(event -> {
            theme = new ClassicTheme();
            boardUI.setTheme(theme);
            theme.setRootPane(rootPane);
        });
    }

    private void configureHighContrastThemeButton() {
        Pane classicThemeButton = createButton("Theme: High Contrast");
        classicThemeButton.relocate(50, 350);
        buttonPane.getChildren().add(classicThemeButton);
        classicThemeButton.setOnMouseClicked(event -> {
            theme = new HighContrastTheme();
            boardUI.setTheme(theme);
            theme.setRootPane(rootPane);
        });
    }


    private void configureForestThemeButton() {
        Pane forestThemeButton = createButton("Theme: Forest");
        forestThemeButton.relocate(50, 300);
        buttonPane.getChildren().add(forestThemeButton);

        forestThemeButton.setOnMouseClicked(event -> {
            theme = new ForestTheme();
            boardUI.setTheme(theme);
            theme.setRootPane(rootPane);
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

    public Pane getRandomAIStartButton() {
        return randomAIStartButton;
    }

    private Pane createButton(String buttonText) {
        return new Button(buttonText).getPane();
    }

}


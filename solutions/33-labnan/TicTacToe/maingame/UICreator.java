package maingame;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import maingame.theme.ClassicTheme;
import maingame.theme.ForestTheme;
import maingame.theme.HighContrastTheme;
import maingame.theme.Theme;
import maingame.winchecker.WinChecker;
import maingame.winchecker.WinResult;


public class UICreator {
    private Theme theme;
    private BoardUI boardUI;
    private Pane rootPane = new Pane();
    private Pane randomAIStartButton;
    private Pane defensiveAIStartButton;
    private Pane buttonPane = new Pane();
    private Stage gameRootStage;
    private Line winnerLine;
    private Line separatorLine;
    GameStarter gameStarter;



    UICreator(Stage gameRootStage, BoardUI boardUI, Theme theme, GameStarter gameStarter) {
        this.boardUI = boardUI;
        this.gameRootStage = gameRootStage;
        this.theme = theme;
        this.gameStarter = gameStarter;
    }

    public void createUI() {
        Scene rootScene = new Scene(rootPane, 750, 500);
        createSeparatorLine();
        addButtons();
        rootPane.getChildren().addAll(boardUI.getBoardPane(), buttonPane);
        gameRootStage.setScene(rootScene);
        gameRootStage.show();
        boardUI.setTheme(theme);
        boardUI.setTheme(theme);
        theme.setRootPane(rootPane);
        WinChecker winChecker= gameStarter.getWinChecker();
        winChecker.addOnGameEnd(() -> {
            makeWinnerLine(winChecker.getWinResult());
            gameStarter.stopAI();
        });


    }

    private void makeWinnerLine(WinResult winResult) {
        int startX = 70;
        int startY = 115;
        int endX = 320;
        int endY = 300;
        int factor = 110;
        Paint color = theme.getLineColor();
        if(winResult.getLineType()==LineType.ROW){
            winnerLine = createLine(new Point(startX,startY+ factor*winResult.getWinAt()+1),new Point(startX+endX,startY+ factor*winResult.getWinAt()+1),color);
        }
        if(winResult.getLineType()==LineType.COLUMN){
            winnerLine =createLine(new Point(startY+ factor*winResult.getWinAt()+1,startX),new Point(startY+ factor*winResult.getWinAt()+1,startX+endX),color);
        }
        if(winResult.getLineType()==LineType.DIAGONAL){
            winnerLine =createLine(new Point(startX,startY-45), new Point(endX+80,endY+95),color);
        }
        if(winResult.getLineType()==LineType.ANTI_DIAGONAL){
            winnerLine =createLine(new Point(startX+5,endY+70+20), new Point(endX+65,startY-45),color);
        }

    }

    private void createSeparatorLine() {
        separatorLine = createLine(new Point(430,30), new Point(430,430),theme.getLineColor());
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
            separatorLine.setStroke(theme.getLineColor());
            if(winnerLine!=null)
                winnerLine.setStroke(theme.getLineColor());
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
            separatorLine.setStroke(theme.getLineColor());
            if(winnerLine!=null)
                winnerLine.setStroke(theme.getLineColor());
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
            separatorLine.setStroke(theme.getLineColor());
            if(winnerLine!=null)
            winnerLine.setStroke(theme.getLineColor());
        });
    }

    public Theme getTheme() {
        return theme;
    }



    private Line createLine(Point start, Point end, Paint color) {
        Line line = new Line();
        line.setStartX(start.getX());
        line.setStartY(start.getY());
        line.setEndX(end.getX());
        line.setEndY(end.getY());
        line.setStrokeWidth(7);
        line.setStroke(color);
        line.toFront();
        rootPane.getChildren().add(line);
        return line;
    }

    public Pane getRandomAIStartButton() {
        return randomAIStartButton;
    }

    private Pane createButton(String buttonText) {
        return new Button(buttonText).getPane();
    }



}
 class Point{
    private int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}

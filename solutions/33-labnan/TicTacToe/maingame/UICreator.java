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
    GameStarter gameStarter;



    UICreator(Stage gameRootStage, BoardUI boardUI, Theme theme, GameStarter gameStarter) {
        this.boardUI = boardUI;
        this.gameRootStage = gameRootStage;
        this.theme = theme;
        this.gameStarter = gameStarter;
    }

    public void createUI() {
        Scene rootScene = new Scene(rootPane, 750, 500);
        createLines();
        addButtons();
        rootPane.getChildren().addAll(boardUI.getBoardPane(), buttonPane);
        gameRootStage.setScene(rootScene);
        gameRootStage.show();
        boardUI.setTheme(theme);
        boardUI.setTheme(theme);
        theme.setRootPane(rootPane);
        WinChecker winChecker= gameStarter.getWinChecker();
        winChecker.addOnGameEnd(() -> {
            System.out.println("Winner winner!...");
            makeWinnerLine(winChecker.getWinResult());
        });


    }

    private void makeWinnerLine(WinResult winResult) {
        System.out.println(winResult.getLineType()+" "+winResult.getWinAt());
        int startX = 70;
        int startY = 115;
        int endX = 320;
        int endY = 300;
        int factor = 110;
        Paint color = Color.RED;
        if(winResult.getLineType()==LineType.ROW){
            createLine(new Point(startX,startY+ factor*winResult.getWinAt()+1),new Point(startX+endX,startY+ factor*winResult.getWinAt()+1),color);
        }
        if(winResult.getLineType()==LineType.COLUMN){
            createLine(new Point(startY+ factor*winResult.getWinAt()+1,startX),new Point(startY+ factor*winResult.getWinAt()+1,startX+endX),color);
        }
        if(winResult.getLineType()==LineType.DIAGONAL){
            createLine(new Point(startX,startY-45), new Point(endX+50,endY+70),color);
        }
        if(winResult.getLineType()==LineType.ANTI_DIAGONAL){
            int i = 10;
            int j = 40-30;
            createLine(new Point(startX+15,endY+70+20), new Point(endX+40,startY-30),color);
        }

    }

    private void createLines() {
        createLine(new Point(430,30), new Point(430,430),theme.getLineColor());
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



    void createLine(Point start, Point end, Paint color) {
        Line line = new Line();
        line.setStartX(start.getX());
        line.setStartY(start.getY());
        line.setEndX(end.getX());
        line.setEndY(end.getY());
        line.setStrokeWidth(7);
        line.setFill(color);
        System.out.println(line.getFill());
        line.toFront();
        rootPane.getChildren().add(line);
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

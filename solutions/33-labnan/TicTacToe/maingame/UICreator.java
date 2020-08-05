package maingame;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class UICreator {
    Theme theme = new Theme();
    Line line = new Line();
    private Board board = new Board();
    private Pane rootPane = new Pane();
    private Pane startButton;
    private Pane buttonPane = new Pane();
    private Pane changeThemeButton;
    private Stage gameRootStage;


    UICreator(Stage gameRootStage) {
        this.gameRootStage = gameRootStage;

    }

    public Pane getChangeThemeButton() {
        return changeThemeButton;
    }

    public Board getBoard() {
        return board;
    }

    public void createUI() {
        Scene rootScene = new Scene(rootPane, 750, 500);
        board.setTheme(theme);
        createLine();
        addButtons();
        rootPane.getChildren().addAll(board.getBoardPane(), line, buttonPane);
        gameRootStage.setScene(rootScene);
        gameRootStage.show();
    }

    void addButtons() {
        buttonPane.relocate(450, 0);
        startButton = createButton("Start");
        changeThemeButton = createButton("Change Theme");
        startButton.relocate(50, 200);
        changeThemeButton.relocate(50, 250);
        buttonPane.getChildren().addAll(startButton, changeThemeButton);


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

class Theme {
    Text text;
    Rectangle rectangle = new Rectangle(100, 100);

    Theme() {
        this.text = new Text(" ");
        manageInnerText();
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Text getText() {
        return this.text;
    }

    private void manageInnerText() {
        text.toFront();
        Font textFont = new Font("Arial_Bold", 60);
        text.relocate(rectangle.getWidth() / 2 - textFont.getSize() / 3, rectangle.getHeight() / 2);
        text.setFont(textFont);
    }

    public String getCross() {
        return "X";
    }

    public String getZero() {
        return "O";
    }
}

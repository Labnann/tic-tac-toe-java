package theme;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ClassicTheme implements Theme {
    Text text;
    Rectangle boardRectangle = new Rectangle(100, 100);
    Pane squarePane = new Pane();
    Pane boardPane = new Pane();

    public ClassicTheme() {
        this.text = new Text(" ");
        boardRectangle.setFill(Color.WHITE);
        boardPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        manageInnerText();
    }

    public Pane getBoardPane() {
        return boardPane;
    }

    public Rectangle getBoardRectangle() {
        return boardRectangle;
    }

    public Pane getSquarePane() {
        return squarePane;
    }

    public Text getText() {
        return this.text;
    }

    private void manageInnerText() {
        text.toFront();
        Font textFont = new Font("Arial_Bold", 60);
        text.relocate(boardRectangle.getWidth() / 2 - textFont.getSize() / 3, boardRectangle.getHeight() / 2);
        text.setFont(textFont);
    }

    public String getCross() {
        return "X";
    }

    public String getZero() {
        return "O";
    }
}
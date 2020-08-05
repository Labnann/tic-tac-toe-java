package theme;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ForestTheme implements Theme {

    Text text;
    Rectangle boardRectangle = new Rectangle(100, 100);
    Pane squarePane = new Pane();
    Pane boardPane = new Pane();

    public ForestTheme() {
        this.text = new Text(" ");
        boardRectangle.setFill(Color.DARKGREEN);
        boardPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
        manageInnerText();

    }

    @Override
    public String getCross() {
        return "🌸";
    }

    private void manageInnerText() {
        text.toFront();
        Font textFont = new Font("Segoe_UI_Symbol", 60);
        text.relocate(boardRectangle.getWidth() / 2 - textFont.getSize() / 3, boardRectangle.getHeight() / 2);
        text.setFont(textFont);
    }

    @Override
    public String getZero() {
        return "🍊";
    }

    @Override
    public Text getText() {
        return this.text;
    }

    @Override
    public Pane getSquarePane() {
        return squarePane;
    }

    @Override
    public Rectangle getBoardRectangle() {
        return boardRectangle;
    }

    @Override
    public Pane getBoardPane() {
        return boardPane;
    }
}

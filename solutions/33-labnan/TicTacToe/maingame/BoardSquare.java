package maingame;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class BoardSquare {
    private Rectangle rectangle = new Rectangle(100, 100);
    private Pane squarePane = new Pane();
    boolean isTriggered = false;
    Text text = new Text(" ");
    private PlaceValue placeValue;

    public PlaceValue getPlaceValue() {
        return placeValue;
    }

    public BoardSquare(int xAxisIndex, int yAxisIndex) {
        squarePane.relocate((xAxisIndex * 110), (yAxisIndex * 110));
        rectangle.setFill(Color.WHITE);
        manageInnerText();
        squarePane.getChildren().addAll(rectangle, text);
    }

    public boolean isNotTriggered() {
        return !isTriggered;
    }

    private void manageInnerText() {
        text.toFront();
        Font textFont = new Font("Arial_Bold", 60);
        text.relocate(rectangle.getWidth() / 2 - textFont.getSize() / 3, rectangle.getHeight() / 2);
        text.setFont(textFont);
    }

    public void triggerSquareAs(PlaceValue placeValue) {
        if (this.isNotTriggered()) {
            this.placeValue = placeValue;
            if (placeValue == PlaceValue.CROSS)
                setText("X");
            else setText("O");
            isTriggered = true;
        }
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public Pane getSquarePane() {
        return squarePane;
    }


    enum PlaceValue {
        ZERO, CROSS
    }


}



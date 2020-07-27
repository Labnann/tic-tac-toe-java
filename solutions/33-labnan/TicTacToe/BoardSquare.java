import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BoardSquare {
    Rectangle rectangle = new Rectangle(100, 100);
    Pane squarePane = new Pane();
    Text text = new Text("A");

    PlaceValue placeValue = PlaceValue.NOTHING;

    public BoardSquare(int xAxisIndex, int yAxisIndex) {
        squarePane.relocate((xAxisIndex * 110), (yAxisIndex * 110));
        rectangle.setFill(Color.WHITE);
        manageInnerText();
        squarePane.getChildren().addAll(rectangle, text);


    }


    private void manageInnerText() {
        text.toFront();
        int FONT_SIZE = 50;
        text.relocate(rectangle.getWidth() / 2 - FONT_SIZE / 2.0, rectangle.getHeight() / 2);
        text.setFont(new Font(FONT_SIZE));
    }

    public void setPlaceValue(PlaceValue placeValue) {
        this.placeValue = placeValue;
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public Pane getSquarePane() {
        return squarePane;
    }


    enum PlaceValue {
        NOTHING, ZERO, CROSS
    }

}


class BoardSquareTest {
    @Test
    void testPlaceValue() {
        BoardSquare square = new BoardSquare(0, 0);
        Assertions.assertEquals(square.getSquarePane().getHeight(), 100);

    }

}
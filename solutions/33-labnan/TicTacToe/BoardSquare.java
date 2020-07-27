import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardSquare{
    Rectangle rectangle = new Rectangle(100,100);
    PlaceValue placeValue = PlaceValue.NOTHING;

    public BoardSquare(int xAxisIndex, int yAxisIndex) {
        rectangle.relocate((xAxisIndex * 110), (yAxisIndex * 110));
        rectangle.setFill(Color.WHITE);

    }

    public void setPlaceValue(PlaceValue placeValue) {
        this.placeValue = placeValue;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }


    enum PlaceValue{
        NOTHING, ZERO, CROSS
    }

}


class BoardSquareTest {
    @Test
    void testPlaceValue() {
        BoardSquare square = new BoardSquare(0, 0);
        Assertions.assertEquals(square.getRectangle().getHeight(), 100);

    }

}
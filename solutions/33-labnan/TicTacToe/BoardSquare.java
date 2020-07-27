import javafx.scene.shape.Rectangle;

public class BoardSquare{
    Rectangle rectangle = new Rectangle(100,100);
    PlaceValue placeValue = PlaceValue.NOTHING;

    public BoardSquare(int xAxisIndex, int yAxisIndex) {
        rectangle.relocate(xAxisIndex*100,yAxisIndex*100);
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

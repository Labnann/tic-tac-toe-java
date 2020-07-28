import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class BoardSquareTest {
    BoardSquare square = new BoardSquare(0, 0);

    @BeforeClass
    public static void setup() throws InterruptedException {
        JavaFXInitializer.initialize();
    }

    @Test
    public void getSquareIsTriggeredTest() {

        square.triggerSquareAs(BoardSquare.PlaceValue.CROSS);
        Assertions.assertFalse(square.isNotTriggered());
    }

    @Test
    public void getSquarePlaceValueTest() {
        Assertions.assertEquals(square.getPlaceValue(), null);
        square.triggerSquareAs(BoardSquare.PlaceValue.CROSS);
        Assertions.assertEquals(BoardSquare.PlaceValue.CROSS, square.getPlaceValue());
        square.triggerSquareAs(BoardSquare.PlaceValue.ZERO);
        Assertions.assertEquals(BoardSquare.PlaceValue.CROSS, square.getPlaceValue());
        square = new BoardSquare(0, 0);
        square.triggerSquareAs(BoardSquare.PlaceValue.ZERO);
        Assertions.assertEquals(BoardSquare.PlaceValue.ZERO, square.getPlaceValue());
        square.triggerSquareAs(BoardSquare.PlaceValue.CROSS);
        Assertions.assertEquals(BoardSquare.PlaceValue.ZERO, square.getPlaceValue());
    }


}

package maingame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BoardTest {
    Board board = new Board(BoardSquare.PlaceValue.CROSS);
    BoardSquare[][] boardSquares = board.getBoardSquares();

    @BeforeClass
    public static void setup() throws InterruptedException {
        JavaFXInitializer.initialize();
    }

    @Test
    public void testBoardSquareDoubleTrigger() {

        doubleTrigger(0, 0);
        Assertions.assertEquals(boardSquares[0][0].getPlaceValue(), BoardSquare.PlaceValue.CROSS);
    }

    private void doubleTrigger(int i, int j) {
        board.triggerSquare(boardSquares[0][i]);
        board.triggerSquare(boardSquares[0][j]);
    }

    @Test
    public void testBoardSquareSecondTrigger() {

        doubleTrigger(0, 1);
        Assertions.assertEquals(boardSquares[0][1].getPlaceValue(), BoardSquare.PlaceValue.ZERO);
    }


}

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

        simultaneouslyTrigger(0, 0);
        Assertions.assertEquals(BoardSquare.PlaceValue.CROSS, boardSquares[0][0].getPlaceValue());
    }

    private void simultaneouslyTrigger(int i, int j) {
        board.triggerSquare(boardSquares[0][i]);
        board.triggerSquare(boardSquares[0][j]);
    }

    @Test
    public void testBoardSquareSecondTrigger() {

        simultaneouslyTrigger(0, 1);
        Assertions.assertEquals(BoardSquare.PlaceValue.ZERO, boardSquares[0][1].getPlaceValue());
    }

    @Test
    public void testSetStartingTurn() {
        board.setStartingTurn(BoardSquare.PlaceValue.ZERO);
        simultaneouslyTrigger(0, 1);
        Assertions.assertEquals(BoardSquare.PlaceValue.ZERO, boardSquares[0][0].getPlaceValue());
        Assertions.assertEquals(BoardSquare.PlaceValue.CROSS, boardSquares[0][1].getPlaceValue());
    }


}

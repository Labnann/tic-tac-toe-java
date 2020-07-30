package maingame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BoardTest {
    Board board = new Board();
    BoardSquare[][] boardSquares = board.getBoardSquares();

    @BeforeClass
    public static void setup() throws InterruptedException {
        JavaFXInitializer.initialize();
    }

    @Test
    public void testBoardSquareDoubleTrigger() {

        simultaneouslyTrigger(0, 0);
        Assertions.assertEquals(Turn.CROSS, boardSquares[0][0].getTurn());
    }

    private void simultaneouslyTrigger(int i, int j) {
        board.triggerSquare(boardSquares[0][i]);
        board.triggerSquare(boardSquares[0][j]);
    }

    @Test
    public void testBoardSquareSecondTrigger() {

        simultaneouslyTrigger(0, 1);
        Assertions.assertEquals(Turn.ZERO, boardSquares[0][1].getTurn());
    }

    @Test
    public void testSetStartingTurn() {
        board.setStartingTurn(Turn.ZERO);
        simultaneouslyTrigger(0, 1);
        Assertions.assertEquals(Turn.ZERO, boardSquares[0][0].getTurn());
        Assertions.assertEquals(Turn.CROSS, boardSquares[0][1].getTurn());
    }


}

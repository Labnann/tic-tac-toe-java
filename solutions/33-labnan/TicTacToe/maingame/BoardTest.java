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
        Assertions.assertEquals(LogicBasedBox.Type.CROSS, boardSquares[0][0].getTurnType());
    }

    private void simultaneouslyTrigger(int i, int j) {
        board.triggerSquare(boardSquares[0][i]);
        board.triggerSquare(boardSquares[0][j]);
    }

    @Test
    public void testBoardSquareSecondTrigger() {

        simultaneouslyTrigger(0, 1);
        Assertions.assertEquals(LogicBasedBox.Type.ZERO, boardSquares[0][1].getTurnType());
    }

    @Test
    public void testSetStartingTurn() {
        board.setStartingTurn(LogicBasedBox.Type.ZERO);
        simultaneouslyTrigger(0, 1);
        Assertions.assertEquals(LogicBasedBox.Type.ZERO, boardSquares[0][0].getTurnType());
        Assertions.assertEquals(LogicBasedBox.Type.CROSS, boardSquares[0][1].getTurnType());
    }


}

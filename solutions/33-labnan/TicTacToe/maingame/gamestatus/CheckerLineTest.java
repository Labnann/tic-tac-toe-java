package maingame.gamestatus;

import maingame.LineType;
import maingame.PlayerMark;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CheckerLineTest {
    @Test
    public void checkMarkingOver2(){
        CheckerLine checkerLine = new CheckerLine(LineType.ROW,0);
        checkerLine.mark(PlayerMark.HUMAN);
        checkerLine.mark(PlayerMark.HUMAN);
        checkerLine.mark(PlayerMark.HUMAN);
        checkerLine.mark(PlayerMark.HUMAN);
        Assertions.assertEquals(3,checkerLine.getCount());
    }
}

package maingame.gamestatus;

import maingame.LineType;
import maingame.PlayerMark.ZeroMark;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CheckerLineTest {
    @Test
    public void checkMarkingOver2(){
        CheckerLine checkerLine = new CheckerLine(LineType.ROW,0);
        checkerLine.mark(new ZeroMark());
        checkerLine.mark(new ZeroMark());
        checkerLine.mark(new ZeroMark());
        checkerLine.mark(new ZeroMark());
        Assertions.assertEquals(3,checkerLine.getCount());
    }
}

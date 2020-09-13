package maingame.player;

import maingame.Board;
import maingame.PlayerMark;
import maingame.SmallCell;
import maingame.gamestatus.GamePlayStatus;
import maingame.gamestatus.GameStatus;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DefensiveAITest {
    SmallCell[][] smallCells;
    Human human;
    DefensiveAI defensiveAI;

    @Test
    public void defensiveAIatDiagonalTest(){
        initialize();
        defensiveAI.start();
        smallCells[0][0].triggerSquareAs(PlayerMark.HUMAN);
        human.placeMark(1,1);
        Assertions.assertEquals(smallCells[2][2].getTurnType(),PlayerMark.AI);

        initialize();
        defensiveAI.start();
        smallCells[1][1].triggerSquareAs(PlayerMark.HUMAN);
        human.placeMark(2,2);
        Assertions.assertEquals(smallCells[0][0].getTurnType(),PlayerMark.AI);

        initialize();
        defensiveAI.start();
        smallCells[0][0].triggerSquareAs(PlayerMark.HUMAN);
        human.placeMark(2,2);
        Assertions.assertEquals(smallCells[1][1].getTurnType(),PlayerMark.AI);
    }

    @Test
    public void testColumn(){
        initialize();
        int i = 0;
        defensiveAI.start();
        smallCells[0][i].triggerSquareAs(PlayerMark.HUMAN);
        human.placeMark(2,i);
        Assertions.assertEquals(smallCells[1][i].getTurnType(),PlayerMark.AI);


        initialize();
        i++;
        defensiveAI.start();
        smallCells[0][i].triggerSquareAs(PlayerMark.HUMAN);
        human.placeMark(2,i);
        Assertions.assertEquals(smallCells[1][i].getTurnType(),PlayerMark.AI);


        initialize();
        i++;
        defensiveAI.start();
        smallCells[0][i].triggerSquareAs(PlayerMark.HUMAN);
        human.placeMark(2,i);
        Assertions.assertEquals(smallCells[1][i].getTurnType(),PlayerMark.AI);


    }
    @Test
    public void testRow(){
        initialize();
        int i = 0;
        defensiveAI.start();
        smallCells[i][0].triggerSquareAs(PlayerMark.HUMAN);
        human.placeMark(i,2);
        Assertions.assertEquals(smallCells[i][1].getTurnType(),PlayerMark.AI);


        initialize();
        i++;
        defensiveAI.start();
        human.placeMark(i,0);
        human.placeMark(i,2);
        Assertions.assertEquals(smallCells[i][1].getTurnType(),PlayerMark.AI);

        initialize();
        i++;
        defensiveAI.start();
        human.placeMark(i,0);
        human.placeMark(i,2);
        Assertions.assertEquals(smallCells[i][1].getTurnType(),PlayerMark.AI);

    }

    @Test
    public void antiDiagonalTest(){
        initialize();
        defensiveAI.start();
        smallCells[2][0].triggerSquareAs(PlayerMark.HUMAN);
        human.placeMark(0,2);
        Assertions.assertEquals(PlayerMark.AI,smallCells[1][1].getTurnType());

        initialize();
        defensiveAI.start();
        smallCells[2][0].triggerSquareAs(PlayerMark.HUMAN);
        human.placeMark(0,2);
        Assertions.assertEquals(PlayerMark.AI,smallCells[1][1].getTurnType());

    }


    void initialize(){
       smallCells = new Board().getSmallCells();
       human = new HumanPlayer(smallCells);
       defensiveAI = new DefensiveAI(human,smallCells,new GamePlayStatus(smallCells));
    }
}

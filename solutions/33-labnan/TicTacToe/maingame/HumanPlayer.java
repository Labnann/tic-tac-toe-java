package maingame;

public class HumanPlayer implements Player{

    SmallCell[][] smallCells;
    public HumanPlayer(SmallCell[][] smallCells){
        this.smallCells = smallCells;
    }

    @Override
    public void move(int x, int y) {
        smallCells[x][y].triggerSquareAs(PlayerMark.HUMAN);
    }
}

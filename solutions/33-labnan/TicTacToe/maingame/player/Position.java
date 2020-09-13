package maingame.player;

public class Position {
    private int rowNum;
    private int columnNum;

    public int getRowNum() {
        return rowNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    Position(int rowNum, int columnNum){
        this.rowNum = rowNum;
        this.columnNum = columnNum;
    }
}

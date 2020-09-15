package maingame;

public class Position {
    private int rowNum;
    private int columnNum;

    public int getRowNum() {
        return rowNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public Position(int rowNum, int columnNum){
        if(rowNum>2||columnNum>2||rowNum<0||columnNum<0)
            throw new IllegalArgumentException("Scope of rowNumber and columnNumber is 0 to 2");
        this.rowNum = rowNum;
        this.columnNum = columnNum;
    }
}
